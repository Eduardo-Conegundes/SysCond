package br.upe.syscond.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.upe.syscond.dao.ContabilDAO;
import br.upe.syscond.dao.ContasDAO;
import br.upe.syscond.dao.InterfaceContabil;
import br.upe.syscond.dao.InterfaceContas;
import br.upe.syscond.models.Contabil;
import br.upe.syscond.models.Contas;

public class ContabilController implements InterfaceContabilController{

	private static InterfaceContas contasDAO = ContasDAO.getInstance();

	private static ContabilController instance;
	private InterfaceContabil contabilDAO = ContabilDAO.getInstance();
	private Contabil contabil;
	/**
	 * 
	 * @return instance
	 * @throws Exception 
	 */
	public static ContabilController getInstance() throws Exception {
		if(instance == null) {
			try {
				instance = new ContabilController();
			} catch (Exception e) {
				throw e;
			}
		}
		return instance;
	}
	private ContabilController() throws Exception {
		if(contabilDAO.listar().size()==0) {
			try {
				this.contabil = contabilDAO.salvar(new Contabil(null, 0));
			} catch (Exception e) {
				throw e;
			}
		}else {
			this.contabil = contabilDAO.buscar(1);
		}
	}
	/**
	 * @param Apartamento
	 * @return null || Conta
	 * @throws Exception 
	 */
	public Contas criar(Contas conta) throws Exception{
		try {
			atualizaSaldo(conta, false);
			return contasDAO.salvar(conta);
		} catch (Exception eSalvar) {
			throw eSalvar;
		}
	}
	/**
	 * @return Conta[]
	 * @throws Exception 
	 */
	public List<Contas> listar() throws Exception{
		try {
			return contasDAO.listar();
		} catch (Exception eListar) {
			throw eListar;
		}
	}
	/**
	 * @param Conta
	 * @return Conta || null
	 * @throws Exception 
	 */
	public Contas buscar(Contas conta) throws Exception{
		try {
			return contasDAO.buscar(conta);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @param Conta
	 * @return Conta[]
	 * @throws Exception 
	 */
	public List<Contas> buscarPorData(LocalDate data) throws Exception{
		try {
			return contasDAO.listarPorData(data);
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * @param Conta antiga
	 * @param Conta nova
	 * @return Conta
	 * @throws Exception 
	 */
	public Contas atualizar(Contas nova) throws Exception{
		try {
			atualizaSaldo(nova, false);
			return contasDAO.atualizar(nova);
		} catch (Exception eAtualizar) {
			throw eAtualizar;
		}
	}
	
	/**
	 * @param Conta
	 * @return boolean
	 * @throws Exception 
	 */
	public void deletar(Contas conta) throws Exception{
		try {
			atualizaSaldo(conta, true);
			contasDAO.deletar(conta);
		} catch (Exception eDeletar) {
			throw eDeletar;
		}
	}
	
	/**
	 * @param Conta
	 * @return boolean
	 * @throws Exception 
	 */
	private void atualizaSaldo(Contas conta, Boolean isDeletar) throws Exception {
		if(isDeletar) {
			if(conta.getStatusPaga()) {
				if(conta.getAReceber()) {
					this.contabil.setSaldo(this.contabil.getSaldo()+conta.getValor());
					try {
						contabilDAO.atualizar(contabil);
					} catch (Exception e) {
						throw e;
					}
				}else {
					if(this.contabil.getSaldo() >= conta.getValor()) {
						try {
							this.contabil.setSaldo(this.contabil.getSaldo()-conta.getValor());
							contabilDAO.atualizar(contabil);
						} catch (Exception e) {
							throw e;
						}
					}else {
						throw new Exception("Saldo Insuficiente");
					}
				}
			}
		}else {
			if(conta.getStatusPaga() ) {
				if(conta.getAReceber()) {
					this.contabil.setSaldo(this.contabil.getSaldo()-conta.getValor());
					try {
						contabilDAO.atualizar(contabil);
					} catch (Exception e) {
						throw e;
					}
				}else {
					this.contabil.setSaldo(this.contabil.getSaldo()+conta.getValor());
					try {
						contabilDAO.atualizar(contabil);
					} catch (Exception e) {
						throw e;
					}
				}
			}
		}

	}
}