package br.upe.syscond.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.upe.syscond.models.Veiculo;

public class VeiculoDAO implements InterfaceVeiculo{
	 
	/**
     * 
     * @variavel --> Variavel gobal instance do tipo VeiculoDAO e variavel em do tipo EntityManager.
     */
	private static VeiculoDAO instance;
	protected EntityManager em;

    /**
     * 
     * @return instance --> Retorno do estanciamento do VeiculoDAO.
     */	
	public static VeiculoDAO getInstance() {
		if (instance == null) {
			instance = new VeiculoDAO();
		}
		return instance;
	}

	private VeiculoDAO() {
		em = getEntityManager();
	}
	
    /**
     * 
     * @return instance --> Retorno do estanciamento do VeiculoDAO.
     */
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		if (em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}

	/**
	 * @param --> O metodo salvar recebe um parametro veiculo-com todos os atributos internalizados- do tipo veiculo para salvar no banco de dados.
	 * @return--> Caso a operacao de salvar seja bem sucedida, ela retona um veiculo salvo no banco de dados.
	 * @throws--> se apoeracao  de salvar falhar, sera lancada uma Exception.
	 */
	public Veiculo salvar(Veiculo veiculo) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(veiculo);
			em.flush();
			em.getTransaction().commit();
			return veiculo;
		} catch (Exception eSalvar) {
			em.getTransaction().rollback();
			throw eSalvar;
		}

	}

	/**
	 * @param --> O metodo atualizar recebe um parametro veiculo-com um ou diversos atributos internalizados- do tipo veiculo para atualizar o veiculo antigo no banco de dados.
	 * @return--> Caso a operacao de atualizar seja bem sucedida, ela retona o veiculo antigo com as informacoes atualizadas no banco de dados.
	 * @throws--> se apoeracao  de atualizar falhar, sera lancada uma Exception.
	 */   
	public Veiculo atualizar(Veiculo veiculo) throws Exception {
		try {
			em.getTransaction().begin();
			em.merge(veiculo);
			em.flush();
			em.getTransaction().commit();
			return veiculo;
		} catch (Exception eAtualizar) {
			em.getTransaction().rollback();
			throw eAtualizar;
		}

	}
	
	/**
	 * @param --> O metodo buscar recebe um parametro veiculo -com todos os atributos internalizados- do tipo veiculo para realizar uma busca no banco de dados do veiculo solicitado.
	 * @return--> Caso a operacao de Buscar seja bem sucedida, ela retona o veiculo deseja que esta no Banco de dados. 
	 * @throws Exception--> se apoeracao de listar falhar, sera lancada uma Exception.
	 */   
	public Veiculo buscar(Veiculo veiculo) throws Exception {
		try {
			return (Veiculo) em.createQuery("from Veiculo v where v.placa = :placa and v.apartamento = :apartamento")
					.setParameter("placa", veiculo.getPlaca())
					.setParameter("apartamento", veiculo.getApartamento())
					.getSingleResult();
		} catch(Exception eBuscar) {
			throw eBuscar;
		}
	}

	/**
	 * @param --> O metodo deletar recebe um parametro veiculo-com todos os atibutos atributos internalizados- do tipo veiculo para exclusao do veiculo solicitado no banco de dados.
	 * @throws--> se a operacao  de deletar falhar, sera lancada uma Exception.
	 */
	public void deletar(Veiculo veiculo) throws Exception {
		try {
			em.getTransaction().begin();
			em.remove(veiculo);
			em.getTransaction().commit();
		} catch (Exception eDeletar) {
			em.getTransaction().rollback();
			throw eDeletar;
		}
	}
	
	/**
	 * @return--> Caso a operacao de listar seja bem sucedida, ela retona uma lista com todos os veiculos salvos no banco de dados.
	 * @throws--> se apoeracaoo de listar falhar, sera lancada uma Exception.
	 */
	@SuppressWarnings("unchecked")
	public List<Veiculo> listar() throws Exception {
		try {
			return (em.createQuery("from " + Veiculo.class.getName()).getResultList());
		} catch (Exception eListar) {
			throw eListar;
		}
	}
}
