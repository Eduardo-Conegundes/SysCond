package br.upe.syscond.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.syscond.models.Usuario;

public class UsuarioDAO implements InterfaceUsuario {

	private static UsuarioDAO instance;
	protected EntityManager em;
    /**
     * 
     * @return instance
     */
	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}
		return instance;
	}

	private UsuarioDAO() {
		em = getEntityManager();
	}
    /**
     * 
     * @return EntityManager
     */
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		
		if (em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}
    /**
     * @param integer
	 * @return Usuario
	 */
	public Usuario buscar(int id) throws Exception {
		try {
			em.getTransaction().begin();
			Usuario user = em.find(Usuario.class, id);
			em.getTransaction().commit();
			return user;
		} catch (Exception eBuscar) {
			em.getTransaction().rollback();
			throw eBuscar;
		}
	}
	
	public Usuario buscar(Usuario user) throws Exception {
		try {
			return (Usuario) em.createQuery("FROM Usuario u WHERE u.email = :email and u.senha = :senha")
					.setParameter("email", user.getEmail())
					.setParameter("senha", user.getSenha())
					.getSingleResult();
		} catch (Exception eBuscar) {
			throw eBuscar;
		}
		
	}
    /**
     * @param Usuario
	 * @return Usuario
	 */
	public Usuario salvar(Usuario user) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.flush();
			em.getTransaction().commit();
			return user;
		} catch (Exception eSalvar) {
			em.getTransaction().rollback();
			throw eSalvar;
		}
	}
    /**
     * @param Usuario
	 * @return Usuario
	 */
	public Usuario atualizar(Usuario user) throws Exception {
		try {
			em.getTransaction().begin();
			em.merge(user);
			em.flush();
			em.getTransaction().commit();
			return user;
		} catch (Exception eAtualizar) {
			em.getTransaction().rollback();
			throw eAtualizar;
		}
	}
    /**
     * @param integer
	 * @return boolean
	 */
	public void deletar(Usuario user) throws Exception {
		try {
			em.getTransaction().begin();
			em.remove(this.buscar(user));
			em.getTransaction().commit();
		} catch (Exception eDeletar) {
			em.getTransaction().rollback();
			throw eDeletar;
		}
	}
    /**
	 * @return Lista de Usuario[]
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> listar() throws Exception{
		try {
			return (em.createQuery("from " + Usuario.class.getName()).getResultList());		
		} catch (Exception eListar) {
			throw eListar;
		}
	}

}
