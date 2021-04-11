package Controllers;

import java.util.List;

import DAO.ApartamentoDAO;
import Models.Apartamento;

public class ApartamentoController {
	public Apartamento criar(String bloco, int numero,  int vagas){
		Apartamento Apartamento1 = new Apartamento(bloco,numero,vagas);

		try {
			Apartamento p = ApartamentoDAO.getInstance().salvar(Apartamento1);
			System.out.println("Salvo com sucesso: " + p.getNumero() + p.getBloco());
			return p;
		} catch (Exception eSalvar) {
			System.out.println("Erro ao salvar Apartamento!");
			return null;
		}
	}

	public List<Apartamento> listar(){
		try {
			List<Apartamento> l = ApartamentoDAO.getInstance().listar();
			System.out.println("Lido com sucesso! Resultados: " + l);
			return l;
		} catch (Exception eListar) {
			System.out.println("Erro ao listar Apartamento(s)!");
			return null;
		}

	}

	public Apartamento buscar(int id){
		try {
			Apartamento b = ApartamentoDAO.getInstance().buscar(id);
			System.out.println("Apartamento achado com sucesso: " + b.getNumero() + b.getBloco());
			return b;
		} catch (Exception eBuscar) {
			System.out.println("Erro ao buscar Apartamento!");
			return null;
		}
	}

	public Apartamento atualizar(int id, String bloco, int numero,  int vagas){
		Apartamento Apartamento2 = new Apartamento(bloco,numero,vagas);
		Apartamento2.setId(id);
		Apartamento b = null;
		try {
			b = ApartamentoDAO.getInstance().buscar(Apartamento2.getId());
		} catch (Exception eBuscar) {
			System.out.println("Erro ao buscar apartamento!");
			return null;
		}
		
		if (b==null) {
			System.out.println("Apartamento n�o encontrado.");
			return null;
		}		
		
		try {
			Apartamento a = ApartamentoDAO.getInstance().atualizar(Apartamento2);
			System.out.println("Atualizado com sucesso!" + a.getBloco() + a.getNumero() + a.getVagas());
			return a;
		} catch (Exception eSalvar) {
			System.out.println("Erro ao atualizar Apartamento!");
			return null;
		}
	}

	public void deletarPorId(int id){
		try {
			ApartamentoDAO.getInstance().deletarPorId(id);
			System.out.println("Exclu�do com sucesso");
		} catch (Exception e) {
			System.out.println("Erro ao excluir Apartamento!");
		}
	}
}