package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.models.Pessoa;

public interface InterfacePessoaController {
	public Pessoa criar(Pessoa pessoa)throws Exception;
	public List<Pessoa> listar()throws Exception;
	public Pessoa buscar(Pessoa pessoa)throws Exception;
	public Pessoa atualizar(Pessoa pessoa)throws Exception;
	public boolean deletar(Pessoa pessoa)throws Exception;
}
