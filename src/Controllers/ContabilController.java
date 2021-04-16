package Controllers;

import java.util.List;

import DAO.ContabilDAO;
import Models.Contabil;
import Models.Contas;

public class ContabilController {

	public Contabil criar(List<Contas> contas, float saldo){

		Contabil Contabil1 = new Contabil(contas, saldo);
		try {
			Contabil p = ContabilDAO.getInstance().salvar(Contabil1);
			System.out.println("Salvo com sucesso!!!" );
			return p;
		} catch (Exception eSalvar) {
			System.out.println("Erro ao salvar Contabil!");
			return null;
		}	
	}

	public List<Contabil> listar(){
		try {
			List<Contabil> l = ContabilDAO.getInstance().listar();
			System.out.println("Lido com sucesso! Resultados: " + l.size());
			return l;
		} catch (Exception eListar) {
			eListar.printStackTrace();
			System.out.println("Erro ao listar Contabil(s)!");
			return null;
		}

	}

	public Contabil buscar(int id){
		try {
			Contabil b = ContabilDAO.getInstance().buscar(id);
			System.out.println("Contabil achado com sucesso: " + b.getId());
			return b;
		} catch (Exception eBuscar) {
			System.out.println("Erro ao buscar Contabil!");
			return null;
		}
	}

	public Contabil atualizar(int id,List<Contas> contas){
		Contabil b = null;
		try {
			b = ContabilDAO.getInstance().buscar(id);
		} catch (Exception eBuscar) {
			System.out.println("Erro ao buscar Contabil!");
			return null;
		}

		if (b==null) {
			System.out.println("Contabil n�o encontrado.");
			return null;
		}
		
		Contabil Contabil2 = new Contabil(contas, b.getSaldo());
		Contabil2.setId(id);
		try {
			Contabil a = ContabilDAO.getInstance().atualizar(Contabil2);
			System.out.println("Atualizado com sucesso!" + a.getId());
			return a;
		} catch (Exception eAtualizar) {
			System.out.println("Erro ao atualizar Contabil!");
			return null;
		}
	}

	public void deletar(int id){
		try {
			ContabilDAO.getInstance().deletar(id);
			System.out.println("Exclu�do com sucesso");
		} catch (Exception eDeletar) {
			System.out.println("Erro ao excluir Contabil!");
		}
	}
}
