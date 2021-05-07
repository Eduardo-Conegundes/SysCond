package br.upe.syscond.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.syscond.models.FluxoAlmoxarifado;



public class FluxoAlmoxarifadoDAO {
	private static FluxoAlmoxarifadoDAO instance;
	protected EntityManager em;
    /**
     * 
     * @return instance
     */
	public static FluxoAlmoxarifadoDAO getInstance() {
		if(instance == null) {
			instance = new FluxoAlmoxarifadoDAO();
		}
		return instance;
	}

	private FluxoAlmoxarifadoDAO() {
		em = getEntityManager();
	}
    /**
     * 
     * @return EntityManager
     */
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		if(em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}
    /**
     * @param FluxoAlmoxarifado
	 * @return FluxoAlmoxarifado
	 */
	public FluxoAlmoxarifado salvar(FluxoAlmoxarifado fluxo) throws Exception{
		try {
			em.getTransaction().begin();
			em.persist(fluxo);
			em.getTransaction().commit();
			return this.buscar(fluxo.getId());
		}catch(Exception eSalvar) {
			em.getTransaction().rollback();
			throw eSalvar;
		}
	}
    /**
     * @param FluxoAlmoxarifado
	 * @return FluxoAlmoxarifado
	 */
	public FluxoAlmoxarifado atualizar(FluxoAlmoxarifado fluxo) throws Exception{
		try {
			em.getTransaction().begin();
			em.merge(fluxo);
			em.getTransaction().commit();
			return this.buscar(fluxo.getId());
		}catch(Exception eAtualizar) {
			em.getTransaction().rollback();
			throw eAtualizar;
		}
	}
    /**
     * @param integer
	 * @return FluxoAlmoxarifado
	 */
	
	public FluxoAlmoxarifado buscar(int id) throws Exception{
		try {
			em.getTransaction().begin();
			FluxoAlmoxarifado fluxo = em.find(FluxoAlmoxarifado.class, id);
			em.getTransaction().commit();
			return fluxo;
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
		try {
			FluxoAlmoxarifado fluxo = buscar(id);
			deletarPorId(fluxo);
		} catch (Exception eDeletarId) {
			eDeletarId.printStackTrace();
			throw eDeletarId;
		}
	}
    /**
     * @param FluxoAlmoxarifado
	 * @return Bolean
	 */
	private void deletarPorId(FluxoAlmoxarifado fluxo) throws Exception{
		try {
			em.getTransaction().begin();
			FluxoAlmoxarifado fluxorecebido = em.find(FluxoAlmoxarifado.class, fluxo.getId());
			em.remove(fluxorecebido);
			em.getTransaction().commit();
		} catch(Exception eDeletar) {
			em.getTransaction().rollback();
			throw eDeletar;
		}
	}
    /**
	 * @return Lista de FluxoAlmoxarifado[]
	 */
	@SuppressWarnings("unchecked")
	public List<FluxoAlmoxarifado> listar() throws Exception{
		try {
			return (em.createQuery("from " + FluxoAlmoxarifado.class.getName()).getResultList());			
		} catch (Exception eListar) {
			throw eListar;
		}
	}


}
