package br.upe.syscond.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.syscond.models.Funcionario;
import br.upe.syscond.models.Morador;

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
    public Funcionario buscar(Funcionario funcionario) throws Exception {
        try {
        	return (Funcionario) em.createQuery("From Funcionario f where f.pessoa = :pessoa and f.cargo = :cargo and f.salario = :salario and f.interno_externo = :interno_externo")
					.setParameter("pessoa", funcionario.getPessoa())
					.setParameter("cargo", funcionario.getCargo())
					.setParameter("salario", funcionario.getSalario())
					.setParameter("interno_externo", funcionario.getInterno_externo())
					.getSingleResult();
        } catch (Exception eAtualizar) {
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
            em.flush();
            em.getTransaction().commit();
            return funcionario;
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
            em.flush();
            em.getTransaction().commit();
            return funcionario;
        } catch (Exception eAtualizar) {
            em.getTransaction().rollback();
            throw eAtualizar;
        }
    }
    /**
     * @param integer
	 * @return boolean
	 */
    public void deletar(Funcionario funcionario) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(funcionario);
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
