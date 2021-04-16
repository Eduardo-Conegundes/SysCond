package Controllers;

import java.util.List;

import DAO.ApartamentoDAO;
import DAO.PessoaDAO;
import DAO.VisitanteDAO;
import Models.Apartamento;
import Models.Pessoa;
import Models.Visitante;

public class VisitanteController {


	public Visitante criar(String cpf, int id) {

		Pessoa pessoa1 = null;
		Apartamento apartamento1 = null;
		Visitante visitante1 = null;
		try {
			pessoa1 = PessoaDAO.getInstance().buscar(cpf);
			apartamento1 = ApartamentoDAO.getInstance().buscar(id);
			visitante1 = new Visitante(pessoa1, apartamento1);
		} catch (Exception e) {
			System.out.println("Erro ao encontrar apartamento relacionado ao visitante!");
		}
		try {
			Visitante visit = VisitanteDAO.getInstance().salvar(visitante1);
			System.out.println("Visitante: " + visit.getPessoa().getNome() + " Está de visita no Aparatemento: " + visit.getApartamento().getNumero() + " do Bloco : " + visit.getApartamento().getBloco());
			return visit;			
		} catch (Exception e) {
			System.out.println("Erro ao salvar visitante!");
			return null;
		}
	}

	public Visitante buscar(String cpf){
		Visitante vistitante= null;
		try {
			vistitante = VisitanteDAO.getInstance().buscar(cpf);
			System.out.println("Visitante encontrado com sucesso: " + vistitante);
			return vistitante;
		} catch (Exception eBuscar) {
			System.out.println("Erro ao encontrar Visitante!");
			return null;
		}
	}

	public Visitante atualizar(String cpf, int id){
		Apartamento apartamento1 = null;
		Visitante vst = null;
		try {
			vst = VisitanteDAO.getInstance().buscar(cpf);
		} catch (Exception eBuscar) {
			System.out.println("Erro ao buscar Visitante!");
			return null;
		}
		try {
			apartamento1 = ApartamentoDAO.getInstance().buscar(id);
		} catch (Exception e) {
			System.out.println("Erro ao buscar Apartamento!");
	
		}

		if (vst==null || apartamento1 == null) {
			System.out.println("Visitante não encontrada pelo CPF Ou apartarmento não encontrado");
			return null;
		}		
		
		vst.setApartamento(apartamento1);
		 
		try {
			Visitante v = VisitanteDAO.getInstance().atualizar(vst);
			System.out.println("Apartamento de Bloco: " + v.getApartamento().getBloco() + "e Numero: " + v.getApartamento().getNumero() + "Foi atualizado para o visitante" + v.getPessoa().getNome());
			return v;
		} catch (Exception eAtualizar) {
			System.out.println("Erro ao atualizar o apartamento do visitante!");
			return null;
		}
	}


	public void deletar(String cpf){
		try {
			VisitanteDAO.getInstance().deletar(cpf);
			System.out.println("Visitante excluído com sucesso");
		} catch (Exception e) {
			System.out.println("Erro ao excluir Visitante!");
		}
	}



	public List<Visitante> listar(){
		try {
			List<Visitante> visitante1 = VisitanteDAO.getInstance().listar();
			System.out.println("Lista de Visitantes: " + visitante1.size());
			return visitante1;
		} catch (Exception eListar) {
			System.out.println("Erro ao listar Visitantes!");
			return null;
		}
	}


}
