package DAO;

import Models.Morador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class MoradorDAO{

	private static MoradorDAO instance;
	protected EntityManager em;

	public static MoradorDAO getInstance() {
		if (instance == null) {
			instance = new MoradorDAO();
		}
		return instance;
	}

	private MoradorDAO() {
		em = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		if (em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}

	public Morador salvar(Morador morador) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(morador);
			em.getTransaction().commit();
			return buscar(morador.getPessoa().getCpf());
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}
	
	public Morador buscar(String cpf) throws Exception {
		Morador m = null;
		try {
			em.getTransaction().begin();
			m = em.find(Morador.class, cpf);
			em.getTransaction().commit();
			return m;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	public Morador atualizar(Morador morador) throws Exception {
		try {
			em.getTransaction().begin();
			em.merge(morador);
			em.getTransaction().commit();
			return buscar(morador.getPessoa().getCpf());
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	public void deletar(String cpf) throws Exception {
		Morador m = null;
		try {
			em.getTransaction().begin();
			m = em.find(Morador.class, cpf);
			em.remove(m);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	public List<Morador> listar() throws Exception {
		try {
			return (em.createQuery("from " + Morador.class.getName()).getResultList());			
		} catch (Exception e) {
			throw e;
		}
	}
}
