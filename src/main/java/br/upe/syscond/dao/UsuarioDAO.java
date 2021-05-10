package br.upe.syscond.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.upe.syscond.models.Usuario;

public class UsuarioDAO implements InterfaceUsuario {

    /**
     * 
     * @variavel --> Variavel gobal instance do tipo UsuarioDAO e variavel em do tipo EntityManager..
     */
	private static UsuarioDAO instance;
	protected EntityManager em;
	
    /**
     * 
     * @return instance --> Retorno do estanciamento do UsuarioDAO.
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
     * @return EntityManager--> retorno de qualquer identidade de entidade persistente.
     */
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		
		if (em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}
	
	/**
	 * @param --> O metodo buscar recebe um parametro id do tipo integer para realizar uma busca no banco de dados do apartamento desejado.
	 * @return--> Caso a operação  de Buscar seja bem sucedida, ela retona o usuario relacionado ao id digitado que devera estar no Banco de dados. 
	 * @throws Exception--> se apoeração de busca falhar, sera lançada uma Exception.
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
	
	/**
	 * @param --> O metodo buscar recebe um parametro user -com todos os atributos internalizados- do tipo usuario para realizar uma busca no banco de dados do usuario desejado.
	 * @return--> Caso a operação  de Buscar seja bem sucedida, ela retona o usuario solicitado que esta no Banco de dados. 
	 * @throws Exception--> se apoeração de buscar falhar, sera lançada uma Exception.
	 */	
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
	 * @param --> O metodo salvar recebe um parametro user-com todos os atributos internalizados- do tipo Usuario para salvar no banco de dados.
	 * @return--> Caso a operação de salva seja bem sucedida, ela retona um usuario novo salvo no banco de dados.
	 * @throws--> se apoeração  de salva falhar, sera lançada uma Exception.
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
	 * @param --> O metodo atualizar recebe um parametro user-com um ou diversos atributos internalizados- do tipo Usuario para atualizar o Usuario antigo no banco de dados.
	 * @return--> Caso a operação de atualizar seja bem sucedida, ela retona o Usuario antigo com as informações atualizadas no banco de dados.
	 * @throws--> se apoeração  de atualizar falhar, sera lançada uma Exception.
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
	 * @param --> O metodo deletar recebe um parametro user-com todos os atibutos internalizados- do tipo Usuario para exclusão do usuario exitente no banco de dados.
	 * @throws--> se apoeração  de deletar falhar, sera lançada uma Exception.
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
	 * @return--> Caso a operação de listar seja bem sucedida, ela retona uma lista com todos os uuarios salvos no banco de dados.
	 * @throws--> se apoeração de listar falhar, sera lançada uma Exception.
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
