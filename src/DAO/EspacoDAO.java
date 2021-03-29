package DAO;

import Models.Espaco;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DAO.Interface.InterfaceEspaco;

public class EspacoDAO implements InterfaceEspaco {

    private static EspacoDAO instance;
    protected EntityManager em;

    public static EspacoDAO getInstance() {
        if (instance == null) {
            instance = new EspacoDAO();
        }
        return instance;
    }

    private EspacoDAO() {
        em = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        if (em == null) {
            em = factory.createEntityManager();
        }
        return em;
    }

    public void salvar(Espaco esp) {
        try {
            em.getTransaction().begin();
            em.persist(esp);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void atualizar(Espaco esp) {
        try {
            em.getTransaction().begin();
            em.merge(esp);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void deletar(int id) {
        Espaco esp = null;
        try {
            em.getTransaction().begin();
            esp = em.find(Espaco.class, id);
            em.remove(esp);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }
    
    public Espaco listarId(int id) {
        Espaco esp = null;
        try {
            em.getTransaction().begin();
            esp = em.find(Espaco.class, id);
            em.getTransaction().commit();
            return esp;
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
        return esp;
    }

    public List<Espaco> listar() {
        return (em.createQuery("from " + Espaco.class.getName()).getResultList());
    }

}
