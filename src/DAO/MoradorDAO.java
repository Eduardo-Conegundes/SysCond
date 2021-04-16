package DAO;

import Models.Morador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DAO.Interface.InterfaceMorador;


public class MoradorDAO implements InterfaceMorador{

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
		} catch (Exception eSalvar) {
			em.getTransaction().rollback();
			throw eSalvar;
		}
	}
	
	public Morador buscar(String cpf) throws Exception {
		Morador m = null;
		try {
			em.getTransaction().begin();
			m = em.find(Morador.class, cpf);
			em.getTransaction().commit();
			return m;
		} catch (Exception eBuscar) {
			em.getTransaction().rollback();
			throw eBuscar;
		}
	}

	public Morador atualizar(Morador morador) throws Exception {
		try {
			em.getTransaction().begin();
			em.merge(morador);
			em.getTransaction().commit();
			return buscar(morador.getPessoa().getCpf());
		} catch (Exception eAtualizar) {
			em.getTransaction().rollback();
			throw eAtualizar;
		}
	}

	public void deletar(String cpf) throws Exception {
		Morador m = null;
		try {
			em.getTransaction().begin();
			m = em.find(Morador.class, cpf);
			em.remove(m);
			em.getTransaction().commit();
		} catch (Exception eDeletar) {
			em.getTransaction().rollback();
			throw eDeletar;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Morador> listar() throws Exception {
		try {
			return (em.createQuery("from " + Morador.class.getName()).getResultList());			
		} catch (Exception eListar) {
			throw eListar;
		}
	}
}
