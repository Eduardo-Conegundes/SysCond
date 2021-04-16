package DAO;

import Models.ServicoProduto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DAO.Interface.InterfaceServicoProduto;

public class ServicoProdutoDAO implements InterfaceServicoProduto {

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

    public ServicoProduto buscar(int id) throws Exception {
        ServicoProduto SP = null;
        try {
            em.getTransaction().begin();
            SP = em.find(ServicoProduto.class, id);
            em.getTransaction().commit();
            return SP;
        } catch (Exception eBuscar) {
            em.getTransaction().rollback();
            throw eBuscar;
        }
    }
    
    public ServicoProduto salvar(ServicoProduto SP) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(SP);
            em.getTransaction().commit();
            return buscar(SP.getId());
        } catch (Exception eSalvar) {
            em.getTransaction().rollback();
            throw eSalvar;
        }
    }

    public ServicoProduto atualizar(ServicoProduto SP) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(SP);
            em.getTransaction().commit();
            return buscar(SP.getId());
        } catch (Exception eAtualizar) {
            em.getTransaction().rollback();
            throw eAtualizar;
        }
    }

    public void deletar(int id) throws Exception {
        ServicoProduto SP = null;
        try {
            em.getTransaction().begin();
            SP = em.find(ServicoProduto.class, id);
            em.remove(SP);
            em.getTransaction().commit();
        } catch (Exception eDeletar) {
            em.getTransaction().rollback();
            throw eDeletar;
        }
    }

    @SuppressWarnings("unchecked")
	public List<ServicoProduto> listar() {
        try {
        	return (em.createQuery("from " + ServicoProduto.class.getName()).getResultList());
		} catch (Exception eListar) {
			throw eListar;
		}
    }

}
