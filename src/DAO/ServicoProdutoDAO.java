/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.ServicoProduto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author flavi
 */
public class ServicoProdutoDAO {

    private static ServicoProdutoDAO instance;
    protected EntityManager em;

    public static ServicoProdutoDAO getInstance() {
        if (instance == null) {
            instance = new ServicoProdutoDAO();
        }
        return instance;
    }

    private ServicoProdutoDAO() {
        em = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        if (em == null) {
            em = factory.createEntityManager();
        }
        return em;
    }

    public void salvar(ServicoProduto SP) {
        try {
            em.getTransaction().begin();
            em.persist(SP);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void atualizar(ServicoProduto SP) {
        try {
            em.getTransaction().begin();
            em.merge(SP);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void deletar(String Id) {
        ServicoProduto SP = null;
        try {
            em.getTransaction().begin();
            SP = em.find(ServicoProduto.class, Id);
            em.remove(SP);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public List<ServicoProduto> listar() {
        return (em.createQuery("from " + ServicoProduto.class.getName()).getResultList());
    }

}
