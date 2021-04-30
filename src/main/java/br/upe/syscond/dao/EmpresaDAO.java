package br.upe.syscond.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.syscond.models.Empresa;

public class EmpresaDAO implements InterfaceEmpresa {
	private static EmpresaDAO instance;
	protected EntityManager em;

	public static EmpresaDAO getInstance() {
		if (instance == null) {
			instance = new EmpresaDAO();
		}
		return instance;
	}

	private EmpresaDAO() {
		em = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		if (em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}

	public Empresa salvar(Empresa E) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(E);
			em.getTransaction().commit();
			return buscar(E.getId());
		} catch (Exception eSalvar) {
			em.getTransaction().rollback();
			throw eSalvar;
		}
	}

	public Empresa atualizar(Empresa E) throws Exception {
		try {
			em.getTransaction().begin();
			em.merge(E);
			em.getTransaction().commit();
			return buscar(E.getId());
		} catch (Exception eAtualizar) {
			em.getTransaction().rollback();
			throw eAtualizar;
		}
	}

	public void deletar(int id) throws Exception {
		Empresa E = null;
		try {
			em.getTransaction().begin();
			E = em.find(Empresa.class, id);
			em.remove(E);
			em.getTransaction().commit();
		} catch (Exception eDeletar) {
			em.getTransaction().rollback();
			throw eDeletar;
		}
	}

	public Empresa buscar(int id) throws Exception {
		Empresa e = null;
		try {
			em.getTransaction().begin();
			e = em.find(Empresa.class, id);
			em.getTransaction().commit();
			return e;
		} catch (Exception eBuscar) {
			em.getTransaction().rollback();
			throw eBuscar;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Empresa> listar() {
		try {
			return (em.createQuery("from " + Empresa.class.getName()).getResultList());
		} catch (Exception eListar) {
			throw eListar;
		}
	}
}
