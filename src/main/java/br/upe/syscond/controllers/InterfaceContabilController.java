package br.upe.syscond.controllers;

import java.time.LocalDate;
import java.util.List;

import br.upe.syscond.models.Contas;

public interface InterfaceContabilController {
	public Contas criar(Contas conta) throws Exception;
	public List<Contas> listar() throws Exception;
	public Contas buscar(Contas conta) throws Exception;
	public List<Contas> buscarPorData(LocalDate data) throws Exception;
	public Contas atualizar(Contas nova) throws Exception;
	public void deletar(Contas conta) throws Exception;
}