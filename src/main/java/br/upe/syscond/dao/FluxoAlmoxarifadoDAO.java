package br.upe.syscond.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.upe.syscond.models.FluxoAlmoxarifado;




public class FluxoAlmoxarifadoDAO implements InterfaceFluxoAlmoxarifado{
	
    /**
     * 
     * @variavel --> Variavel gobal instance do tipo FluxoAlmoxarifadoDAO e variavel em do tipo EntityManager.
     */
	private static FluxoAlmoxarifadoDAO instance;
	protected EntityManager em;

    /**
     * 
     * @return instance --> Retorno do estanciamento do FluxoAlmoxarifadoDAO.
     */	
	public static FluxoAlmoxarifadoDAO getInstance() {
		if(instance == null) {
			instance = new FluxoAlmoxarifadoDAO();
		}
		return instance;
	}

	private FluxoAlmoxarifadoDAO() {
		em = getEntityManager();
	}
	
    /**
     * 
     * @return instance --> Retorno do estanciamento do FluxoAlmoxarifadoDAO.
     */
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		if(em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}

	/**
	 * @param --> O metodo salvar recebe um parametro fluxo-com todos os atributos internalizados- do tipo FluxoAlmoxarifado para salvar no banco de dados.
	 * @return--> Caso a operacao de salvar seja bem sucedida, ela retona um fluxo efetuado do almoxarifafo salvo no banco de dados.
	 * @throws--> se apoeracao  de salvar falhar, sera lancada uma Exception.
	 */
	public FluxoAlmoxarifado salvar(FluxoAlmoxarifado fluxo) throws Exception{
		try {
			em.getTransaction().begin();
			em.persist(fluxo);
			em.flush();
			em.getTransaction().commit();
			return fluxo;
		}catch(Exception eSalvar) {
			em.getTransaction().rollback();
			throw eSalvar;
		}
	}

	/**
	 * @param --> O metodo atualizar recebe um parametro fluxo-com um ou diversos atributos internalizados- do tipo FluxoAlmoxarifado para atualizar o FluxoAlmoxarifado antigo no banco de dados.
	 * @return--> Caso a operacao de atualizar seja bem sucedida, ela retona o FluxoAlmoxarifado antigo com as informacoes atualizadas no banco de dados.
	 * @throws--> se apoeracao  de atualizar falhar, sera lancada uma Exception.
	 */  
	public FluxoAlmoxarifado atualizar(FluxoAlmoxarifado fluxo) throws Exception{
		try {
			em.getTransaction().begin();
			em.merge(fluxo);
			em.flush();
			em.getTransaction().commit();
			return fluxo;
		}catch(Exception eAtualizar) {
			em.getTransaction().rollback();
			throw eAtualizar;
		}
	}
	
	/**
	 * @param --> O metodo buscar recebe um parametro id do tipo integer para realizar uma busca no banco de dados do FluxoAlmoxarifado solicitado.
	 * @return--> Caso a operacao de Buscar seja bem sucedida, ela retona o FluxoAlmoxarifado deseja que esta no Banco de dados. 
	 * @throws Exception--> se apoeracao de listar falhar, sera lancada uma Exception.
	 */   
	public FluxoAlmoxarifado buscar(FluxoAlmoxarifado fluxo) throws Exception{
		try {
			return (FluxoAlmoxarifado) em.createQuery("From FluxoAlmoxarifado m where m.nomeDoProduto = :nomeDoProduto")
					.setParameter("nomeDoProduto", fluxo.getNomeDoProduto())
					.getSingleResult();
		} catch (Exception eBuscar) {
			throw eBuscar;
		}
	}
	
	/**
	 * @param --> O metodo deletar recebe um parametro id do tipo integer para exclusao do FluxoAlmoxarifado solicitado no banco de dados.
	 * @throws--> se a operacao  de deletar falhar, sera lancada uma Exception.
	 */
	public void deletar(FluxoAlmoxarifado fluxo) throws Exception {
		try {
			em.getTransaction().begin();
			em.remove(fluxo);
			em.getTransaction().commit();
		} catch (Exception eDeletar) {
			em.getTransaction().rollback();
			throw eDeletar;
		}
	}
	
	/**
	 * @return--> Caso a operacao de listar seja bem sucedida, ela retona uma lista com todos os FluxoAlmoxarifado salvos no banco de dados.
	 * @throws--> se a poeracaoo de listar falhar, sera lancada uma Exception.
	 */
	@SuppressWarnings("unchecked")
	public List<FluxoAlmoxarifado> listar() throws Exception{
		try {
			return (em.createQuery("from " + FluxoAlmoxarifado.class.getName()).getResultList());			
		} catch (Exception eListar) {
			throw eListar;
		}
	}


}
