package br.upe.syscond.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.upe.syscond.models.Contabil;

public class ContabilDAO implements InterfaceContabil{
   
	/**
     * 
     * @variavel --> Variavel gobal instance do tipo ContabilDAO e variavel em do tipo EntityManager.
     */
	private static ContabilDAO instance;
	protected EntityManager em;

    /**
     * 
     * @return instance --> Retorno do estanciamento do ContabilDAO.
     */
	public static ContabilDAO getInstance() {
		if(instance == null) {
			instance = new ContabilDAO();
		}
		return instance;
	}

	private ContabilDAO() {
		em = getEntityManager();
	}
	
    /**
     * 
     * @return instance --> Retorno do estanciamento do ContabilDAO.
     */
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		if(em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}

	/**
	 * @param --> O metodo salvar recebe um parametro contabil-com todos os atributos internalizados- do tipo contabil para salvar no banco de dados.
	 * @return--> Caso a operacao de salvar seja bem sucedida, ela retona o contabil salvo no banco de dados.
	 * @throws--> se apoeracao  de salvar falhar, sera lancada uma Exception.
	 */
	public Contabil salvar(Contabil contabil) throws Exception{
		try {
			em.getTransaction().begin();
			em.persist(contabil);
			em.getTransaction().commit();
			return this.buscar(contabil.getId());
		}catch(Exception eSalvar) {
			em.getTransaction().rollback();
			throw eSalvar;
		}
	}

	/**
	 * @param --> O metodo atualizar recebe um parametro contabil-com um ou diversos atributos internalizados- do tipo contabil para atualizar o contabil no banco de dados.
	 * @return--> Caso a operacao de atualizar seja bem sucedida, ela retona o contabil com as informacoes atualizadas no banco de dados.
	 * @throws--> se apoeracao  de atualizar falhar, sera lancada uma Exception.
	 */ 
	public Contabil atualizar(Contabil contabil) throws Exception{
		try {
			em.getTransaction().begin();
			em.merge(contabil);
			em.getTransaction().commit();
			return this.buscar(contabil.getId());
		}catch(Exception eAtualizar) {
			em.getTransaction().rollback();
			throw eAtualizar;
		}
	}

	/**
	 * @param --> O metodo deletar recebe um parametro id do tipo integer para exclusao do contabil solicitado no banco de dados.
	 * @throws--> se a operacao  de deletar falhar, sera lancada uma Exception.
	 */
	public void deletar(int id) throws Exception{
		Contabil p = null;
		try {
			em.getTransaction().begin();
			p = em.find(Contabil.class, id);
			em.remove(p);
			em.getTransaction().commit();
		} catch(Exception eDeletar) {
			em.getTransaction().rollback();
			throw eDeletar;
		}
	}
	
	/**
	 * @return--> Caso a operacao de listar seja bem sucedida, ela retona o contabil salvo no banco de dados.
	 * @throws--> se a poeracaoo de listar falhar, sera lancada uma Exception.
	 */
	@SuppressWarnings("unchecked")
	public List<Contabil> listar(){
		try {
			return (em.createQuery("from " + Contabil.class.getName()).getResultList());
		} catch (Exception eListar) {
			
			throw eListar;
		}
	}
	
	/**
	 * @param --> O metodo buscar recebe um parametro id do tipo integer para realizar uma busca no banco de dados do unico contabil existente solicitado.
	 * @return--> Caso a operacao de Buscar seja bem sucedida, ela retona o contabil solicitado no que esta no Banco de dados. 
	 * @throws Exception--> se apoeracao de listar falhar, sera lancada uma Exception.
	 */ 
	public Contabil buscar(int id) {
		Contabil p = null;
		try {
			em.getTransaction().begin();
			p = em.find(Contabil.class, id);
			em.getTransaction().commit();
			return p;
		} catch(Exception eBuscar) {
			em.getTransaction().rollback();
			throw eBuscar;
		}
	}
}
