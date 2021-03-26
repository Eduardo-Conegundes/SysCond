package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Models.Pessoa;

/**
 *
 * @author andre
 */
public class PessoaDAO {

    private static PessoaDAO instance;
    protected EntityManager em;

    public static PessoaDAO getInstance() {
        if (instance == null) {
            instance = new PessoaDAO();
        }
        return instance;
    }

    private PessoaDAO() {
        em = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory
                = Persistence.createEntityManagerFactory("default");
        if (em == null) {
            em = factory.createEntityManager();
        }
        return em;
    }

    public Pessoa buscar(String cpf) {
        return em.find(Pessoa.class, cpf);
    }

    @SuppressWarnings("unchecked")
    public List<Pessoa> listar() {
        return em.createQuery("FROM "
                + Pessoa.class.getName()).getResultList();
    }

    public void salvar(Pessoa p) {
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void atualizar(Pessoa p) {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void deletar(Pessoa p) {
        try {
            em.getTransaction().begin();
            p = em.find(Pessoa.class, p.getCpf());
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void deletarPorId(String cpf) {
        try {
            Pessoa p = buscar(cpf);
            deletar(p);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
