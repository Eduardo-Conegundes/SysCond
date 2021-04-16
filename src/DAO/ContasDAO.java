package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
    
    @SuppressWarnings("unchecked")
	public List<Contas> listar(){
    	try {
    		return (em.createQuery("from " + Contas.class.getName()).getResultList());
		} catch (Exception eListar) {
			throw eListar;
		}
    }
    
}
