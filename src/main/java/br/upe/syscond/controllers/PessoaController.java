package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.PessoaDAO;
import br.upe.syscond.models.Pessoa;

public class PessoaController implements InterfacePessoaController {

	public Pessoa criar(Pessoa pessoa){

		if(this.buscar(pessoa)!=null) {
			return null;
		}
		try {
			Pessoa p = PessoaDAO.getInstance().salvar(pessoa);
			return p;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao salvar pessoa!");
			return null;
		}
	}

	public List<Pessoa> listar(){
		try {
			List<Pessoa> l = PessoaDAO.getInstance().listar();
			return l;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar pessoa(s)!");
			return null;
		}

	}

	public Pessoa buscar(Pessoa pessoa){
		List<Pessoa> lista = this.listar();
		for (Pessoa pessoa2 : lista) {
			if(pessoa2.equals(pessoa)) {
				return pessoa2;
			}
		}
		return null;
	}

	public Pessoa atualizar(Pessoa pessoa){
		try {
			return PessoaDAO.getInstance().atualizar(pessoa);
		} catch (Exception eSalvar) {
			System.err.println("Erro ao atualizar pessoa!");
			return null;
		}
	}

	public boolean deletar(Pessoa pessoa){
		int id = this.buscar(pessoa).getId();
		try {
			PessoaDAO.getInstance().deletar(id);
			return true;
		} catch (Exception e) {
			System.err.println("Erro ao excluir pessoa!");
			return true;
		}
	}
}
