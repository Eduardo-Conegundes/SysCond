package br.upe.syscond.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.syscond.models.ServicoProduto;

public class ServicoProdutoDAO implements InterfaceServicoProduto {

    private static ServicoProdutoDAO instance;
    protected EntityManager em;
    /**
     * 
     * @return instance
     */
    public static ServicoProdutoDAO getInstance() {
        if (instance == null) {
            instance = new ServicoProdutoDAO();
        }
        return instance;
    }

    private ServicoProdutoDAO() {
        em = getEntityManager();
    }
    /**
     * 
     * @return EntityManager
     */
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        if (em == null) {
            em = factory.createEntityManager();
        }
        return em;
    }
    /**
     * @param integer
	 * @return ServicoProduto
	 */
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
	/**
	 * param ServicoProduto
	 * @return ServicoProduto
	 */    
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
	/**
	 * param ServicoProduto
	 * @return ServicoProduto
	 */
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
    /**
     * @param integer
	 * @return boolean
	 */
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
    /**
	 * @return Lista de ServicoProduto[]
	 */
    @SuppressWarnings("unchecked")
	public List<ServicoProduto> listar() {
        try {
        	return (em.createQuery("from " + ServicoProduto.class.getName()).getResultList());
		} catch (Exception eListar) {
			throw eListar;
		}
    }

}
