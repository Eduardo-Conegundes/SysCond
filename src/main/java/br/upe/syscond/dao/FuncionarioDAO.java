package br.upe.syscond.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.syscond.models.Funcionario;

public class FuncionarioDAO implements InterfaceFuncionario {
    
    private static FuncionarioDAO instance;
    protected EntityManager em;
    /**
     * 
     * @return instance
     */	    
    public static FuncionarioDAO getInstance() {
        if (instance == null) {
            instance = new FuncionarioDAO();
        }
        return instance;
    }

    private FuncionarioDAO() {
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
	 * @return Funcionario
	 */    
    public Funcionario buscar(int id) throws Exception {
        Funcionario f = null;
        try {
            em.getTransaction().begin();
            f = em.find(Funcionario.class, id);
            em.getTransaction().commit();
            return f;
        } catch (Exception eAtualizar) {
            em.getTransaction().rollback();
            throw eAtualizar;
        }
    }
    /**
     * @param Funcionario
	 * @return Funcionario
	 */
    public Funcionario salvar(Funcionario funcionario) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(funcionario);
            em.getTransaction().commit();
            return this.buscar(funcionario.getId());
        } catch (Exception eSalvar) {
            em.getTransaction().rollback();
            throw eSalvar;
        }
    }
     /**
     * @param Funcionario
	 * @return Funcionario
	 */   
    public Funcionario atualizar(Funcionario funcionario) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(funcionario);
            em.getTransaction().commit();
            return this.buscar(funcionario.getId());
        } catch (Exception eAtualizar) {
            em.getTransaction().rollback();
            throw eAtualizar;
        }
    }
    /**
     * @param integer
	 * @return boolean
	 */
    public void deletar(int id) throws Exception {
        Funcionario f = null;
        try {
            em.getTransaction().begin();
            f = em.find(Funcionario.class, id);
            em.remove(f);
            em.getTransaction().commit();
        } catch (Exception eDeletar) {
            em.getTransaction().rollback();
            throw eDeletar;
        }
    }
    /**
	 * @return Lista de Funcionario[]
	 */
    @SuppressWarnings("unchecked")
	public List<Funcionario> listar() {
        try {
        	return (em.createQuery("from " + Funcionario.class.getName()).getResultList());
		} catch (Exception eListar) {
			 throw eListar;
		}
    }


}
