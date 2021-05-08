package br.upe.syscond.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.syscond.models.Pessoa;

public class PessoaDAO implements InterfacePessoa {

    private static PessoaDAO instance;
    protected EntityManager em;
    /**
     * 
     * @return instance
     */
    public static PessoaDAO getInstance() {
        if (instance == null) {
            instance = new PessoaDAO();
        }
        return instance;
    }

    private PessoaDAO() {
        em = getEntityManager();
    }
    /**
     * 
     * @return EntityManager
     */
    private EntityManager getEntityManager() {
        EntityManagerFactory factory
                = Persistence.createEntityManagerFactory("default");
        if (em == null) {
            em = factory.createEntityManager();
        }
        return em;
    }
    /**
     * @param integer
	 * @return Pessoa
	 */
    public Pessoa buscar(int id) throws Exception {
    	try {
    		em.getTransaction().begin();
    		Pessoa p = em.find(Pessoa.class, id);
    		em.getTransaction().commit();
    		return p;
    	} catch(Exception eBuscar) {
    		em.getTransaction().rollback();
    		throw eBuscar;
    	}
    }
    /**
	 * @return Lista de Pessoa[]
	 */
    @SuppressWarnings("unchecked")
    public List<Pessoa> listar() throws Exception {
    	try {
    		return em.createQuery("FROM "
                    + Pessoa.class.getName()).getResultList();
		} catch (Exception eListar) {
			throw eListar;
		}
        
    }
	/**
	 * param Pessoa
	 * @return Pessoa
	 */
    public Pessoa salvar(Pessoa p) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return this.buscar(p.getId());
        } catch (Exception eSalvar) {
            em.getTransaction().rollback();
            throw eSalvar;
        }
    }
	/**
	 * param Pessoa
	 * @return Pessoa
	 */
    public Pessoa atualizar(Pessoa p) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            em.flush();
            return p;
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
        Pessoa p = null;
    	try {
            em.getTransaction().begin();
            p = em.find(Pessoa.class, id);
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception eDeletar) {
            em.getTransaction().rollback();
            throw eDeletar;
        }
    }
}
