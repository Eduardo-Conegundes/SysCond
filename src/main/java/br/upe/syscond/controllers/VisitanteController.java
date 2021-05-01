package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.VisitanteDAO;
import br.upe.syscond.models.Visitante;

public class VisitanteController implements InterfaceVisitanteController{
	
	public Visitante criar(Visitante visitante) {
		
		if(this.buscar(visitante) != null) {
			return null;
		}
		
		try {
			return VisitanteDAO.getInstance().salvar(visitante);		
		} catch (Exception e) {
			System.err.println("Erro ao salvar visitante!");
			return null;
		}
	}

	public Visitante buscar(Visitante visitante){
		List<Visitante> lista = this.listar();
		for (Visitante visitante2 : lista) {
			if(visitante2.equals(visitante)) {
				return visitante2;
			}
		}
		return null;
	}

	public List<Visitante> listar(){
		try {
			return VisitanteDAO.getInstance().listar();
		} catch (Exception eListar) {
			System.err.println("Erro ao listar Visitantes!");
			return null;
		}
	}

}
