package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.models.Veiculo;

public interface InterfaceVeiculoController {
	public Veiculo criar(Veiculo veiculo);
	public List<Veiculo> listar();
	public Veiculo buscar(String placa);
	public Veiculo atualizar(int idApartamentoNovo, Veiculo veiculo);
	public void deletar(String placa);
}
