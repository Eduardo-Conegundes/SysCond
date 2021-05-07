package br.upe.syscond.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.syscond.models.Almoxarifado;


public class AlmoxarifadoDAO implements InterfaceEstoque {

	private static AlmoxarifadoDAO instance;
	protected EntityManager em;
	/**
	 * 
	 * @return instance
	 */
	public static AlmoxarifadoDAO getInstance() {
		if (instance == null) {
			instance = new AlmoxarifadoDAO();
		}
		return instance;
	}
	
	private AlmoxarifadoDAO() {
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
	 * 
	 * @param id
	 * @return Almoxarifado
	 */
	public Almoxarifado buscar(int id) {
		Almoxarifado p = null;
		try {
			em.getTransaction().begin();
			p = em.find(Almoxarifado.class, id);
			em.getTransaction().commit();
			return p;
		} catch(Exception eBuscar) {
			em.getTransaction().rollback();
			throw eBuscar;
		}
	}
	/**
	 * 
	 * @param Almoxarifado
	 * @return Almoxarifado
	 */
	public Almoxarifado salvar(Almoxarifado almoxarifado) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(almoxarifado);
			em.getTransaction().commit();
			return this.buscar(almoxarifado.getId());
		} catch (Exception eSalvar) {
			em.getTransaction().rollback();
			throw eSalvar;
		}
	}
	/**
	 * 
	 * @param Almoxarifado
	 *
	 */
	public void atualizar(Almoxarifado F) throws Exception {
		try {
			em.getTransaction().begin();
			em.merge(F);
			em.getTransaction().commit();
		} catch (Exception eAtualizar) {
			em.getTransaction().rollback();
			throw eAtualizar;
		}
	}
	/**
	 * 
	 * @param Almoxarifado
	 *
	 */
	public void deletar(Almoxarifado F) throws Exception {
		Almoxarifado est = null;
		try {
			em.getTransaction().begin();
			est = em.find(Almoxarifado.class, F);
			em.remove(est);
			em.getTransaction().commit();
		} catch (Exception eDeletar) {
			em.getTransaction().rollback();
			throw eDeletar;
		}
	}
/**
 * @return Almoxarifado[]
 */
	@SuppressWarnings("unchecked")
	public List<Almoxarifado> listar() {
		try {
			return (em.createQuery("from " + Almoxarifado.class.getName()).getResultList());	
		} catch (Exception eListar) {
			throw eListar;
		}
	}

}
