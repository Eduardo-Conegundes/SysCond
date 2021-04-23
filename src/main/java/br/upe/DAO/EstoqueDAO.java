package br.upe.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.DAO.Interface.InterfaceEstoque;
import br.upe.Models.Almoxarifado;

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

    public void salvar(Almoxarifado F) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(F);
            em.getTransaction().commit();
        } catch (Exception eSalvar) {
            em.getTransaction().rollback();
            throw eSalvar;
        }
    }

    public void atualizar(Almoxarifado F) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(F);
            em.getTransaction().commit();
        } catch (Exception eAtualizar) {
            em.getTransaction().rollback();
            throw eAtualizar;
        }
    }

    public void deletar(Almoxarifado F) throws Exception {
        Almoxarifado est = null;
        try {
            em.getTransaction().begin();
            est = em.find(Almoxarifado.class, F);
            em.remove(est);
            em.getTransaction().commit();
        } catch (Exception eDeletar) {
            em.getTransaction().rollback();
            throw eDeletar;
        }
    }

    @SuppressWarnings("unchecked")
	public List<Almoxarifado> listar() {
    	try {
    		return (em.createQuery("from " + Almoxarifado.class.getName()).getResultList());	
		} catch (Exception eListar) {
			throw eListar;
		}
    }

}
