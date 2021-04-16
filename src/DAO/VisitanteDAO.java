/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Models.Visitante;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DAO.Interface.InterfaceVisitante;


public class VisitanteDAO implements InterfaceVisitante {

	private static VisitanteDAO instance;
	protected EntityManager em;

	public static VisitanteDAO getInstance() {
		if (instance == null) {
			instance = new VisitanteDAO();
		}
		return instance;
	}

	private VisitanteDAO() {
		em = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		if (em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}

	public Visitante buscar(String cpf) throws Exception {
		Visitante v = null;
		try {
			em.getTransaction().begin();
			v = em.find(Visitante.class, cpf);
			em.getTransaction().commit();
			return v;
		} catch (Exception eBuscar) {
			em.getTransaction().rollback();
			throw eBuscar;
		}
	}

	public Visitante salvar(Visitante vis) throws Exception {

		try {
			em.getTransaction().begin();
			em.persist(vis);
			em.getTransaction().commit();
			return this.buscar(vis.getPessoa().getCpf());
		} catch (Exception eSalvar) {
			em.getTransaction().rollback();
			throw eSalvar;
		}

	}

	public Visitante atualizar(Visitante vis) throws Exception {
		try {
			em.getTransaction().begin();
			em.merge(vis);
			em.getTransaction().commit();
			return this.buscar(vis.getPessoa().getCpf());
		} catch (Exception eAtualizar) {
			em.getTransaction().rollback();
			throw eAtualizar;
		}
	}

	public void deletar(String cpf) throws Exception {
		Visitante vis = null;
		try {
			em.getTransaction().begin();
			vis = em.find(Visitante.class, cpf);
			em.remove(vis);
			em.getTransaction().commit();
		} catch (Exception eDeletar) {
			em.getTransaction().rollback();
			throw eDeletar;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Visitante> listar() {
		try {
			return (em.createQuery("from " + Visitante.class.getName()).getResultList());		
		} catch (Exception eListar) {
			throw eListar;
		}
	}

}
