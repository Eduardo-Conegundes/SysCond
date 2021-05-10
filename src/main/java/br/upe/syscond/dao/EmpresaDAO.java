package br.upe.syscond.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.upe.syscond.models.Empresa;

public class EmpresaDAO implements InterfaceEmpresa {

    /**
     * 
     * @variavel --> Variavel gobal instance do tipo EmpresaDAO e variavel em do tipo EntityManager.
     */
	private static EmpresaDAO instance;
	protected EntityManager em;

    /**
     * 
     * @return instance --> Retorno do estanciamento do EmpresaDAO.
     */	
	public static EmpresaDAO getInstance() {
		if (instance == null) {
			instance = new EmpresaDAO();
		}
		return instance;
	}

	private EmpresaDAO() {
		em = getEntityManager();
	}
	
    /**
     * 
     * @return instance --> Retorno do estanciamento do EmpresaDAO.
     */
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		if (em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}

	/**
	 * @param --> O metodo salvar recebe um parametro E-com todos os atributos internalizados- do tipo Empresa para salvar no banco de dados.
	 * @return--> Caso a operacao de salvar seja bem sucedida, ela retona uma Empresa salvo no banco de dados.
	 * @throws--> se apoeracao  de salvar falhar, sera lancada uma Exception.
	 */ 
	public Empresa salvar(Empresa empresa) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(empresa);
			em.flush();
			em.getTransaction().commit();
			return empresa;
		} catch (Exception eSalvar) {
			em.getTransaction().rollback();
			throw eSalvar;
		}
	}

	/**
	 * @param --> O metodo atualizar recebe um parametro E -com um ou diversos atributos internalizados- do tipo Empresa para atualizar o Empresa antigo no banco de dados.
	 * @return--> Caso a operacao de atualizar seja bem sucedida, ela retona a Empresa antigo com as informacoes atualizadas no banco de dados.
	 * @throws--> se apoeracao  de atualizar falhar, sera lancada uma Exception.
	 */ 
	public Empresa atualizar(Empresa empresa) throws Exception {
		try {
			em.getTransaction().begin();
			em.merge(empresa);
			em.flush();
			em.getTransaction().commit();
			return empresa;
		} catch (Exception eAtualizar) {
			em.getTransaction().rollback();
			throw eAtualizar;
		}
	}

	/**
	 * @param --> O metodo deletar recebe um parametro id do tipo integer para exclusao da Empresa solicitado no banco de dados.
	 * @throws--> se a operacao  de deletar falhar, sera lancada uma Exception.
	 */
	public void deletar(Empresa empresa) throws Exception {
		try {
			em.getTransaction().begin();
			em.remove(this.buscar(empresa));
			em.getTransaction().commit();
		} catch (Exception eDeletar) {
			em.getTransaction().rollback();
			throw eDeletar;
		}
	}
	
	/**
	 * @param --> O metodo buscar recebe um parametro id  do tipo integer para realizar uma busca no banco de dados da Empresa solicitado.
	 * @return--> Caso a operacao de Buscar seja bem sucedida, ela retona a Empresa deseja que esta no Banco de dados. 
	 * @throws Exception--> se apoeracao de listar falhar, sera lancada uma Exception.
	 */ 
	public Empresa buscar(Empresa empresa) throws Exception {

		try {
			return (Empresa) em.createQuery("FROM Empresa a WHERE a.cnpj = :cnpj and a.nome = :nome and a.telefone = :telefone")
					.setParameter("cnpj", empresa.getCnpj())
					.setParameter("nome", empresa.getNome())
					.setParameter("telefone", empresa.getTelefone())
					.getSingleResult();
		} catch (Exception eBuscar) {
			em.getTransaction().rollback();
			throw eBuscar;
		}
	}
	
	/**
	 * @return--> Caso a operacao de listar seja bem sucedida, ela retona uma lista com todas as Empresa salvos no banco de dados.
	 * @throws--> se apoeracaoo de listar falhar, sera lancada uma Exception.
	 */
	@SuppressWarnings("unchecked")
	public List<Empresa> listar() {
		try {
			return (em.createQuery("from " + Empresa.class.getName()).getResultList());
		} catch (Exception eListar) {
			throw eListar;
		}
	}
}
