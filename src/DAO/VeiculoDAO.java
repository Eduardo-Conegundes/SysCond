package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Models.Pessoa;
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

    public Veiculo salvar(Veiculo veiculo) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(veiculo);
            em.getTransaction().commit();
            return veiculo;
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            System.out.println("Erro ao salvar Veiculo");
            throw new Exception();
        }
		
    }

    public Veiculo atualizar(Veiculo veiculo) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(veiculo);
            em.getTransaction().commit();
            return veiculo;
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            throw new Exception();
        }
		
    }
    
    public Veiculo buscar(String placa) throws Exception {
    	try {
    		em.getTransaction().begin();
    		Veiculo p = em.find(Veiculo.class, placa);
    		em.getTransaction().commit();
    		return p;
    	} catch(Exception eBuscar) {
    		eBuscar.printStackTrace();
    		em.getTransaction().rollback();
    		throw new Exception();
    	}
    }

    public void deletar(String placa) throws Exception {
        Veiculo v = null;
        try {
            em.getTransaction().begin();
            v = em.find(Veiculo.class, placa);
            em.remove(v);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            throw new Exception();
        }
    }

    public List<Veiculo> listar() throws Exception {
    	try {
    		return (em.createQuery("from " + Veiculo.class.getName()).getResultList());
		} catch (Exception e) {
			throw new Exception();
		}
    }
}
