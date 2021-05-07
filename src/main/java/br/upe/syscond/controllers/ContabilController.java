package br.upe.syscond.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.upe.syscond.dao.ContabilDAO;
import br.upe.syscond.dao.ContasDAO;
import br.upe.syscond.models.Contabil;
import br.upe.syscond.models.Contas;

public class ContabilController implements InterfaceContabilController{
	private static ContabilController instance;
	private Contabil contabil;
/**
 * 
 * @return instance
 */
	public static ContabilController getInstance() {
		if(instance == null) {
			instance = new ContabilController();
		}
		return instance;
	}
	private ContabilController() {
		if(ContabilDAO.getInstance().listar().size()==0) {
			try {
				this.contabil = ContabilDAO.getInstance().salvar(new Contabil(null, 0));
			} catch (Exception e) {
				System.out.println("Erro!");
			}
		}else {
			this.contabil = ContabilDAO.getInstance().buscar(1);
		}
	}
	/**
	 * @param Apartamento
	 * @return null || Conta
	 */
	public Contas criar(Contas conta){
		
		if(this.buscar(conta) != null) {
			return null;
		}
		
		try {
			atualizaSaldo(conta);
			return ContasDAO.getInstance().salvar(conta);
		} catch (Exception eSalvar) {
			System.err.println("Erro ao salvar conta");
			return null;
		}
	}
	/**
	 * @return Conta[]
	 */
	public List<Contas> listar(){
		try {
			List<Contas> l = ContasDAO.getInstance().listar();
			return l;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar Conta(s)!");
			return null;
		}
	}
	/**
	 * @param Conta
	 * @return Conta || null
	 */
	public Contas buscar(Contas conta){
		
		List<Contas> contasBD = this.listar();

		for (Contas contas : contasBD) {
			if(contas.equals(conta)) {
				return contas;
			}
		}
		return null;
	}
	/**
	 * @param Conta
	 * @return Conta[]
	 */
	public List<Contas> buscarPorData(Contas conta){
		LocalDate data_vencimento = conta.getDataVencimento();

		List<Contas> contasBD = this.listar();

		List<Contas> contas_porData = new ArrayList<Contas>();

		for (int i = 0; i < contasBD.size(); i++) {
			if(contasBD.get(i).getDataVencimento().equals(data_vencimento)) {
				contas_porData.add(contasBD.get(i));
			}
		}
		return contas_porData;
	}
	/**
	 * @param Conta antiga
	 * @param Conta nova
	 * @return Conta
	 */
	public Contas atualizar(Contas antiga, Contas nova){
		int id = this.buscar(antiga).getId();
		try {
			nova.setId(id);
			atualizaSaldo(nova);
			Contas atualizada = ContasDAO.getInstance().atualizar(nova);
			return atualizada;
		} catch (Exception eAtualizar) {
			System.err.println("Erro ao atualizar Contabil!");
			return null;
		}
	}
	/**
	 * @param Conta
	 * @return boolean
	 */
	public Boolean deletar(Contas conta){
		try {
			conta.setId(this.buscar(conta).getId());			
		}catch (Exception e) {

		}
		if(conta.getStatusPaga()) {
			if(conta.getAReceber()) {
				this.contabil.setSaldo(this.contabil.getSaldo()-conta.getValor());
				try {
					ContabilDAO.getInstance().atualizar(contabil);
				} catch (Exception e) {
					System.err.println(e);
				}
			}else {
				this.contabil.setSaldo(this.contabil.getSaldo()+conta.getValor());
				try {
					ContabilDAO.getInstance().atualizar(contabil);
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		}

		try {
			ContasDAO.getInstance().deletar(conta.getId());
			return true;
		} catch (Exception eDeletar) {
			System.err.println("Erro ao excluir Contabil!");
			return false;
		}
	}
	/**
	 * @param Conta
	 * @return boolean
	 */
	private Boolean atualizaSaldo(Contas conta) {
		if(conta.getStatusPaga()) {
			if(conta.getAReceber()) {
				this.contabil.setSaldo(this.contabil.getSaldo()+conta.getValor());
				try {
					ContabilDAO.getInstance().atualizar(contabil);
					return true;
				} catch (Exception e) {
					System.err.println(e);
					return false;
				}
			}else {
				if(this.contabil.getSaldo() >= conta.getValor()) {
					try {
						this.contabil.setSaldo(this.contabil.getSaldo()-conta.getValor());
						ContabilDAO.getInstance().atualizar(contabil);
						return true;
					} catch (Exception e) {
						System.err.println(e);
						return false;
					}

				}else {
					return false;
				}
			}
		}else {
			return true;
		}
	}

}