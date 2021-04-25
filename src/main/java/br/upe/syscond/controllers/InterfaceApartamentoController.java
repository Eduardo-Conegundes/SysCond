package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.models.Apartamento;

public interface InterfaceApartamentoController {
	public Apartamento criar(Apartamento apartamento);
	public List<Apartamento> listar();
	public List<Apartamento> listar(String bloco);
	public Apartamento buscar(int id);
	public Apartamento buscar(String bloco, int numero);
	public Apartamento atualizar(int id, int vagas);
	public void deletar(Apartamento apartamento);

}
