package br.upe.syscond.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import br.upe.syscond.models.Apartamento;

public class ApartamentoDAO implements InterfaceApartamento {

    /**
     * 
     * @variavel --> Variavel gobal instance do tipo ApartamentoDAO e variavel em do tipo EntityManager.
     */
	private static ApartamentoDAO instance;
	protected EntityManager em;

    /**
     * 
     * @return instance --> Retorno do estanciamento do ApartamentoDAO.
     */
	public static ApartamentoDAO getInstance() {
		if(instance == null) {
			instance = new ApartamentoDAO();
		}
		return instance;
	}

	private ApartamentoDAO() {
		em = getEntityManager();
	}
	
    /**
     * 
     * @return instance --> Retorno do estanciamento do ApartamentoDAO.
     */
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		if(em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}

	/**
	 * @param --> O metodo salvar recebe um parametro apartamento-com todos os atributos internalizados- do tipo apartamento para salvar no banco de dados.
	 * @return--> Caso a operação de salvar seja bem sucedida, ela retona um apartamento salvo no banco de dados.
	 * @throws--> se apoeração  de salvar falhar, sera lançada uma Exception.
	 */
	public Apartamento salvar(Apartamento apartamento) throws Exception{
		try {
			em.getTransaction().begin();
			em.persist(apartamento);
			em.flush();
			em.getTransaction().commit();
			return apartamento;
		}catch(Exception eSalvar) {
			em.getTransaction().rollback();
			throw eSalvar;
		}
	}

	/**
	 * @param --> O metodo atualizar recebe um parametro novo-com um ou diversos atributos internalizados- do tipo apartamento para atualizar o apartamento antigo no banco de dados.
	 * @return--> Caso a operação de atualizar seja bem sucedida, ela retona o apartamento antigo com as informações atualizadas no banco de dados.
	 * @throws--> se apoeração  de atualizar falhar, sera lançada uma Exception.
	 */
	public Apartamento atualizar(Apartamento apartamento) throws Exception{
		try {
			em.getTransaction().begin();
			em.merge(apartamento);
			em.flush();
			em.getTransaction().commit();
			return apartamento;
		}catch(Exception eAtualizar) {
			em.getTransaction().rollback();
			throw eAtualizar;
		}
	}

	/**
	 * @param --> O metodo buscar recebe um parametro pesquisar -com todos os atributos internalizados- do tipo apartamento para realizar uma busca no banco de dados do apartamento desejado.
	 * @return--> Caso a operação  de Buscar seja bem sucedida, ela retona o apartamento deseja que esta no Banco de dados. 
	 * @throws Exception--> se apoeração de listar falhar, sera lançada uma Exception.
	 */
	public Apartamento buscar(Apartamento apartamento) throws Exception{
		try {
			return (Apartamento) em.createQuery("FROM Apartamento a WHERE a.bloco = :bloco and a.numero = :numero")
					.setParameter("bloco", apartamento.getBloco())
					.setParameter("numero", apartamento.getNumero())
					.getSingleResult();
		} catch (Exception eBuscar) {
			throw eBuscar;
		}
	}

	/**
	 * @param --> O metodo deletar recebe um parametro apartamento-com todos os atibutos atributos internalizados- do tipo apartamento para exclusão do apartamento no banco de dados.
	 * @return--> Caso a operação de deletar seja bem sucedida, ela retona o valor boleano TRUE.
	 * @throws--> se apoeração  de deletar falhar, sera lançada uma Exception.
	 */
	public void deletar(Apartamento apartamento) throws Exception{
		try {
			em.getTransaction().begin();
			em.remove(this.buscar(apartamento));
			em.getTransaction().commit();
		} catch(Exception eDeletar) {
			em.getTransaction().rollback();
			throw eDeletar;
		}
	}
	
	/**
	 * @return--> Caso a operação de listar seja bem sucedida, ela retona uma lista com todos os apartamento salvos no banco de dados.
	 * @throws--> se apoeração de listar falhar, sera lançada uma Exception.
	 */
	@SuppressWarnings("unchecked")
	public List<Apartamento> listar() throws Exception{
		try {
			return em.createQuery("from " + Apartamento.class.getName()).getResultList();			
		} catch (Exception eListar) {
			eListar.printStackTrace();
			throw eListar;
		}
	}
	
	/**
	 * @param --> O metodo recebe um parametro bloco do tipo String.
	 * @return --> Caso a operação  de listar seja bem sucedida, ela retona uma lista dos apartamentos no Banco de dados relacionado ao bloco solicitado.
	 * @throws Exception --> se apoeração de listar falhar, sera lançada uma Exception.
	 */  
	public List<Apartamento> listarPorBloco(String bloco) throws Exception{
		try {
			return em.createQuery("select a from Apartamento a where a.bloco = :Bloco", Apartamento.class)
					.setParameter("Bloco", bloco)
					.getResultList();
		} catch (Exception eListarBloco) {
			throw eListarBloco;
		}
	}
	
	/**
	 * @param --> O metodo recebe um parametro numero do tipo inteiro.
	 * @return --> Caso a operação  de listar seja bem sucedida, ela retona uma lista dos apartamentos no Banco de dados relacionado ao numero solicitado.
	 * @throws Exception --> se apoeração de listar falhar, sera lançada uma Exception.
	 */
	@Override
	public List<Apartamento> listarPorNumero(Integer numero) throws Exception {
		try {
			return em.createQuery("select a from Apartamento a where a.numero = :numero", Apartamento.class)
					.setParameter("numero", numero)
					.getResultList();
		} catch (Exception eListarNumero) {
			throw eListarNumero;
		}
	}
}
