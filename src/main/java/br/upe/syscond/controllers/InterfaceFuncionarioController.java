package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.models.Funcionario;

public interface InterfaceFuncionarioController {
	public Funcionario criar(Funcionario funcionario) throws Exception;
	public List<Funcionario> listar() throws Exception;
	public Funcionario buscar(Funcionario buscar) throws Exception;
	public Funcionario atualizar(Funcionario funcionario) throws Exception;
	public void deletar(Funcionario funcionario) throws Exception;
}
