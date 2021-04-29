package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.PessoaDAO;
import br.upe.syscond.models.Pessoa;

public class PessoaController implements InterfacePessoaController {

	public Pessoa criar(Pessoa pessoa){
		List<Pessoa> pessoas = this.listar();

		if(pessoas.contains(pessoa)) {
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

	public Pessoa buscar(String cpf){
		try {
			Pessoa b = PessoaDAO.getInstance().buscar(cpf);
			return b;
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar pessoa!");
			return null;
		}
	}

	public Pessoa atualizar(Pessoa pessoa){

		Pessoa b = null;

		try {
			b = this.buscar(pessoa.getCpf());
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar cpf!");
			return null;
		}

		if (b == null) {
			return null;
		}		

		try {
			Pessoa a = PessoaDAO.getInstance().atualizar(pessoa);
			return a;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao atualizar pessoa!");
			return null;
		}
	}

	public boolean deletar(Pessoa pessoa){
		String cpf = pessoa.getCpf();
		try {
			PessoaDAO.getInstance().deletar(cpf);
			return true;
		} catch (Exception e) {
			System.err.println("Erro ao excluir pessoa!");
			return true;
		}
	}
}
