/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.FuncionarioExterno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author flavi
 */
public class FuncionarioExternoDAO {
   private static FuncionarioExternoDAO instance;
    protected EntityManager em;

    public static FuncionarioExternoDAO getInstance() {
        if (instance == null) {
            instance = new FuncionarioExternoDAO();
        }
        return instance;
    }

    private FuncionarioExternoDAO() {
        em = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        if (em == null) {
            em = factory.createEntityManager();
        }
        return em;
    }

    public void salvar(FuncionarioExterno FuncEx) {
        try {
            em.getTransaction().begin();
            em.persist(FuncEx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void atualizar(FuncionarioExterno FuncEx) {
        try {
            em.getTransaction().begin();
            em.merge(FuncEx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void deletar(String cpf) {
        FuncionarioExterno FuncEx = null;
        try {
            em.getTransaction().begin();
            FuncEx = em.find(FuncionarioExterno.class, cpf);
            em.remove(FuncEx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public List<FuncionarioExterno> listar() {
        return (em.createQuery("from " + FuncionarioExterno.class.getName()).getResultList());
    }
    
}
