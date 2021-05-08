package br.upe.syscond.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.syscond.models.Apartamento;

public class ApartamentoDAO implements InterfaceApartamento {

	private static ApartamentoDAO instance;
	protected EntityManager em;
	/**
	 * 
	 * @return instance
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
	 * @return EntityManager
	 */
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		if(em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}

	/**
	 * param Apartamento
	 * @return Apartamento
	 */
	public Apartamento salvar(Apartamento apartamento) throws Exception{
		try {
			em.getTransaction().begin();
			em.persist(apartamento);
			em.getTransaction().commit();
			return this.buscar(apartamento);
		}catch(Exception eSalvar) {
			em.getTransaction().rollback();
			throw eSalvar;
		}
	}
	/**
	 * @param Apartamento
	 * @return Apartamento
	 */
	public Apartamento atualizar(Apartamento apartamento) throws Exception{
		try {
			em.getTransaction().begin();
			em.merge(apartamento);
			em.getTransaction().commit();
			return this.buscar(apartamento);
		}catch(Exception eAtualizar) {
			em.getTransaction().rollback();
			throw eAtualizar;
		}
	}

	/**
	 * @param integer
	 * @return Apartamento
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
	 * @param Apartamento
	 * @return boolean
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
	 * @return Lista de Apartamento[]
	 */
	@SuppressWarnings("unchecked")
	public List<Apartamento> listar() throws Exception{
		try {
			return (em.createQuery("from " + Apartamento.class.getName()).getResultList());			
		} catch (Exception eListar) {
			eListar.printStackTrace();
			throw eListar;
		}
	}
	/**
	 * @param bloco
	 * @return Apartamento[]
	 */    
	@SuppressWarnings("unchecked")
	public List<Apartamento> listarPorBloco(String bloco) throws Exception{
		try {
			return em.createQuery("select a from Apartamento a where a.bloco = :nomeBloco", Apartamento.class)
					.setParameter("nomeBloco", bloco)
					.getResultList();
		} catch (Exception eListarBloco) {
			throw eListarBloco;
		}
	}
}
