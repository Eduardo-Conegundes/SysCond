package Controllers;

import java.util.List;

import DAO.PessoaDAO;
import Models.Pessoa;

public class PessoaController {
	public Pessoa criar(String nome, String cpf, String telefone, String email){
		Pessoa pessoa1 = new Pessoa(nome, cpf, telefone, email);

		try {
			Pessoa p = PessoaDAO.getInstance().salvar(pessoa1);
			System.out.println("Salvo com sucesso: " + p);
			return p;
		} catch (Exception eSalvar) {
			System.out.println("Erro ao salvar pessoa!");
			return null;
		}
	}

	public List listar(){
		try {
			List<Pessoa> l = PessoaDAO.getInstance().listar();
			System.out.println("Listar com sucesso: " + l);
			return l;
		} catch (Exception eListar) {
			System.out.println("Erro ao listar pessoa(s)!");
			return null;
		}

	}

	public Pessoa buscar(String cpf){
		try {
			Pessoa b = PessoaDAO.getInstance().buscar(cpf);
			System.out.println("Achado com sucesso: " + b);
			return b;
		} catch (Exception eBuscar) {
			System.out.println("Erro ao buscar pessoa!");
			return null;
		}
	}

	public Pessoa atualizar(String nome, String cpf, String telefone, String email){
		Pessoa pessoa2 = new Pessoa(nome, cpf, telefone, email);
		Pessoa b = null;
		try {
			b = PessoaDAO.getInstance().buscar(cpf);
		} catch (Exception eBuscar) {
			System.out.println("Erro ao buscar cpf!");
			return null;
		}
		
		if (b==null) {
			System.out.println("Pessoa não encontrada pelo CPF");
			return null;
		}		
		
		try {
			Pessoa a = PessoaDAO.getInstance().atualizar(pessoa2);
			System.out.println("Atualizado com sucesso: " + a);
			return a;
		} catch (Exception eSalvar) {
			System.out.println("Erro ao atualizar pessoa!");
			return null;
		}
	}

	public void deletarPorId(String cpf){
		try {
			PessoaDAO.getInstance().deletarPorId(cpf);
			System.out.println("Excluído com sucesso");
		} catch (Exception e) {
			System.out.println("Erro ao excluir pessoa!");
		}
	}
}
