package DAO;

import Models.Estoque;
import Models.Funcionario;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DAO.Interface.InterfaceEstoque;

public class EstoqueDAO implements InterfaceEstoque {

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

    public void salvar(Funcionario F) {
        try {
            em.getTransaction().begin();
            em.persist(F);
            em.getTransaction().commit();
            System.out.println("Salvo estoque com sucesso");
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            System.out.println("Erro ao salvar estoque com sucesso");
        }
    }

    public void atualizar(Funcionario F) {
        try {
            em.getTransaction().begin();
            em.merge(F);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void deletar(Funcionario F) {
        Estoque est = null;
        try {
            em.getTransaction().begin();
            est = em.find(Estoque.class, F);
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
