/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Apartamento;
import Models.ApartamentoPK;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 *
 * @author andre
 */
public class ApartamentoDAO{
    
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
	
    public void salvar(Apartamento apartamento){
    	try {
    		em.getTransaction().begin();
    		em.persist(apartamento);
    		em.getTransaction().commit();
    		System.out.println("Salvo Apartamento com sucesso");
    	}catch(Exception ex) {
    		ex.printStackTrace();
    		em.getTransaction().rollback();
    		System.out.println("Erro ao salvar Apartamento");
    	}
    }
    
    public void atualizar(Apartamento apartamento){
    	try {
    		em.getTransaction().begin();
    		em.merge(apartamento);
    		em.getTransaction().commit();
    	}catch(Exception ex) {
    		ex.printStackTrace();
    		em.getTransaction().rollback();
    	}
    }
    
    public void deletar(String bloco, int numero){
    	Apartamento p = null;
    	try {
    		em.getTransaction().begin();
    		p = em.find(Apartamento.class, new ApartamentoPK(numero,bloco));
    		em.remove(p);
    		em.getTransaction().commit();
    	} catch(Exception ex) {
    		ex.printStackTrace();
    		em.getTransaction().rollback();
    	}
    }
    
    public List<Apartamento> listar(){
        return (em.createQuery("from " + Apartamento.class.getName()).getResultList());
    }
    
    public List<Apartamento> listarPorBloco(String bloco){
    	String jpql = "select a from Apartamento a where a.bloco = :nomeBloco";
    	Query query = em.createQuery(jpql, Apartamento.class);
    	query.setParameter("nomeBloco", bloco);
    	return (query.getResultList());
    }
    
}
