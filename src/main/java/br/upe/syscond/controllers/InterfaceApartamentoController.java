package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.models.Apartamento;

public interface InterfaceApartamentoController {
	public Apartamento criar(Apartamento apartamento);
	public List<Apartamento> listar();
	public List<Apartamento> listar(String bloco);
	public Apartamento buscar(Apartamento apartamento);
	public Apartamento atualizar(Apartamento antigo, Apartamento novo);
	public boolean deletar(Apartamento apartamento);

}
