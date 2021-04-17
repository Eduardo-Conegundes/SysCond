package Controllers;

import java.util.List;

import DAO.ContasDAO;
import Models.Contas;

public class ContasController {

	public Contas criar(Contas contas){

		try {
			Contas cadastrado = ContasDAO.getInstance().salvar(contas);
			System.out.println("Salvo " + cadastrado.getIdentificador() + " com sucesso.");
			return cadastrado;
		} catch (Exception eSalvar) {
			System.out.println("Erro ao salvar Contas!");
			return null;
		}

	}

	public List<Contas> listar(){
		try {
			List<Contas> l = ContasDAO.getInstance().listar();
			System.out.println("Listar com sucesso: " + l.size());
			return l;
		} catch (Exception eListar) {
			System.out.println("Erro ao listar Contas(s)!");
			return null;
		}
	}

	public Contas buscar(int id) {
		try {
			Contas b = ContasDAO.getInstance().buscar(id);
			System.out.println("Achado com sucesso: " + b.getIdentificador() + " | " +  b.getDataVencimento());
			return b;
		} catch (Exception eBuscar) {
			System.out.println("Erro ao buscar Contas!");
			return null;
		}
	}

	public Contas atualizar(int id, Contas contas){
		Contas b = null;

		try {
			b = this.buscar(id);
		} catch (Exception eBuscar) {
			System.out.println("Erro ao buscar id!");
			return null;
		}

		if (b==null) {
			System.out.println("Contas não encontrada pelo id");
			return null;
		}else {
			
			contas.setId(b.getId());
	
			try {
				contas = ContasDAO.getInstance().atualizar(contas);
				System.out.println("Atualizado com sucesso: " + contas.getIdentificador() + " | " +  contas.getDataVencimento());
				return contas;
			} catch (Exception eAtualizar) {
				System.out.println("Erro ao atualizar Contas!");
				return null;
			}
		}
	}

	public void deletar(int id){
		try {
			ContasDAO.getInstance().deletar(id);
			System.out.println("Excluído com sucesso");
		} catch (Exception e) {
			System.out.println("Erro ao excluir Contas!");
		}
	}
}
