package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import DAO.Interface.InterfaceContas;
import Models.Contas;

public class ContasDAO implements InterfaceContas{
	
	private static ContasDAO instance;
    protected EntityManager em;
    
    public static ContasDAO getInstance() {
    	if(instance == null) {
    		instance = new ContasDAO();
    	}
    	return instance;
    }
    
    private ContasDAO() {
    	em = getEntityManager();
    }
    
    private EntityManager getEntityManager() {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    	if(em == null) {
    		em = factory.createEntityManager();
    	}
    	return em;
    }
	
    public void salvar(Contas contas){
    	try {
    		em.getTransaction().begin();
    		em.persist(contas);
    		em.getTransaction().commit();
    	}catch(Exception ex) {
    		ex.printStackTrace();
    		em.getTransaction().rollback();
    	}
    }
    
    public void atualizar(Contas contas){
    	try {
    		em.getTransaction().begin();
    		em.merge(contas);
    		em.getTransaction().commit();
    	}catch(Exception ex) {
    		ex.printStackTrace();
    		em.getTransaction().rollback();
    	}
    }
    
    public void deletar(int id){
    	Contas p = null;
    	try {
    		em.getTransaction().begin();
    		p = em.find(Contas.class, id);
    		em.remove(p);
    		em.getTransaction().commit();
    	} catch(Exception ex) {
    		ex.printStackTrace();
    		em.getTransaction().rollback();
    	}
    }
    
    public Contas listarId(int id) {
    	Contas p = null;
    	try {
    		em.getTransaction().begin();
    		p = em.find(Contas.class, id);
    		em.getTransaction().commit();
    		return p;
    	} catch(Exception ex) {
    		ex.printStackTrace();
    		em.getTransaction().rollback();
    	}
		return p;
    }
    
    public List<Contas> listar(){
        return (em.createQuery("from " + Contas.class.getName()).getResultList());
    }
    
}
