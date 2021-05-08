package br.upe.syscond.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.syscond.models.Morador;


public class MoradorDAO implements InterfaceMorador{

	private static MoradorDAO instance;
	protected EntityManager em;
    /**
     * 
     * @return instance
     */
	public static MoradorDAO getInstance() {
		if (instance == null) {
			instance = new MoradorDAO();
		}
		return instance;
	}

	private MoradorDAO() {
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
	 * param Apartamento
	 * @return Apartamento
	 */
	public Morador salvar(Morador morador) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(morador);
			em.flush();
			em.getTransaction().commit();
			return morador;
		} catch (Exception eSalvar) {
			em.getTransaction().rollback();
			throw eSalvar;
		}
	}
	/**
	 * param Morador
	 * @return Morador
	 */
	public Morador buscar(Morador morador) throws Exception {
		try {
			return (Morador) em.createQuery("From Morador m where m.pessoa = :pessoa and m.apartamento = :apartamento")
					.setParameter("pessoa", morador.getPessoa())
					.setParameter("apartamento", morador.getApartamento())
					.getSingleResult();
		} catch (Exception eBuscar) {
			throw eBuscar;
		}
	}
	/**
	 * param Morador
	 * @return Morador
	 */
	public Morador atualizar(Morador morador) throws Exception {
		
		try {
			em.getTransaction().begin();
			em.merge(morador);
			em.getTransaction().commit();
			return morador;
		} catch (Exception eAtualizar) {
			em.getTransaction().rollback();
			throw eAtualizar;
		}
	}
    /**
     * @param integer
	 * @return boolean
	 */
	public void deletar(Morador m) throws Exception {
		try {
			em.getTransaction().begin();
			em.remove(m);
			em.getTransaction().commit();
		} catch (Exception eDeletar) {
			em.getTransaction().rollback();
			throw eDeletar;
		}
	}
    /**
	 * @return Lista de Morador[]
	 */
	@SuppressWarnings("unchecked")
	public List<Morador> listar() throws Exception {
		try {
			return (em.createQuery("from " + Morador.class.getName()).getResultList());			
		} catch (Exception eListar) {
			throw eListar;
		}
	}
}
