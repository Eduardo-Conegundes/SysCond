/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Empresa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DAO.Interface.InterfaceEmpresa;

public class EmpresaDAO implements InterfaceEmpresa {
  private static EmpresaDAO instance;
    protected EntityManager em;

    public static EmpresaDAO getInstance() {
        if (instance == null) {
            instance = new EmpresaDAO();
        }
        return instance;
    }

    private EmpresaDAO() {
        em = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        if (em == null) {
            em = factory.createEntityManager();
        }
        return em;
    }

    public void salvar(Empresa E) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(E);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            throw new Exception();
        }
    }

    public void atualizar(Empresa E) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(E);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            throw new Exception();
        }
    }
    

    public void deletar(String cnpj) throws Exception {
        Empresa E = null;
        try {
            em.getTransaction().begin();
            E = em.find(Empresa.class, cnpj);
            em.remove(E);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            throw new Exception();
        }
    }
    
    public Empresa listarId(String id) throws Exception {
        Empresa e = null;
        try {
            em.getTransaction().begin();
            e = em.find(Empresa.class, id);
            em.getTransaction().commit();
            return e;
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            throw new Exception();
        }
    }

    public List<Empresa> listar() {
        return (em.createQuery("from " + Empresa.class.getName()).getResultList());
    } 
}
