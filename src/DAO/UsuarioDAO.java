/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author flavi
 */
public class UsuarioDAO {
    
   private static UsuarioDAO instance;
    protected EntityManager em;

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }
        return instance;
    }

    private UsuarioDAO() {
        em = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        if (em == null) {
            em = factory.createEntityManager();
        }
        return em;
    }

    public void salvar(Usuario user) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            System.out.println("Salvo Usuario com sucesso");
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            System.out.println("Erro ao salvar Usuario");
            throw new Exception();
        }
    }

    public void atualizar(Usuario user) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            throw new Exception();
        }
    }

    public void deletar(String cpf) throws Exception {
        Usuario user = null;
        try {
            em.getTransaction().begin();
            user = em.find(Usuario.class, cpf);
            em.remove(user);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            throw new Exception();
        }
    }

    public List<Usuario> listar() {
        return (em.createQuery("from " + Usuario.class.getName()).getResultList());
    }
    
}
