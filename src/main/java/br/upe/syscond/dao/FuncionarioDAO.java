package br.upe.syscond.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.syscond.models.Funcionario;

public class FuncionarioDAO implements InterfaceFuncionario {
    
    private static FuncionarioDAO instance;
    protected EntityManager em;
	    
    public static FuncionarioDAO getInstance() {
        if (instance == null) {
            instance = new FuncionarioDAO();
        }
        return instance;
    }

    private FuncionarioDAO() {
        em = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        if (em == null) {
            em = factory.createEntityManager();
        }
        return em;
    }
    
    public Funcionario buscar(String cpf) throws Exception {
        Funcionario f = null;
        try {
            em.getTransaction().begin();
            f = em.find(Funcionario.class, cpf);
            em.getTransaction().commit();
            return f;
        } catch (Exception eAtualizar) {
            em.getTransaction().rollback();
            throw eAtualizar;
        }
    }

    public Funcionario salvar(Funcionario funcionario) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(funcionario);
            em.getTransaction().commit();
            return buscar(funcionario.getPessoa().getCpf());
        } catch (Exception eSalvar) {
            em.getTransaction().rollback();
            throw eSalvar;
        }
    }

    public Funcionario atualizar(Funcionario funcionario) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(funcionario);
            em.getTransaction().commit();
            return buscar(funcionario.getPessoa().getCpf());
        } catch (Exception eAtualizar) {
            em.getTransaction().rollback();
            throw eAtualizar;
        }
    }

    public void deletar(String cpf) throws Exception {
        Funcionario f = null;
        try {
            em.getTransaction().begin();
            f = em.find(Funcionario.class, cpf);
            em.remove(f);
            em.getTransaction().commit();
        } catch (Exception eDeletar) {
            em.getTransaction().rollback();
            throw eDeletar;
        }
    }

    @SuppressWarnings("unchecked")
	public List<Funcionario> listar() {
        try {
        	return (em.createQuery("from " + Funcionario.class.getName()).getResultList());
		} catch (Exception eListar) {
			 throw eListar;
		}
    }


}
