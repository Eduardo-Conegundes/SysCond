package br.upe.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.DAO.Interface.InterfaceContabil;
import br.upe.Models.Contabil;

public class ContabilDAO implements InterfaceContabil{
	private static ContabilDAO instance;
	protected EntityManager em;

	public static ContabilDAO getInstance() {
		if(instance == null) {
			instance = new ContabilDAO();
		}
		return instance;
	}

	private ContabilDAO() {
		em = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		if(em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}

	public Contabil salvar(Contabil contabil) throws Exception{
		try {
			em.getTransaction().begin();
			em.persist(contabil);
			em.getTransaction().commit();
			return this.buscar(contabil.getId());
		}catch(Exception eSalvar) {
			em.getTransaction().rollback();
			throw eSalvar;
		}
	}

	public Contabil atualizar(Contabil contabil) throws Exception{
		try {
			em.getTransaction().begin();
			em.merge(contabil);
			em.getTransaction().commit();
			return this.buscar(contabil.getId());
		}catch(Exception eAtualizar) {
			em.getTransaction().rollback();
			throw eAtualizar;
		}
	}

	public void deletar(int id) throws Exception{
		Contabil p = null;
		try {
			em.getTransaction().begin();
			p = em.find(Contabil.class, id);
			em.remove(p);
			em.getTransaction().commit();
		} catch(Exception eDeletar) {
			em.getTransaction().rollback();
			throw eDeletar;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Contabil> listar(){
		try {
			return (em.createQuery("from " + Contabil.class.getName()).getResultList());
		} catch (Exception eListar) {
			
			throw eListar;
		}
	}


	public Contabil buscar(int id) {
		Contabil p = null;
		try {
			em.getTransaction().begin();
			p = em.find(Contabil.class, id);
			em.getTransaction().commit();
			return p;
		} catch(Exception eBuscar) {
			em.getTransaction().rollback();
			throw eBuscar;
		}
	}
}
