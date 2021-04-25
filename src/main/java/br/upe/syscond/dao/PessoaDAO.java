package br.upe.syscond.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.syscond.models.Pessoa;

public class PessoaDAO implements InterfacePessoa {

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

    public Pessoa buscar(String cpf) throws Exception {
    	try {
    		em.getTransaction().begin();
    		Pessoa p = em.find(Pessoa.class, cpf);
    		em.getTransaction().commit();
    		return p;
    	} catch(Exception eBuscar) {
    		em.getTransaction().rollback();
    		throw eBuscar;
    	}
    }

    @SuppressWarnings("unchecked")
    public List<Pessoa> listar() throws Exception {
    	try {
    		return em.createQuery("FROM "
                    + Pessoa.class.getName()).getResultList();
		} catch (Exception eListar) {
			throw eListar;
		}
        
    }

    public Pessoa salvar(Pessoa p) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return buscar(p.getCpf());
        } catch (Exception eSalvar) {
            em.getTransaction().rollback();
            throw eSalvar;
        }
    }

    public Pessoa atualizar(Pessoa p) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            return buscar(p.getCpf());
        } catch (Exception eAtualizar) {
            em.getTransaction().rollback();
            throw eAtualizar;
        }
    }
    
    public void deletar(String cpf) throws Exception {
        try {
            Pessoa p = buscar(cpf);
            deletar(p);
        } catch (Exception eDeletarId) {
        	throw eDeletarId;
        }
    }


    private void deletar(Pessoa p) throws Exception {
        try {
            em.getTransaction().begin();
            p = em.find(Pessoa.class, p.getCpf());
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception eDeletar) {
            em.getTransaction().rollback();
            throw eDeletar;
        }
    }
}
