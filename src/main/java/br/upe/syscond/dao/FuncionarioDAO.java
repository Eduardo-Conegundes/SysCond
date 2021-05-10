package br.upe.syscond.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.upe.syscond.models.Funcionario;

public class FuncionarioDAO implements InterfaceFuncionario {

    /**
     * 
     * @variavel --> Variavel gobal instance do tipo FuncionarioDAO e variavel em do tipo EntityManager.
     */
    private static FuncionarioDAO instance;
    protected EntityManager em;

    /**
     * 
     * @return instance --> Retorno do estanciamento do FuncionarioDAO.
     */	    
    public static FuncionarioDAO getInstance() {
        if (instance == null) {
            instance = new FuncionarioDAO();
        }
        return instance;
    }

    private FuncionarioDAO() {
        em = getEntityManager();
    }
	
    /**
     * 
     * @return instance --> Retorno do estanciamento do FuncionarioDAO.
     */
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        if (em == null) {
            em = factory.createEntityManager();
        }
        return em;
    }
	
	/**
	 * @param --> O metodo buscar recebe um parametro funcionario -com todos os atributos internalizados- do tipo funcionario para realizar uma busca no banco de dados do funcionario solicitado.
	 * @return--> Caso a operacao de Buscar seja bem sucedida, ela retona o funcionario deseja que esta no Banco de dados. 
	 * @throws Exception--> se apoeracao de listar falhar, sera lancada uma Exception.
	 */   
    public Funcionario buscar(Funcionario funcionario) throws Exception {
        try {
        	return (Funcionario) em.createQuery("From Funcionario f where f.pessoa = :pessoa and f.cargo = :cargo and f.salario = :salario and f.interno_externo = :interno_externo")
					.setParameter("pessoa", funcionario.getPessoa())
					.setParameter("cargo", funcionario.getCargo())
					.setParameter("salario", funcionario.getSalario())
					.setParameter("interno_externo", funcionario.getInterno_externo())
					.getSingleResult();
        } catch (Exception eAtualizar) {
            throw eAtualizar;
        }
    }

	/**
	 * @param --> O metodo salvar recebe um parametro funcionario-com todos os atributos internalizados- do tipo funcionario para salvar no banco de dados.
	 * @return--> Caso a operacao de salvar seja bem sucedida, ela retona um funcionario salvo no banco de dados.
	 * @throws--> se apoeracao  de salvar falhar, sera lancada uma Exception.
	 */
    public Funcionario salvar(Funcionario funcionario) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(funcionario);
            em.flush();
            em.getTransaction().commit();
            return funcionario;
        } catch (Exception eSalvar) {
            em.getTransaction().rollback();
            throw eSalvar;
        }
    }

	/**
	 * @param --> O metodo atualizar recebe um parametro funcionario-com um ou diversos atributos internalizados- do tipo funcionario para atualizar o funcionario antigo no banco de dados.
	 * @return--> Caso a operacao de atualizar seja bem sucedida, ela retona o funcionario antigo com as informacoes atualizadas no banco de dados.
	 * @throws--> se apoeracao  de atualizar falhar, sera lancada uma Exception.
	 */  
    public Funcionario atualizar(Funcionario funcionario) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(funcionario);
            em.flush();
            em.getTransaction().commit();
            return funcionario;
        } catch (Exception eAtualizar) {
            em.getTransaction().rollback();
            throw eAtualizar;
        }
    }

	/**
	 * @param --> O metodo deletar recebe um parametro funcionario-com todos os atibutos atributos internalizados- do tipo funcionario para exclusao do funcionario solicitado no banco de dados.
	 * @throws--> se a operacao  de deletar falhar, sera lancada uma Exception.
	 */
    public void deletar(Funcionario funcionario) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(funcionario);
            em.getTransaction().commit();
        } catch (Exception eDeletar) {
            em.getTransaction().rollback();
            throw eDeletar;
        }
    }
	
	/**
	 * @return--> Caso a operacao de listar seja bem sucedida, ela retona uma lista com todos os moradores salvos no banco de dados.
	 * @throws--> se apoeracaoo de listar falhar, sera lancada uma Exception.
	 */
    @SuppressWarnings("unchecked")
	public List<Funcionario> listar() {
        try {
        	return (em.createQuery("from " + Funcionario.class.getName()).getResultList());
		} catch (Exception eListar) {
			 throw eListar;
		}
    }


}
