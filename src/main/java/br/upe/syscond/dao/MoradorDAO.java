package br.upe.syscond.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.upe.syscond.models.Morador;


public class MoradorDAO implements InterfaceMorador{

    /**
     * 
     * @variavel --> Variavel gobal instance do tipo MoradorDAO e variavel em do tipo EntityManager.
     */
	private static MoradorDAO instance;
	protected EntityManager em;

    /**
     * 
     * @return instance --> Retorno do estanciamento do MoradorDAO.
     */
	public static MoradorDAO getInstance() {
		if (instance == null) {
			instance = new MoradorDAO();
		}
		return instance;
	}

	private MoradorDAO() {
		em = getEntityManager();
	}
	
    /**
     * 
     * @return instance --> Retorno do estanciamento do MoradorDAO.
     */
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		if (em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}

	/**
	 * @param --> O metodo salvar recebe um parametro morador-com todos os atributos internalizados- do tipo morador para salvar no banco de dados.
	 * @return--> Caso a operação de salvar seja bem sucedida, ela retona um morador salvo no banco de dados.
	 * @throws--> se apoeração  de salvar falhar, sera lançada uma Exception.
	 */
	public Morador salvar(Morador morador) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(morador);
			em.flush();
			em.getTransaction().commit();
			return morador;
		} catch (Exception eSalvar) {
			em.getTransaction().rollback();
			throw eSalvar;
		}
	}
	
	/**
	 * @param --> O metodo buscar recebe um parametro morador -com todos os atributos internalizados- do tipo morador para realizar uma busca no banco de dados do morador solicitado.
	 * @return--> Caso a operação  de Buscar seja bem sucedida, ela retona o morador deseja que esta no Banco de dados. 
	 * @throws Exception--> se apoeração de listar falhar, sera lançada uma Exception.
	 */
	public Morador buscar(Morador morador) throws Exception {
		try {
			return (Morador) em.createQuery("From Morador m where m.pessoa = :pessoa and m.apartamento = :apartamento")
					.setParameter("pessoa", morador.getPessoa())
					.setParameter("apartamento", morador.getApartamento())
					.getSingleResult();
		} catch (Exception eBuscar) {
			throw eBuscar;
		}
	}

	/**
	 * @param --> O metodo atualizar recebe um parametro morador-com um ou diversos atributos internalizados- do tipo morador para atualizar o morador antigo no banco de dados.
	 * @return--> Caso a operação de atualizar seja bem sucedida, ela retona o morador antigo com as informações atualizadas no banco de dados.
	 * @throws--> se apoeração  de atualizar falhar, sera lançada uma Exception.
	 */
	public Morador atualizar(Morador morador) throws Exception {
		
		try {
			em.getTransaction().begin();
			em.merge(morador);
			em.getTransaction().commit();
			return morador;
		} catch (Exception eAtualizar) {
			em.getTransaction().rollback();
			throw eAtualizar;
		}
	}

	/**
	 * @param --> O metodo deletar recebe um parametro m-com todos os atibutos atributos internalizados- do tipo morador para exclusão do morador solicitado no banco de dados.
	 * @throws--> se a operação  de deletar falhar, sera lançada uma Exception.
	 */
	public void deletar(Morador m) throws Exception {
		try {
			em.getTransaction().begin();
			em.remove(m);
			em.getTransaction().commit();
		} catch (Exception eDeletar) {
			em.getTransaction().rollback();
			throw eDeletar;
		}
	}
	
	/**
	 * @return--> Caso a operação de listar seja bem sucedida, ela retona uma lista com todos os moradores salvos no banco de dados.
	 * @throws--> se apoeração de listar falhar, sera lançada uma Exception.
	 */
	@SuppressWarnings("unchecked")
	public List<Morador> listar() throws Exception {
		try {
			return (em.createQuery("from " + Morador.class.getName()).getResultList());			
		} catch (Exception eListar) {
			throw eListar;
		}
	}
}
