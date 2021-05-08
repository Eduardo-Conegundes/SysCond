package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.models.Veiculo;

public interface InterfaceVeiculoController {
	public Veiculo criar(Veiculo veiculo) throws Exception;
	public List<Veiculo> listar() throws Exception;
	public Veiculo buscar(Veiculo veiculo) throws Exception;
	public Veiculo atualizar(Veiculo novo) throws Exception;
	public void deletar(Veiculo veiculo) throws Exception;
}