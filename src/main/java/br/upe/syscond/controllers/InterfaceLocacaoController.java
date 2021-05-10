package br.upe.syscond.controllers;

import java.sql.Date;
import java.util.List;

import br.upe.syscond.models.Espaco;

public interface InterfaceLocacaoController {
	public Espaco criar(Espaco locacao)throws Exception;
	public Espaco buscar(Espaco locacao)throws Exception;
	public Espaco atualizar(Espaco novo)throws Exception;
	public void deletar(Espaco locacao)throws Exception;
	public List<Espaco> listar()throws Exception;
	public List<Espaco> listar(Date data)throws Exception;

}
