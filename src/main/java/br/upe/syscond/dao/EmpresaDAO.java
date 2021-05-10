package br.upe.syscond.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.syscond.models.Empresa;

public class EmpresaDAO implements InterfaceEmpresa {
	private static EmpresaDAO instance;
	protected EntityManager em;
    /**
     * 
     * @return instance
     */
	public static EmpresaDAO getInstance() {
		if (instance == null) {
			instance = new EmpresaDAO();
		}
		return instance;
	}

	private EmpresaDAO() {
		em = getEntityManager();
	}
    /**
     * 
     * @return EntityManager
     */
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		if (em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}
    /**
     * @param Empresa
	 * @return Empresa
	 */  
	public Empresa salvar(Empresa E) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(E);
			em.flush();
			em.getTransaction().commit();
			return E;
		} catch (Exception eSalvar) {
			em.getTransaction().rollback();
			throw eSalvar;
		}
	}
    /**
     * @param Empresa
	 * @return Empresa
	 */  
	public Empresa atualizar(Empresa E) throws Exception {
		try {
			em.getTransaction().begin();
			em.merge(E);
			em.flush();
			em.getTransaction().commit();
			return E;
		} catch (Exception eAtualizar) {
			em.getTransaction().rollback();
			throw eAtualizar;
		}
	}
    /**
     * @param integer
	 * @return boolean
	 */
	public void deletar(Empresa E) throws Exception {
		try {
			em.getTransaction().begin();
			em.remove(E);
			em.getTransaction().commit();
		} catch (Exception eDeletar) {
			em.getTransaction().rollback();
			throw eDeletar;
		}
	}
    /**
     * @param integer
	 * @return Empresa
	 */
	public Empresa buscar(Empresa empresa) throws Exception {
		try {
			return (Empresa) em.createQuery("from Empresa e where e.nome =:nome and e.telefone =:telefone and e.cnpj =:cnpj")
					.setParameter("nome", empresa.getNome())
					.setParameter("telefone", empresa.getTelefone())
					.setParameter("cnpj", empresa.getCnpj())
					.getSingleResult();
		} catch (Exception eBuscar) {
			throw eBuscar;
		}
	}
    /**
	 * @return Lista de Empresa[]
	 */
	@SuppressWarnings("unchecked")
	public List<Empresa> listar() {
		try {
			return (em.createQuery("from " + Empresa.class.getName()).getResultList());
		} catch (Exception eListar) {
			throw eListar;
		}
	}
}
