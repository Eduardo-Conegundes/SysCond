package br.upe.Controllers.Interface;

import java.sql.Date;
import java.util.List;

import br.upe.Models.Espaco;

public interface InterfaceLocacaoController {
	public Espaco criar(Espaco locacao);
	public Espaco buscar(int id);
	public Espaco atualizar(int id, Espaco locacao);
	public void deletar(int id);
	public List<Espaco> listar();
	public List<Espaco> listar(Date data);

}
