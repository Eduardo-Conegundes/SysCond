package br.upe.syscond.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.syscond.models.Visitante;


public class VisitanteDAO implements InterfaceVisitante {

	private static VisitanteDAO instance;
	protected EntityManager em;
    /**
     * 
     * @return instance
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
     * @return EntityManager
     */
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		if (em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}
    /**
     * @param integer
	 * @return Visitante
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
	 * 
	 * @param Visitante
	 * @return Visitante
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
	 * @return Lista de Visitante[]
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
