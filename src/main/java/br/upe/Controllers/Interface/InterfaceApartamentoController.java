package br.upe.Controllers.Interface;

import java.util.List;

import br.upe.Models.Apartamento;

public interface InterfaceApartamentoController {
	public Apartamento criar(Apartamento apartamento);
	public List<Apartamento> listar();
	public List<Apartamento> listar(String bloco);
	public Apartamento buscar(int id);
	public Apartamento atualizar(int id, int vagas);
	public void deletar(Apartamento apartamento);

}
