/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Visitante;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author flavi
 */
public class VisitanteDAO {
    
    private static VisitanteDAO instance;
    protected EntityManager em;

    public static VisitanteDAO getInstance() {
        if (instance == null) {
            instance = new VisitanteDAO();
        }
        return instance;
    }

    private VisitanteDAO() {
        em = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        if (em == null) {
            em = factory.createEntityManager();
        }
        return em;
    }

    public void salvar(Visitante vis) {
        try {
            em.getTransaction().begin();
            em.persist(vis);
            em.getTransaction().commit();
            System.out.println("Salvo Visitante com sucesso");
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            System.out.println("Erro ao salvar Visitante");
        }
    }

    public void atualizar(Visitante vis) {
        try {
            em.getTransaction().begin();
            em.merge(vis);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void deletar(String cpf) {
        Visitante vis = null;
        try {
            em.getTransaction().begin();
            vis = em.find(Visitante.class, cpf);
            em.remove(vis);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public List<Visitante> listar() {
        return (em.createQuery("from " + Visitante.class.getName()).getResultList());
    }
    
}
