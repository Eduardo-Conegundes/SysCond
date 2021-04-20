package Controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import DAO.ContabilDAO;
import DAO.ContasDAO;
import Models.Contabil;
import Models.Contas;

public class ContabilController {
	private static ContabilController instance;
	private Contabil contabil;

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

	public Contas criar(Contas conta){

		Contas criada = null;

		List<Contas> contasBD = this.listar();

		if(contasBD.size()==0) {
			try {
				System.out.println("Conta Salva com Sucesso!");
				criada = ContasDAO.getInstance().salvar(conta);
				return criada;	
			} catch (Exception eSalvar) {
				System.err.println("Erro ao salvar conta");
			}
		}else{
			for (int i = 0; i < contasBD.size(); i++) {
				if(contasBD.get(i).equals(conta)) {
					System.out.println("Conta ja existe!");
					return null;
				}
			}
			try {
				if(atualizaSaldo(conta)) {
					System.out.println("Conta Salva com Sucesso!");
					criada = ContasDAO.getInstance().salvar(conta);					
				}
			} catch (Exception eSalvar) {
				System.err.println("Erro ao salvar conta");
			}
		}
		return criada;
	}

	public List<Contas> listar(){
		try {
			List<Contas> l = ContasDAO.getInstance().listar();
			System.out.println("Lido com sucesso!");
			return l;
		} catch (Exception eListar) {
			eListar.printStackTrace();
			System.err.println("Erro ao listar Conta(s)!");
			return null;
		}
	}

	public Contas buscar(int id){
		try {
			Contas conta = ContasDAO.getInstance().buscar(id);
			System.out.println("Conta encontrada com sucesso: " + conta.getId());
			return conta;
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar Conta");
			return null;
		}
	}

	public List<Contas> buscar(LocalDate data_vencimento){

		List<Contas> contasBD = this.listar();

		List<Contas> contas_porData = new ArrayList<Contas>();

		for (int i = 0; i < contasBD.size(); i++) {
			if(contasBD.get(i).getDataVencimento().equals(data_vencimento)) {
				contas_porData.add(contasBD.get(i));
			}
		}
		return contas_porData;
	}

	public Contas atualizar(int id, Contas conta){
		this.buscar(id);
		conta.setId(id);
		try {
			atualizaSaldo(conta);
			Contas atualizada = ContasDAO.getInstance().atualizar(conta);
			System.out.println("Atualizado com sucesso!" + atualizada.getId());
			return atualizada;
		} catch (Exception eAtualizar) {
			System.err.println("Erro ao atualizar Contabil!");
			return null;
		}
	}

	public void deletar(int id){
		Contas conta = this.buscar(id);

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
			ContasDAO.getInstance().deletar(id);
			System.out.println("Excluído com sucesso");
		} catch (Exception eDeletar) {
			System.err.println("Erro ao excluir Contabil!");
		}
	}

	private Boolean atualizaSaldo(Contas conta) {
		if(conta.getStatusPaga()) {
			if(conta.getAReceber()) {
				this.contabil.setSaldo(this.contabil.getSaldo()+conta.getValor());
				try {
					ContabilDAO.getInstance().atualizar(contabil);
				} catch (Exception e) {
					System.err.println(e);
				}
			}else {
				if(this.contabil.getSaldo() >= conta.getValor()) {
					try {
						this.contabil.setSaldo(this.contabil.getSaldo()-conta.getValor());
						ContabilDAO.getInstance().atualizar(contabil);
						return true;
					} catch (Exception e) {
						System.err.println(e);
					}

				}else {
					System.out.println("Saldo insuficiente para efetuar o pagamento!");
					return false;
				}
			}
		}else {
			return true;
		}
		return null;
	}

}