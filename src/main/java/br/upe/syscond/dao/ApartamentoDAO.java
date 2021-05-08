package br.upe.syscond.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
			em.flush();
			em.getTransaction().commit();
			return apartamento;
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
			em.flush();
			em.getTransaction().commit();
			return apartamento;
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
			return em.createQuery("from " + Apartamento.class.getName()).getResultList();			
		} catch (Exception eListar) {
			eListar.printStackTrace();
			throw eListar;
		}
	}
	/**
	 * @param bloco
	 * @return Apartamento[]
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Apartamento> listarBlocos() throws Exception {
		try {
			return em.createQuery("select bloco from Apartamento").getResultList();
		} catch (Exception eListarNumero) {
			throw eListarNumero;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Apartamento> listarNumeros() throws Exception {
		try {
			return (List<Apartamento>) em.createQuery("select numero from Apartamento").getResultList();
		} catch (Exception eListarNumero) {
			throw eListarNumero;
		}
	}
}
