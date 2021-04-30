package br.upe.syscond.controllers;

import java.sql.Date;
import java.util.List;

import br.upe.syscond.models.Espaco;

public interface InterfaceLocacaoController {
	public Espaco criar(Espaco locacao);
	public Espaco buscar(Espaco locacao);
	public Espaco atualizar(Espaco antigo, Espaco novo);
	public boolean deletar(Espaco locacao);
	public List<Espaco> listar();
	public List<Espaco> listar(Date data);

}
