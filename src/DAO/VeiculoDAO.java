package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Models.Veiculo;

public class VeiculoDAO {
    private static VeiculoDAO instance;
    protected EntityManager em;

    public static VeiculoDAO getInstance() {
        if (instance == null) {
            instance = new VeiculoDAO();
        }
        return instance;
    }

    private VeiculoDAO() {
        em = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        if (em == null) {
            em = factory.createEntityManager();
        }
        return em;
    }

    public void salvar(Veiculo veiculo) {
        try {
            em.getTransaction().begin();
            em.persist(veiculo);
            em.getTransaction().commit();
            System.out.println("Salvo Veiculo com sucesso");
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            System.out.println("Erro ao salvar Veiculo");
        }
    }

    public void atualizar(Veiculo veiculo) {
        try {
            em.getTransaction().begin();
            em.merge(veiculo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void deletar(String placa) {
        Veiculo v = null;
        try {
            em.getTransaction().begin();
            v = em.find(Veiculo.class, placa);
            em.remove(v);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public List<Veiculo> listar() {
        return (em.createQuery("from " + Veiculo.class.getName()).getResultList());
    }
}
