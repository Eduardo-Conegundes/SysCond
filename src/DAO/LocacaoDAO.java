/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Espaco;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DAO.Interface.InterfaceLocacao;


public class LocacaoDAO implements InterfaceLocacao {

	private static LocacaoDAO instance;
	protected EntityManager em;

	public static LocacaoDAO getInstance() {
		if (instance == null) {
			instance = new LocacaoDAO();
		}
		return instance;
	}

	private LocacaoDAO() {
		em = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		if (em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}

	public Espaco buscar(int id) throws Exception {
		Espaco l = null;
		try {
			em.getTransaction().begin();
			l = em.find(Espaco.class, id);
			em.getTransaction().commit();
			return l;
		} catch (Exception eBuscar) {
			em.getTransaction().rollback();
			throw eBuscar;
		}
	}

	public Espaco salvar(Espaco l) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(l);
			em.getTransaction().commit();
			return buscar(l.getId());
		} catch (Exception eSalvar) {
			em.getTransaction().rollback();
			throw eSalvar;
		}
	}

	public Espaco atualizar(Espaco l) throws Exception {
		try {
			em.getTransaction().begin();
			em.merge(l);
			em.getTransaction().commit();
			return buscar(l.getId());
		} catch (Exception eAtualizar) {
			em.getTransaction().rollback();
			throw eAtualizar;
		}
	}

	public void deletar(int id) throws Exception {
		Espaco l = null;
		try {
			em.getTransaction().begin();
			l = em.find(Espaco.class, id);
			em.remove(l);
			em.getTransaction().commit();
		} catch (Exception eDeletar) {
			em.getTransaction().rollback();
			throw eDeletar;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Espaco> listar() {
		try {
			return (em.createQuery("from " + Espaco.class.getName()).getResultList());
		} catch (Exception eListar) {
			throw eListar;
		}

	}

}
