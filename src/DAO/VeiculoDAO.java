package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Models.Pessoa;
import Models.Veiculo;

public class VeiculoDAO {
	private static VeiculoDAO instance;
	protected EntityManager em;

	public static VeiculoDAO getInstance() {
		if (instance == null) {
			instance = new VeiculoDAO();
		}
		return instance;
	}

	private VeiculoDAO() {
		em = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		if (em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}

	public Veiculo salvar(Veiculo veiculo) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(veiculo);
			em.getTransaction().commit();
			return veiculo;
		} catch (Exception eSalvar) {
			em.getTransaction().rollback();
			throw eSalvar;
		}

	}

	public Veiculo atualizar(Veiculo veiculo) throws Exception {
		try {
			em.getTransaction().begin();
			em.merge(veiculo);
			em.getTransaction().commit();
			return veiculo;
		} catch (Exception eAtualizar) {
			em.getTransaction().rollback();
			throw eAtualizar;
		}

	}

	public Veiculo buscar(String placa) throws Exception {
		try {
			em.getTransaction().begin();
			Veiculo p = em.find(Veiculo.class, placa);
			em.getTransaction().commit();
			return p;
		} catch(Exception eBuscar) {
			em.getTransaction().rollback();
			throw eBuscar;
		}
	}

	public void deletar(String placa) throws Exception {
		Veiculo v = null;
		try {
			em.getTransaction().begin();
			v = em.find(Veiculo.class, placa);
			em.remove(v);
			em.getTransaction().commit();
		} catch (Exception eDeletar) {
			em.getTransaction().rollback();
			throw eDeletar;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Veiculo> listar() throws Exception {
		try {
			return (em.createQuery("from " + Veiculo.class.getName()).getResultList());
		} catch (Exception eListar) {
			throw eListar;
		}
	}
}
