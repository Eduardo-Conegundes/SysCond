package Controllers;

import java.util.List;

import Controllers.Interface.InterfaceFuncionarioController;
import DAO.FuncionarioDAO;
import Models.Funcionario;
import Models.Pessoa;

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

			System.out.println("Erro ao encontrar pessoa");
			pessoa.criar(funcionario.getPessoa());

		}
		
		try {
			Funcionario cadastrado = FuncionarioDAO.getInstance().salvar(funcionario);
			System.out.println("Salvo " + cadastrado.getPessoa().getNome() + " com sucesso");
			return cadastrado;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao salvar Funcionario!");
			return null;
		}

	}

	public List<Funcionario> listar(){
		try {
			List<Funcionario> l = FuncionarioDAO.getInstance().listar();
			System.out.println("Listar com sucesso: " + l.size());
			return l;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar Funcionario(s)!");
			return null;
		}
	}

	public Funcionario buscar(String cpf) {
		try {
			Funcionario b = FuncionarioDAO.getInstance().buscar(cpf);
			System.out.println("Achado com sucesso: " + b.getPessoa().getNome());
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
			System.out.println("Funcionario não encontrada pelo CPF");
			return null;
		}

			try {
				Funcionario atualizado = FuncionarioDAO.getInstance().atualizar(funcionario);
				System.out.println("Atualizado com sucesso: " + atualizado.getPessoa().getNome());
				return atualizado;
			} catch (Exception eSalvar) {
				System.err.println("Erro ao atualizar Funcionario!");
				return null;
			}
		
	}

	public void deletar(String cpf){
		try {
			FuncionarioDAO.getInstance().deletar(cpf);
			System.out.println("Excluído com sucesso");
		} catch (Exception e) {
			System.err.println("Erro ao excluir Funcionario!");
		}
	}
}
