package br.upe.syscond.controllers;

import java.sql.Date;
import java.util.List;

import br.upe.syscond.models.Espaco;

public interface InterfaceLocacaoController {
	public Espaco criar(Espaco locacao);
	public Espaco buscar(int id);
	public Espaco atualizar(int id, Espaco locacao);
	public void deletar(int id);
	public List<Espaco> listar();
	public List<Espaco> listar(Date data);

}
