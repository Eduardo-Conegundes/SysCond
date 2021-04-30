package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.models.Pessoa;

public interface InterfacePessoaController {
	public Pessoa criar(Pessoa pessoa);
	public List<Pessoa> listar();
	public Pessoa buscar(Pessoa pessoa);
	public Pessoa atualizar(Pessoa antiga, Pessoa nova);
	public boolean deletar(Pessoa pessoa);
}
