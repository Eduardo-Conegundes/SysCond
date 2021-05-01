package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.models.Visitante;

public interface InterfaceVisitanteController {
	public Visitante criar(Visitante visitante);
	public Visitante buscar(Visitante visitante);
	public List<Visitante> listar();
	
}
