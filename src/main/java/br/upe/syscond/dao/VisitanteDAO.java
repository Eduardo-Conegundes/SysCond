package br.upe.syscond.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.syscond.models.Visitante;


public class VisitanteDAO implements InterfaceVisitante {

	 /**
     * 
     * @variavel --> Variavel gobal instance do tipo VisitanteDAO e variavel em do tipo EntityManager.
     */
	private static VisitanteDAO instance;
	protected EntityManager em;

    /**
     * 
     * @return instance --> Retorno do estanciamento do VisitanteDAO.
     */	
	public static VisitanteDAO getInstance() {
		if (instance == null) {
			instance = new VisitanteDAO();
		}
		return instance;
	}

	private VisitanteDAO() {
		em = getEntityManager();
	}
	
    /**
     * 
     * @return instance --> Retorno do estanciamento do VisitanteDAO.
     */
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		if (em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}
	
	/**
	 * @param --> O metodo buscar recebe um parametro visitante -com todos os atributos internalizados- do tipo visitante para realizar uma busca no banco de dados do visitante solicitado.
	 * @return--> Caso a operacao de Buscar seja bem sucedida, ela retonara a lista  de visitante de uma determinado morador.
	 * @throws Exception--> se apoeracao de listar falhar, sera lancada uma Exception.
	 */   
	@SuppressWarnings("unchecked")
	public List<Visitante> buscar(Visitante visitante) throws Exception {
		try {
			return em.createQuery("FROM Visitante v WHERE v.pessoa = :pessoa and v.apartamento = :apartamento")
					.setParameter("pessoa", visitante.getPessoa())
					.setParameter("apartamento", visitante.getApartamento())
					.getResultList();
		} catch (Exception eBuscar) {
			throw eBuscar;
		}
	}

	/**
	 * @param --> O metodo salvar recebe um parametro vis-com todos os atributos internalizados- do tipo visitante para salvar no banco de dados.
	 * @return--> Caso a operacao de salvar seja bem sucedida, ela retona um visitante salvo no banco de dados.
	 * @throws--> se apoeracao  de salvar falhar, sera lancada uma Exception.
	 */
	public Visitante salvar(Visitante vis) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(vis);
			em.flush();
			em.getTransaction().commit();
			return vis;
		} catch (Exception eSalvar) {
			em.getTransaction().rollback();
			throw eSalvar;
		}
	}
	
	/**
	 * @return--> Caso a operacao de listar seja bem sucedida, ela retona uma lista com todos os visitantes salvos no banco de dados.
	 * @throws--> se apoeracaoo de listar falhar, sera lancada uma Exception.
	 */
	@SuppressWarnings("unchecked")
	public List<Visitante> listar() {
		try {
			return (em.createQuery("from " + Visitante.class.getName()).getResultList());		
		} catch (Exception eListar) {
			throw eListar;
		}
	}

}
