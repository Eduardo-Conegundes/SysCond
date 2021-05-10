package br.upe.syscond.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.upe.syscond.models.Espaco;


public class LocacaoDAO implements InterfaceLocacao {

    /**
     * 
     * @variavel --> Variavel gobal instance do tipo LocacaoDAO e variavel em do tipo EntityManager.
     */
	private static LocacaoDAO instance;
	protected EntityManager em;

    /**
     * 
     * @return instance --> Retorno do estanciamento do LocacaoDAO.
     */	
	public static LocacaoDAO getInstance() {
		if (instance == null) {
			instance = new LocacaoDAO();
		}
		return instance;
	}

	private LocacaoDAO() {
		em = getEntityManager();
	}
	
    /**
     * 
     * @return instance --> Retorno do estanciamento do LocacaoDAO.
     */
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		if (em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}
	
	/**
	 * @param --> O metodo buscar recebe um parametro id do tipo integer para realizar uma busca no banco de dados da locacao solicitado.
	 * @return--> Caso a operacao de Buscar seja bem sucedida, ela retona a Locacao deseja que esta no Banco de dados. 
	 * @throws Exception--> se apoeracao de listar falhar, sera lancada uma Exception.
	 */  
	public Espaco buscar(Espaco locacao) throws Exception {
		try {
			return (Espaco) em.createQuery("FROM Espaco a WHERE a.data = :data and a.horarioInicio = :horarioInicio and a.horarioFim = :horarioFim and a.espaco = :espaco and a.valor = :valor")
					.setParameter("data", locacao.getData())
					.setParameter("horarioInicio", locacao.getHorarioInicio())
					.setParameter("horarioFim", locacao.getHorarioFim())
					.setParameter("espaco", locacao.getEspaco())
					.setParameter("valor", locacao.getValor())
					.setParameter("data", locacao)
					.setParameter("data", locacao)
					.getSingleResult();
		} catch (Exception eBuscar) {
			em.getTransaction().rollback();
			throw eBuscar;
		}
	}

	/**
	 * @param --> O metodo salvar recebe um parametro l-com todos os atributos internalizados- do tipo Espaco para salvar no banco de dados.
	 * @return--> Caso a operacao de salvar seja bem sucedida, ela retona uma Locacao salvo no banco de dados.
	 * @throws--> se apoeracao  de salvar falhar, sera lancada uma Exception.
	 */
	public Espaco salvar(Espaco locacao) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(locacao);
			em.flush();
			em.getTransaction().commit();
			return locacao;
		} catch (Exception eSalvar) {
			em.getTransaction().rollback();
			throw eSalvar;
		}
	}

	/**
	 * @param --> O metodo atualizar recebe um parametro l-com um ou diversos atributos internalizados- do tipo Espaco para atualizar a locacao antigo no banco de dados.
	 * @return--> Caso a operacao de atualizar seja bem sucedida, ela retona a locacao antigo com as informacoes atualizadas no banco de dados.
	 * @throws--> se apoeracao  de atualizar falhar, sera lancada uma Exception.
	 */ 
	public Espaco atualizar(Espaco locacao) throws Exception {
		try {
			em.getTransaction().begin();
			em.merge(locacao);
			em.flush();
			em.getTransaction().commit();
			return locacao;
		} catch (Exception eAtualizar) {
			em.getTransaction().rollback();
			throw eAtualizar;
		}
	}

	/**
	 * @param --> O metodo deletar recebe um parametro id do tipo integer para exclusao da locacao solicitado no banco de dados.
	 * @throws--> se a operacao  de deletar falhar, sera lancada uma Exception.
	 */
	public void deletar(Espaco locacao) throws Exception {
		try {
			em.getTransaction().begin();
			em.remove(this.buscar(locacao));
			em.getTransaction().commit();
		} catch (Exception eDeletar) {
			em.getTransaction().rollback();
			throw eDeletar;
		}
	}
	
	/**
	 * @return--> Caso a operacao de listar seja bem sucedida, ela retona uma lista com todas as locacao salvos no banco de dados.
	 * @throws--> se apoeracaoo de listar falhar, sera lancada uma Exception.
	 */
	@SuppressWarnings("unchecked")
	public List<Espaco> listar() {
		try {
			return (em.createQuery("from " + Espaco.class.getName()).getResultList());
		} catch (Exception eListar) {
			throw eListar;
		}

	}

}
