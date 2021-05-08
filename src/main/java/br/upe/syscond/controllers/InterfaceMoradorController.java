package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.models.Morador;

public interface InterfaceMoradorController {
	public Morador criar(Morador morador) throws Exception;
	public List<Morador> listar() throws Exception;
	public Morador buscar(Morador morador) throws Exception;
	public Morador atualizar(Morador novo) throws Exception;
	public void deletar(Morador morador) throws Exception;

}
