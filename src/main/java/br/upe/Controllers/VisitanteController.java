package br.upe.Controllers;

import java.util.List;

import br.upe.Controllers.Interface.InterfaceVisitanteController;
import br.upe.DAO.VisitanteDAO;
import br.upe.Models.Apartamento;
import br.upe.Models.Pessoa;
import br.upe.Models.Visitante;

public class VisitanteController implements InterfaceVisitanteController{
	
	public Visitante criar(Pessoa pessoaVisitanteVerificar, Apartamento apartamentoVerificar) {

		PessoaController pesCont = new PessoaController();
		ApartamentoController aptCont = new ApartamentoController();
		Pessoa pessoaVisitanteBanco = null;
		Apartamento apartamentoBanco = null;
		
		try {
			pessoaVisitanteBanco = pesCont.buscar(pessoaVisitanteVerificar.getCpf());
			apartamentoBanco = aptCont.buscar(apartamentoVerificar.getId());
		} catch (Exception e) {
			System.err.println("Erro ao encontrar apartamento relacionado ao visitante!");
		}
		
		if (apartamentoBanco == null) {
			System.out.println("Apartamento não encontrados.");
			return null;
		}
		
		if (pessoaVisitanteBanco == null) {
			pessoaVisitanteBanco = pesCont.criar(pessoaVisitanteVerificar);
		}
		
		
		try {
			Visitante visitante = new Visitante(pessoaVisitanteBanco, apartamentoBanco);
			visitante = VisitanteDAO.getInstance().salvar(visitante);
			System.out.println("Visitante: " + visitante.getPessoa().getNome() + " Visitando o apartemento: " + visitante.getApartamento().getNumero() + " do Bloco : " + visitante.getApartamento().getBloco());
			return visitante;			
		} catch (Exception e) {
			System.err.println("Erro ao salvar visitante!");
			return null;
		}
	}

	public Visitante buscar(String cpf){
		Visitante Visitante = null;
		try {
			Visitante = VisitanteDAO.getInstance().buscar(cpf);
			System.out.println("Visitante encontrado com sucesso: " + Visitante);
			return Visitante;
		} catch (Exception eBuscar) {
			System.err.println("Erro ao encontrar Visitante!");
			return null;
		}
	}

	public List<Visitante> listar(){
		try {
			List<Visitante> visitante = VisitanteDAO.getInstance().listar();
			System.out.println("Lista de Visitantes: " + visitante.size());
			return visitante;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar Visitantes!");
			return null;
		}
	}

}
