package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.models.Veiculo;

public interface InterfaceVeiculoController {
	public Veiculo criar(Veiculo veiculo);
	public List<Veiculo> listar();
	public Veiculo buscar(Veiculo veiculo);
	public Veiculo atualizar(Veiculo novo);
	public boolean deletar(Veiculo veiculo);
}
