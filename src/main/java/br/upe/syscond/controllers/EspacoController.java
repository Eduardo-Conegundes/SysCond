package br.upe.syscond.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import br.upe.syscond.dao.LocacaoDAO;
import br.upe.syscond.models.Espaco;
import br.upe.syscond.models.Morador;

public class EspacoController implements InterfaceLocacaoController {
	/**
	 * @param Espaco
	 * @return Espaco
	 */
	public Espaco criar(Espaco locacao) {
		
		if(this.buscar(locacao)!=null) {
			return null;
		}
		
		try {
			Espaco salva = LocacaoDAO.getInstance().salvar(locacao);
			return salva;
		} catch (Exception e) {
			System.err.println("Erro ao Salvar locacao!");
			return null;		
		}

	}
	/**
	 * @param Espaco
	 * @return Espaco || null
	 */
	public Espaco buscar(Espaco locacao){
		List<Espaco> lista = this.listar();
		for (Espaco espaco : lista) {
			if(espaco.equals(locacao)) {
				return espaco;
			}
		}
		return null;
	}
	/**
	 * @param Espaco antigo
	 * @param Espaco novo
	 * @return Espaco || null
	 */
	public Espaco atualizar(Espaco antigo, Espaco novo){
		try {
			novo.setId(this.buscar(antigo).getId());
			Espaco locacaoAtualizada = LocacaoDAO.getInstance().atualizar(novo);
			return locacaoAtualizada;
		} catch (Exception eSalvar) {
			return null;
		}
	}
	/**
	 * @param Espaco
	 * @return boolean
	 */
	public boolean deletar(Espaco locacao){
		int id = this.buscar(locacao).getId();
		try {
			LocacaoDAO.getInstance().deletar(id);
			return true;
		} catch (Exception e) {
			System.err.println("Erro ao excluir Loca��o!");
			return false;
		}
	}
	/**
	 * @return Espaco[]
	 */
	public List<Espaco> listar(){
		try {
			List<Espaco> locacoes = LocacaoDAO.getInstance().listar();
			return locacoes;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar Loca��es)!");
			return null;
		}

	}
	/**
	 * @param Date
	 * @return Espaco[]
	 */
	public List<Espaco> listar(Date data){

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
