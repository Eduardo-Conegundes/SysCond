/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DAO.Interface.InterfaceUsuario;

public class UsuarioDAO implements InterfaceUsuario {

	private static UsuarioDAO instance;
	protected EntityManager em;

	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}
		return instance;
	}

	private UsuarioDAO() {
		em = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		if (em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}

	public Usuario buscar(int id) throws Exception {
		Usuario user = null;
		try {
			em.getTransaction().begin();
			user = em.find(Usuario.class, id);
			em.getTransaction().commit();
			return user;
		} catch (Exception eBuscar) {
			em.getTransaction().rollback();
			throw eBuscar;
		}
	}

	public Usuario salvar(Usuario user) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			return this.buscar(user.getId());
		} catch (Exception eSalvar) {
			em.getTransaction().rollback();
			throw eSalvar;
		}
	}

	public Usuario atualizar(Usuario user) throws Exception {
		try {
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
			return this.buscar(user.getId());
		} catch (Exception eAtualizar) {
			em.getTransaction().rollback();
			throw eAtualizar;
		}
	}

	public void deletar(int id) throws Exception {
		Usuario user = null;
		try {
			em.getTransaction().begin();
			user = em.find(Usuario.class, id);
			em.remove(user);
			em.getTransaction().commit();
		} catch (Exception eDeletar) {
			em.getTransaction().rollback();
			throw eDeletar;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		try {
			return (em.createQuery("from " + Usuario.class.getName()).getResultList());		
		} catch (Exception eListar) {
			throw eListar;
		}
	}

}
