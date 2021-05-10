package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.InterfaceVisitante;
import br.upe.syscond.dao.VisitanteDAO;
import br.upe.syscond.models.Visitante;

public class VisitanteController implements InterfaceVisitanteController{
	/**
	 * @variavel --> criacao da variavel visitanteDAO do tipo visitante, recebendo uma instancia do visitanteDAO.
	 */ 
	static InterfaceVisitante visitanteDAO = VisitanteDAO.getInstance();

	/**
	 * @param --> O metodo criar recebe um parametro visitante-com todos atributos internalizados- do tipo visitante para salvar no banco de dados.
	 * @return--> Caso a operacao de criar seja bem sucedida, ela retona um visitante salvo no banco de dados.
	 * @throws--> se operacaoo  de salva falhar, sera lancada uma Exception.
	 */ 
	public Visitante criar(Visitante visitante) throws Exception {
			return visitanteDAO.salvar(visitante);		
	}
	
	/**
	 * @param --> O metodo buscar recebe um parametro visitante -com todos os atributos de uma visitante- do tipo visitante para realizar uma busca no banco de dados do visitante solicitada.
	 * @return--> Caso a operacao  de Buscar seja bem sucedida, ela retona o visitante deseja que esta no Banco de dados. 
	 * @throws Exception--> se operacao de listar falhar, sera lancada uma Exception.
	 */
	public List<Visitante> buscar(Visitante visitante) throws Exception{
			return visitanteDAO.buscar(visitante);
	}
	
	/**
	 * @return--> Caso a operacao de listar seja bem sucedida, ela retona uma lista com todos os visitante salvos no banco de dados.
	 * @throws--> se operacao de listar falhar, sera lancada uma Exception.
	 */
	public List<Visitante> listar() throws Exception{
			return visitanteDAO.listar();
	}

}
