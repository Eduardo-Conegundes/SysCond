package br.upe.syscond.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.syscond.models.Contas;

public class ContasDAO implements InterfaceContas{
	
	private static ContasDAO instance;
    protected EntityManager em;
    /**
     * 
     * @return instance
     */   
    public static ContasDAO getInstance() {
    	if(instance == null) {
    		instance = new ContasDAO();
    	}
    	return instance;
    }
    
    private ContasDAO() {
    	em = getEntityManager();
    }
    /**
     * 
     * @return EntityManager
     */   
    private EntityManager getEntityManager() {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    	if(em == null) {
    		em = factory.createEntityManager();
    	}
    	return em;
    }
    /**
     * @param Contas
	 * @return Contas
	 */  	
    public Contas salvar(Contas contas) throws Exception{
    	try {
    		em.getTransaction().begin();
    		em.persist(contas);
    		em.getTransaction().commit();
    		return this.buscar(contas.getId());
    	}catch(Exception eSalvar) {
    		em.getTransaction().rollback();
    		throw eSalvar;
    	}
    }
    /**
     * @param Contas
	 * @return Contas
	 */    
    public Contas atualizar(Contas contas) throws Exception{
    	try {
    		em.getTransaction().begin();
    		em.merge(contas);
    		em.getTransaction().commit();
    		return this.buscar(contas.getId());
    	}catch(Exception eAtualizar) {
    		em.getTransaction().rollback();
    		throw eAtualizar;
    	}
    }
     /**
     * @param integer
	 * @return boolean
	 */   
    public void deletar(int id) throws Exception{
    	Contas p = null;
    	try {
    		em.getTransaction().begin();
    		p = em.find(Contas.class, id);
    		em.remove(p);
    		em.getTransaction().commit();
    	} catch(Exception eDeletar) {
    		em.getTransaction().rollback();
    		throw eDeletar;
    	}
    }
    /**
     * @param integer
	 * @return Contas
	 */    
    public Contas buscar(int id) throws Exception {
    	Contas p = null;
    	try {
    		em.getTransaction().begin();
    		p = em.find(Contas.class, id);
    		em.getTransaction().commit();
    		return p;
    	} catch(Exception eBuscar) {
    		em.getTransaction().rollback();
    		throw eBuscar;
    	}
    }
    /**
	 * @return Lista de Contas[]
	 */    
    @SuppressWarnings("unchecked")
	public List<Contas> listar(){
    	try {
    		return (em.createQuery("from " + Contas.class.getName()).getResultList());
		} catch (Exception eListar) {
			throw eListar;
		}
    }
    
}
