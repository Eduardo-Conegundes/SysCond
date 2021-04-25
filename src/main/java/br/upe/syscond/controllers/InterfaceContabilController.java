package br.upe.syscond.controllers;

import java.time.LocalDate;
import java.util.List;

import br.upe.syscond.models.Contas;

public interface InterfaceContabilController {
	public Contas criar(Contas conta);
	public List<Contas> listar();
	public Contas buscar(int id);
	public List<Contas> buscar(LocalDate data_vencimento);
	public Contas atualizar(int id, Contas conta);
	public void deletar(int id);
}
