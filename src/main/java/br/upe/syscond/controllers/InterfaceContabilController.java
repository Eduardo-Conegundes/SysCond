package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.models.Contas;

public interface InterfaceContabilController {
	public Contas criar(Contas conta);
	public List<Contas> listar();
	public Contas buscar(Contas conta);
	public List<Contas> buscarPorData(Contas buscar);
	public Contas atualizar(Contas antiga, Contas nova);
	public Boolean deletar(Contas conta);
}
