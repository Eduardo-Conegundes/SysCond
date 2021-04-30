package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.models.Funcionario;

public interface InterfaceFuncionarioController {
	public Funcionario criar(Funcionario funcionario);
	public List<Funcionario> listar();
	public Funcionario buscar(Funcionario buscar);
	public Funcionario atualizar(Funcionario antigo, Funcionario novo);
	public boolean deletar(Funcionario funcionario);
}
