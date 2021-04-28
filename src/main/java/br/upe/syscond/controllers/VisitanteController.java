package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.VisitanteDAO;
import br.upe.syscond.models.Apartamento;
import br.upe.syscond.models.Pessoa;
import br.upe.syscond.models.Visitante;

public class VisitanteController implements InterfaceVisitanteController{
	
	public Visitante criar(Pessoa pessoaVisitanteVerificar, Apartamento apartamentoVerificar) {

		PessoaController pesCont = new PessoaController();
		ApartamentoController aptCont = new ApartamentoController();
		Pessoa pessoaVisitanteBanco = null;
		Apartamento apartamentoBanco = null;
		
		try {
			pessoaVisitanteBanco = pesCont.buscar(pessoaVisitanteVerificar.getCpf());
			apartamentoBanco = aptCont.buscar(apartamentoVerificar);
		} catch (Exception e) {
			System.err.println("Erro ao encontrar apartamento relacionado ao visitante!");
		}
		
		if (apartamentoBanco == null) {
			return null;
		}
		
		if (pessoaVisitanteBanco == null) {
			pessoaVisitanteBanco = pesCont.criar(pessoaVisitanteVerificar);
		}
		
		
		try {
			Visitante visitante = new Visitante(pessoaVisitanteBanco, apartamentoBanco);
			visitante = VisitanteDAO.getInstance().salvar(visitante);
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
			return Visitante;
		} catch (Exception eBuscar) {
			System.err.println("Erro ao encontrar Visitante!");
			return null;
		}
	}

	public List<Visitante> listar(){
		try {
			List<Visitante> visitante = VisitanteDAO.getInstance().listar();
			return visitante;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar Visitantes!");
			return null;
		}
	}

}
