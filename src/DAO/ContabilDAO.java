package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DAO.Interface.InterfaceContabil;
import Models.Contabil;

public class ContabilDAO implements InterfaceContabil{
	private static ContabilDAO instance;
    protected EntityManager em;
    
    public static ContabilDAO getInstance() {
    	if(instance == null) {
    		instance = new ContabilDAO();
    	}
    	return instance;
    }
    
    private ContabilDAO() {
    	em = getEntityManager();
    }
    
    private EntityManager getEntityManager() {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    	if(em == null) {
    		em = factory.createEntityManager();
    	}
    	return em;
    }
	
    public void salvar(Contabil contabil){
    	try {
    		em.getTransaction().begin();
    		em.persist(contabil);
    		em.getTransaction().commit();
    	}catch(Exception ex) {
    		ex.printStackTrace();
    		em.getTransaction().rollback();
    	}
    }
    
    public void atualizar(Contabil contabil){
    	try {
    		em.getTransaction().begin();
    		em.merge(contabil);
    		em.getTransaction().commit();
    	}catch(Exception ex) {
    		ex.printStackTrace();
    		em.getTransaction().rollback();
    	}
    }
    
    public void deletar(int id){
    	Contabil p = null;
    	try {
    		em.getTransaction().begin();
    		p = em.find(Contabil.class, id);
    		em.remove(p);
    		em.getTransaction().commit();
    	} catch(Exception ex) {
    		ex.printStackTrace();
    		em.getTransaction().rollback();
    	}
    }
    
    public List<Contabil> listar(){
        return (em.createQuery("from " + Contabil.class.getName()).getResultList());
    }
}
