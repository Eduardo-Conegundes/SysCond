package br.upe.syscond.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.syscond.models.Contas;

public class ContasDAO implements InterfaceContas{
	
	private static ContasDAO instance;
    protected EntityManager em;
    /**
     * 
     * @return instance
     */   
    public static ContasDAO getInstance() {
    	if(instance == null) {
    		instance = new ContasDAO();
    	}
    	return instance;
    }
    
    private ContasDAO() {
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
     * @param Contas
	 * @return Contas
	 */  	
    public Contas salvar(Contas contas) throws Exception{
    	try {
    		em.getTransaction().begin();
    		em.persist(contas);
    		em.flush();
    		em.getTransaction().commit();
    		return contas;
    	}catch(Exception eSalvar) {
    		em.getTransaction().rollback();
    		throw eSalvar;
    	}
    }
    /**
     * @param Contas
	 * @return Contas
	 */    
    public Contas atualizar(Contas contas) throws Exception{
    	try {
    		em.getTransaction().begin();
    		em.merge(contas);
    		em.flush();
    		em.getTransaction().commit();
    		return contas;
    	}catch(Exception eAtualizar) {
    		em.getTransaction().rollback();
    		throw eAtualizar;
    	}
    }
     /**
     * @param integer
	 * @return boolean
	 */   
    public void deletar(Contas contas) throws Exception{
    	try {
    		em.getTransaction().begin();
    		em.remove(contas);
    		em.getTransaction().commit();
    	} catch(Exception eDeletar) {
    		em.getTransaction().rollback();
    		throw eDeletar;
    	}
    }
    /**
     * @param integer
	 * @return Contas
	 */    
    public Contas buscar(Contas conta) throws Exception {
    	try {
    		return (Contas) em.createQuery("From Contas c where c.identificador =:identificador and "
    				+ "c.pagador =:pagador and "
    				+ "c.beneficiario =:beneficiario and "
    				+ "c.valor =:valor and "
    				+ "c.dataEmissao =:dataEmissao and "
    				+ "c.dataVencimento =:dataVencimento and "
    				+ "c.AReceber =:AReceber and "
    				+ "c.statusPaga =:statusPaga")
    		.setParameter("AReceber", conta.getAReceber())
    		.setParameter("statusPaga", conta.getStatusPaga())
    		.setParameter("dataVencimento", conta.getDataVencimento())
    		.setParameter("dataEmissao", conta.getDataEmissao())
    		.setParameter("valor", conta.getValor())
    		.setParameter("beneficiario", conta.getBeneficiario())
    		.setParameter("pagador", conta.getPagador())
    		.setParameter("identificador", conta.getIdentificador())
    		.getSingleResult();
    	} catch(Exception eBuscar) {
    		throw eBuscar;
    	}
    }
    
	@SuppressWarnings("unchecked")
	public List<Contas> listarPorData(LocalDate data) throws Exception{
    	try {
			return em.createQuery("from Contas c where c.dataVencimento =:vencimento")
					.setParameter("vencimento", data)
					.getResultList();
		} catch (Exception e) {
			throw e;
		}
    }
    
    /**
	 * @return Lista de Contas[]
	 */    
    @SuppressWarnings("unchecked")
	public List<Contas> listar(){
    	try {
    		return (em.createQuery("from " + Contas.class.getName()).getResultList());
		} catch (Exception eListar) {
			throw eListar;
		}
    }
}
