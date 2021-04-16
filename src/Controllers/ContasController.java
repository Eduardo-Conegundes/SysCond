package Controllers;

import java.util.Calendar;
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

	public Contas atualizar(int id, String identificador, String pagador, String beneficiario, float valor, Calendar dataEmissao,
			Calendar dataVencimento, Boolean AReceber){

		Contas b = null;

		try {
			b = ContasDAO.getInstance().buscar(id);
		} catch (Exception eBuscar) {
			System.out.println("Erro ao buscar id!");
			return null;
		}

		if (b==null) {
			System.out.println("Contas não encontrada pelo id");
			return null;
		}else {
			
			Contas atualizado = new Contas(identificador, pagador, beneficiario, valor, dataEmissao,
			dataVencimento, AReceber);
			atualizado.setId(id);
			
			try {
				atualizado = ContasDAO.getInstance().atualizar(atualizado);
				System.out.println("Atualizado com sucesso: " + atualizado.getIdentificador() + " | " +  atualizado.getDataVencimento());
				return atualizado;
			} catch (Exception eSalvar) {
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
