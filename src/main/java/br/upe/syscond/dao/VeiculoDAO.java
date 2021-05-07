package br.upe.syscond.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.syscond.models.Veiculo;

public class VeiculoDAO implements InterfaceVeiculo{
	private static VeiculoDAO instance;
	protected EntityManager em;
    /**
     * 
     * @return instance
     */
	public static VeiculoDAO getInstance() {
		if (instance == null) {
			instance = new VeiculoDAO();
		}
		return instance;
	}

	private VeiculoDAO() {
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
     * @param Veiculo
	 * @return Veiculo
	 */
	public Veiculo salvar(Veiculo veiculo) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(veiculo);
			em.getTransaction().commit();
			return this.buscar(veiculo.getId());
		} catch (Exception eSalvar) {
			em.getTransaction().rollback();
			throw eSalvar;
		}

	}
    /**
     * @param Veiculo
	 * @return Veiculo
	 */  
	public Veiculo atualizar(Veiculo veiculo) throws Exception {
		try {
			em.getTransaction().begin();
			em.merge(veiculo);
			em.getTransaction().commit();
			return this.buscar(veiculo.getId());
		} catch (Exception eAtualizar) {
			em.getTransaction().rollback();
			throw eAtualizar;
		}

	}
    /**
     * @param integer
	 * @return Veiculo
	 */
	public Veiculo buscar(int id) throws Exception {
		try {
			em.getTransaction().begin();
			Veiculo p = em.find(Veiculo.class, id);
			em.getTransaction().commit();
			return p;
		} catch(Exception eBuscar) {
			em.getTransaction().rollback();
			throw eBuscar;
		}
	}
    /**
     * @param integer
	 * @return boolean
	 */
	public void deletar(int id) throws Exception {
		Veiculo v = null;
		try {
			em.getTransaction().begin();
			v = em.find(Veiculo.class, id);
			em.remove(v);
			em.getTransaction().commit();
		} catch (Exception eDeletar) {
			em.getTransaction().rollback();
			throw eDeletar;
		}
	}
    /**
	 * @return Lista de Veiculo[]
	 */
	@SuppressWarnings("unchecked")
	public List<Veiculo> listar() throws Exception {
		try {
			return (em.createQuery("from " + Veiculo.class.getName()).getResultList());
		} catch (Exception eListar) {
			throw eListar;
		}
	}
}
