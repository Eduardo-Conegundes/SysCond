/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Empresa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author flavi
 */
public class EmpresaDAO {
  private static EmpresaDAO instance;
    protected EntityManager em;

    public static EmpresaDAO getInstance() {
        if (instance == null) {
            instance = new EmpresaDAO();
        }
        return instance;
    }

    private EmpresaDAO() {
        em = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        if (em == null) {
            em = factory.createEntityManager();
        }
        return em;
    }

    public void salvar(Empresa E) {
        try {
            em.getTransaction().begin();
            em.persist(E);
            em.getTransaction().commit();
            System.out.println("Salvo Empresa com sucesso");
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            System.out.println("Erro ao Salvar Empresa");
        }
    }

    public void atualizar(Empresa E) {
        try {
            em.getTransaction().begin();
            em.merge(E);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void deletar(String cpf) {
        Empresa E = null;
        try {
            em.getTransaction().begin();
            E = em.find(Empresa.class, cpf);
            em.remove(E);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public List<Empresa> listar() {
        return (em.createQuery("from " + Empresa.class.getName()).getResultList());
    }



    
}
