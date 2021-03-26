/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Estoque;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author flavi
 */
public class EstoqueDAO {

    private static EstoqueDAO instance;
    protected EntityManager em;

    public static EstoqueDAO getInstance() {
        if (instance == null) {
            instance = new EstoqueDAO();
        }
        return instance;
    }

    private EstoqueDAO() {
        em = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        if (em == null) {
            em = factory.createEntityManager();
        }
        return em;
    }

    public void salvar(Estoque est) {
        try {
            em.getTransaction().begin();
            em.persist(est);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void atualizar(Estoque est) {
        try {
            em.getTransaction().begin();
            em.merge(est);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void deletar(String cpf) {
        Estoque est = null;
        try {
            em.getTransaction().begin();
            est = em.find(Estoque.class, cpf);
            em.remove(est);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public List<Estoque> listar() {
        return (em.createQuery("from " + Estoque.class.getName()).getResultList());
    }

}
