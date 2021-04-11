package Controllers;

import java.util.List;

import DAO.ApartamentoDAO;
import Models.Apartamento;

public class ApartamentoController {

	public Apartamento criar(String bloco, int numero,  int vagas){

		//retorna a lista de apartamentos cadastrados
		List<Apartamento> ap = this.listar();

		for (int i = 0; i < ap.size(); i++) {

			//procura se existe algum apartamento com o bloco e numero já cadastrado
			if(ap.get(i).getBloco().compareTo(bloco) == 0 && ap.get(i).getNumero() == numero) {
				System.out.println("Erro ao salvar Apartamento, já existe cadastrado com os mesmos dados");
				return null;
			}
		}
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
			System.out.println("Apartamento não encontrado.");
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

	public void deletar(int id){
		try {
			ApartamentoDAO.getInstance().deletarPorId(id);
			System.out.println("Excluído com sucesso");
		} catch (Exception e) {
			System.out.println("Erro ao excluir Apartamento!");
		}
	}
}
