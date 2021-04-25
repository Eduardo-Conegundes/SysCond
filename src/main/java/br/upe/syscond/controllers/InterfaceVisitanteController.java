package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.models.Apartamento;
import br.upe.syscond.models.Pessoa;
import br.upe.syscond.models.Visitante;

public interface InterfaceVisitanteController {
	public Visitante criar(Pessoa pessoaVisitanteVerificar, Apartamento apartamentoVerificar);
	public Visitante buscar(String cpf);
	public List<Visitante> listar();
	
}
