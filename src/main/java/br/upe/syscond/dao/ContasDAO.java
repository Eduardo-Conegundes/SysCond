package br.upe.syscond.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.syscond.models.Contas;

public class ContasDAO implements InterfaceContas{
	
    /**
     * 
     * @variavel --> Variavel gobal instance do tipo ContasDAO e variavel em do tipo EntityManager.
     */
	private static ContasDAO instance;
    protected EntityManager em;

    /**
     * 
     * @return instance --> Retorno do estanciamento do ContasDAO.
     */	  
    public static ContasDAO getInstance() {
    	if(instance == null) {
    		instance = new ContasDAO();
    	}
    	return instance;
    }
    
    private ContasDAO() {
    	em = getEntityManager();
    }
	
    /**
     * 
     * @return instance --> Retorno do estanciamento do ContasDAO.
     */   
    private EntityManager getEntityManager() {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    	if(em == null) {
    		em = factory.createEntityManager();
    	}
    	return em;
    }

	/**
	 * @param --> O metodo salvar recebe um parametro contas-com todos os atributos internalizados- do tipo contas para salvar no banco de dados.
	 * @return--> Caso a operacao de salvar seja bem sucedida, ela retona um contas salvo no banco de dados.
	 * @throws--> se apoeracao  de salvar falhar, sera lancada uma Exception.
	 */	
    public Contas salvar(Contas contas) throws Exception{
    	try {
    		em.getTransaction().begin();
    		em.persist(contas);
    		em.flush();
    		em.getTransaction().commit();
    		return contas;
    	}catch(Exception eSalvar) {
    		em.getTransaction().rollback();
    		throw eSalvar;
    	}
    }

	/**
	 * @param --> O metodo atualizar recebe um parametro contas-com um ou diversos atributos internalizados- do tipo contas para atualizar as contas antigo no banco de dados.
	 * @return--> Caso a operacao de atualizar seja bem sucedida, ela retona as contas antigo com as informacoes atualizadas no banco de dados.
	 * @throws--> se apoeracao  de atualizar falhar, sera lancada uma Exception.
	 */     
    public Contas atualizar(Contas contas) throws Exception{
    	try {
    		em.getTransaction().begin();
    		em.merge(contas);
    		em.flush();
    		em.getTransaction().commit();
    		return contas;
    	}catch(Exception eAtualizar) {
    		em.getTransaction().rollback();
    		throw eAtualizar;
    	}
    }

	/**
	 * @param --> O metodo deletar recebe um parametro contas-com todos os atibutos atributos internalizados- do tipo contas para exclusao da conta solicitado no banco de dados.
	 * @throws--> se a operacao  de deletar falhar, sera lancada uma Exception.
	 */  
    public void deletar(Contas contas) throws Exception{
    	try {
    		em.getTransaction().begin();
    		em.remove(contas);
    		em.getTransaction().commit();
    	} catch(Exception eDeletar) {
    		em.getTransaction().rollback();
    		throw eDeletar;
    	}
    }
	
	/**
	 * @param --> O metodo buscar recebe um parametro contas -com todos os atributos internalizados- do tipo contas para realizar uma busca no banco de dados da conta solicitado.
	 * @return--> Caso a operacao de Buscar seja bem sucedida, ela retona a conta deseja que esta no Banco de dados. 
	 * @throws Exception--> se apoeracao de listar falhar, sera lancada uma Exception.
	 */     
    public Contas buscar(Contas conta) throws Exception {
    	try {
    		return (Contas) em.createQuery("From Contas c where c.identificador =:identificador and "
    				+ "c.pagador =:pagador and "
    				+ "c.beneficiario =:beneficiario and "
    				+ "c.valor =:valor and "
    				+ "c.dataEmissao =:dataEmissao and "
    				+ "c.dataVencimento =:dataVencimento and "
    				+ "c.AReceber =:AReceber and "
    				+ "c.statusPaga =:statusPaga")
    		.setParameter("AReceber", conta.getAReceber())
    		.setParameter("statusPaga", conta.getStatusPaga())
    		.setParameter("dataVencimento", conta.getDataVencimento())
    		.setParameter("dataEmissao", conta.getDataEmissao())
    		.setParameter("valor", conta.getValor())
    		.setParameter("beneficiario", conta.getBeneficiario())
    		.setParameter("pagador", conta.getPagador())
    		.setParameter("identificador", conta.getIdentificador())
    		.getSingleResult();
    	} catch(Exception eBuscar) {
    		throw eBuscar;
    	}
    }
	
	/**
	 * @param --> O metodo listarPorData recebe um parametro data do tipo LocalDate para realizar uma busca no banco de dados das contas cadastradas na data solicitado.
	 * @return--> Caso a operacao de listar seja bem sucedida, ela retona uma lista com todas as contas salvas naquela data no banco de dados.
	 * @throws--> se apoeracaoo de listar falhar, sera lancada uma Exception.
	 */ 
	@SuppressWarnings("unchecked")
	public List<Contas> listarPorData(LocalDate data) throws Exception{
    	try {
			return em.createQuery("from Contas c where c.dataVencimento =:vencimento")
					.setParameter("vencimento", data)
					.getResultList();
		} catch (Exception e) {
			throw e;
		}
    }
	
	/**
	 * @return--> Caso a operacao de listar seja bem sucedida, ela retona uma lista com todas as contas salvos no banco de dados.
	 * @throws--> se apoeracaoo de listar falhar, sera lancada uma Exception.
	 */   
    @SuppressWarnings("unchecked")
	public List<Contas> listar(){
    	try {
    		return (em.createQuery("from " + Contas.class.getName()).getResultList());
		} catch (Exception eListar) {
			throw eListar;
		}
    }
}
