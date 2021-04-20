package br.upe.Controllers.Interface;

import java.util.List;

import br.upe.Models.Pessoa;

public interface InterfacePessoaController {
	public Pessoa criar(Pessoa pessoa);
	public List<Pessoa> listar();
	public Pessoa buscar(String cpf);
	public Pessoa atualizar(Pessoa pessoa);
	public void deletarPorId(String cpf);
}
