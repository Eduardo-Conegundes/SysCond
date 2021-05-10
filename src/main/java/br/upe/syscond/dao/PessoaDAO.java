package br.upe.syscond.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.upe.syscond.models.Pessoa;

public class PessoaDAO implements InterfacePessoa {

    /**
     * 
     * @variavel --> Variavel gobal instance do tipo PessoaDAO e variavel em do tipo EntityManager.
     */
    private static PessoaDAO instance;
    protected EntityManager em;

    /**
     * 
     * @return instance --> Retorno do estanciamento do PessoaDAO.
     */
    public static PessoaDAO getInstance() {
        if (instance == null) {
            instance = new PessoaDAO();
        }
        return instance;
    }

    private PessoaDAO() {
        em = getEntityManager();
    }
	
    /**
     * 
     * @return instance --> Retorno do estanciamento do PessoaDAO.
     */
    private EntityManager getEntityManager() {
        EntityManagerFactory factory
                = Persistence.createEntityManagerFactory("default");
        if (em == null) {
            em = factory.createEntityManager();
        }
        return em;
    }
    /**
     * @param integer
	 * @return Pessoa
	 */
    public Pessoa buscar(Pessoa pessoa) throws Exception {
    	try {
    		return (Pessoa) em.createQuery("FROM Pessoa a WHERE a.cpf = :cpf and a.nome = :nome and a.telefone = :telefone and a.email = :email")
				.setParameter("cpf", pessoa.getCpf())
				.setParameter("nome", pessoa.getNome())
				.setParameter("telefone", pessoa.getTelefone())
				.setParameter("email", pessoa.getEmail())
				.getSingleResult();
    	} catch(Exception eBuscar) {
    		em.getTransaction().rollback();
    		throw eBuscar;
    	}
    }
    /**
	 * @return Lista de Pessoa[]
	 */
    @SuppressWarnings("unchecked")
    public List<Pessoa> listar() throws Exception {
    	try {
    		return em.createQuery("FROM "
                    + Pessoa.class.getName()).getResultList();
		} catch (Exception eListar) {
			throw eListar;
		}
        
    }
	/**
	 * param Pessoa
	 * @return Pessoa
	 */
    public Pessoa salvar(Pessoa pessoa) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(pessoa);
            em.flush();
            em.getTransaction().commit();
            return pessoa;
        } catch (Exception eSalvar) {
            em.getTransaction().rollback();
            throw eSalvar;
        }
    }
	/**
	 * param Pessoa
	 * @return Pessoa
	 */
    public Pessoa atualizar(Pessoa pessoa) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(pessoa);
            em.flush();
            em.getTransaction().commit();
            return pessoa;
        } catch (Exception eAtualizar) {
            em.getTransaction().rollback();
            throw eAtualizar;
        }
    }
     /**
     * @param integer
	 * @return boolean
	 */   
    public void deletar(Pessoa pessoa) throws Exception {
    	try {
            em.getTransaction().begin();
            em.remove(pessoa);
            em.getTransaction().commit();
        } catch (Exception eDeletar) {
            em.getTransaction().rollback();
            throw eDeletar;
        }
    }
} 
