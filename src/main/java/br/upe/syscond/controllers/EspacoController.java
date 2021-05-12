package br.upe.syscond.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import br.upe.syscond.dao.InterfaceLocacao;
import br.upe.syscond.dao.LocacaoDAO;
import br.upe.syscond.models.Espaco;

public class EspacoController implements InterfaceLocacaoController {
	
	
	static InterfaceLocacao espacoDAO = LocacaoDAO.getInstance();

	 
	public Espaco criar(Espaco locacao)throws Exception{
		return espacoDAO.salvar(locacao);
	}
	
	
	public Espaco buscar(Espaco locacao)throws Exception{
		return espacoDAO.buscar(locacao); 
	}
	
	
	public Espaco atualizar( Espaco novo)throws Exception{
		return espacoDAO.atualizar(novo);
	}
	
	public void deletar(Espaco locacao)throws Exception{
		 espacoDAO.deletar(locacao);
	}
	
	
	public List<Espaco> listar()throws Exception{
		return espacoDAO.listar();

	}
	
	public List<Espaco> listar(Date data)throws Exception{ 

		List<Espaco> todosEspacos = this.listar();
		List<Espaco> espacosDia = new ArrayList<Espaco>();

		for (int i = 0; i < todosEspacos.size(); i++) {
			if(todosEspacos.get(i).getData().compareTo(data)==0) {
				espacosDia.add(todosEspacos.get(i));
			}
		}	
		return espacosDia;
	}

}
