package br.upe.syscond.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.upe.syscond.models.Apartamento;

public class ApartamentoDAO implements InterfaceApartamento {
    
	private static ApartamentoDAO instance;
    protected EntityManager em;
    
    public static ApartamentoDAO getInstance() {
    	if(instance == null) {
    		instance = new ApartamentoDAO();
    	}
    	return instance;
    }
    	
    private ApartamentoDAO() {
    	em = getEntityManager();
    }
    
    private EntityManager getEntityManager() {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    	if(em == null) {
    		em = factory.createEntityManager();
    	}
    	return em;
    }
	
    public Apartamento salvar(Apartamento apartamento) throws Exception{
    	try {
    		em.getTransaction().begin();
    		em.persist(apartamento);
    		em.getTransaction().commit();
    		return this.buscar(apartamento.getId());
    	}catch(Exception eSalvar) {
    		em.getTransaction().rollback();
    		throw eSalvar;
    	}
    }
    
    public Apartamento atualizar(Apartamento apartamento) throws Exception{
    	try {
    		em.getTransaction().begin();
    		em.merge(apartamento);
    		em.getTransaction().commit();
    		return this.buscar(apartamento.getId());
    	}catch(Exception eAtualizar) {
    		em.getTransaction().rollback();
    		throw eAtualizar;
    	}
    }
    
    //esse metodo retorna null caso n�o encontre
    public Apartamento buscar(int id) throws Exception{
    	try {
    		em.getTransaction().begin();
    		Apartamento p = em.find(Apartamento.class, id);
    		em.getTransaction().commit();
    		return p;
    	} catch(Exception eBuscar) {
    		em.getTransaction().rollback();
    		throw eBuscar;
    	}
    }
    
    public boolean deletar(int id) throws Exception {
        try {
            Apartamento p = buscar(id);
            return deletarPorId(p);
        } catch (Exception eDeletarId) {
        	eDeletarId.printStackTrace();
        	throw eDeletarId;
        }
    }
    
    private boolean deletarPorId(Apartamento apartamento) throws Exception{
    	try {
    		em.getTransaction().begin();
    		Apartamento p = em.find(Apartamento.class, apartamento.getId());
    		em.remove(p);
    		em.getTransaction().commit();
    		return true;
    	} catch(Exception eDeletar) {
    		em.getTransaction().rollback();
    		throw eDeletar;
    	}
    }
    
    @SuppressWarnings("unchecked")
	public List<Apartamento> listar() throws Exception{
    	try {
    		return (em.createQuery("from " + Apartamento.class.getName()).getResultList());			
		} catch (Exception eListar) {
			eListar.printStackTrace();
			throw eListar;
		}
    }
    
    @SuppressWarnings("unchecked")
	public List<Apartamento> listarPorBloco(String bloco) throws Exception{
    	try {
    		String jpql = "select a from Apartamento a where a.bloco = :nomeBloco";
    		Query query = em.createQuery(jpql, Apartamento.class);
    		query.setParameter("nomeBloco", bloco);
    		return (query.getResultList());
    	} catch (Exception eListarBloco) {
    		throw eListarBloco;
		}
    }
    
}
