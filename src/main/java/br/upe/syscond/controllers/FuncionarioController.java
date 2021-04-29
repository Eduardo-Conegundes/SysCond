package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.FuncionarioDAO;
import br.upe.syscond.models.Funcionario;
import br.upe.syscond.models.Pessoa;

public class FuncionarioController implements InterfaceFuncionarioController {
	public Funcionario criar(Funcionario funcionario){

		Pessoa p = null;
		PessoaController pessoa = new PessoaController();

		try {
			p = pessoa.buscar(funcionario.getPessoa().getCpf());
		} catch (Exception e) {
			System.err.println("Erro ao encontrar pessoa");
			return null;
		}

		if (p == null) {

			pessoa.criar(funcionario.getPessoa());

		}
		
		try {
			Funcionario cadastrado = FuncionarioDAO.getInstance().salvar(funcionario);
			return cadastrado;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao salvar Funcionario!");
			return null;
		}

	}

	public List<Funcionario> listar(){
		try {
			List<Funcionario> l = FuncionarioDAO.getInstance().listar();
			return l;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar Funcionario(s)!");
			return null;
		}
	}

	public Funcionario buscar(String cpf) {
		try {
			Funcionario b = FuncionarioDAO.getInstance().buscar(cpf);
			return b;
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar Funcionario!");
			return null;
		}
	}

	public Funcionario atualizar(Funcionario funcionario){

		Funcionario b = null;

		try {
			b = this.buscar(funcionario.getPessoa().getCpf());
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar cpf!");
			return null;
		}

		if (b == null) {
			return null;
		}

			try {
				Funcionario atualizado = FuncionarioDAO.getInstance().atualizar(funcionario);
				return atualizado;
			} catch (Exception eSalvar) {
				System.err.println("Erro ao atualizar Funcionario!");
				return null;
			}
		
	}

	public boolean deletar(Funcionario funcionario){
		String cpf = funcionario.getPessoa().getCpf();
		try {
			FuncionarioDAO.getInstance().deletar(cpf);
			return true;
		} catch (Exception e) {
			System.err.println("Erro ao excluir Funcionario!");
			return true;
		}
	}
}
