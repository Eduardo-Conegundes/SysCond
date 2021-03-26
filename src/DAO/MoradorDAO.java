/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Morador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class MoradorDAO{

	private static MoradorDAO instance;
	protected EntityManager em;

	public static MoradorDAO getInstance() {
		if (instance == null) {
			instance = new MoradorDAO();
		}
		return instance;
	}

	private MoradorDAO() {
		em = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		if (em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}

	public void salvar(Morador morador) {
		try {
			em.getTransaction().begin();
			em.persist(morador);
			em.getTransaction().commit();
			System.out.println("Salvo morador com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			System.out.println("Erro ao salvar morador");
		}
	}

	public void atualizar(Morador morador) {
		try {
			em.getTransaction().begin();
			em.merge(morador);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public void deletar(String cpf) {
		Morador m = null;
		try {
			em.getTransaction().begin();
			m = em.find(Morador.class, cpf);
			em.remove(m);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public List<Morador> listar() {
		return (em.createQuery("from " + Morador.class.getName()).getResultList());
	}
}
