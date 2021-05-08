package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.models.Visitante;

public interface InterfaceVisitanteController {
	public Visitante criar(Visitante visitante) throws Exception;
	public List<Visitante> buscar(Visitante visitante) throws Exception;
	public List<Visitante> listar() throws Exception;
	
}
