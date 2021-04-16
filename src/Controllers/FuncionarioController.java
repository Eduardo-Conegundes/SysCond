package Controllers;

import java.util.List;

import DAO.FuncionarioDAO;
import DAO.PessoaDAO;
import Models.Funcionario;
import Models.Pessoa;

public class FuncionarioController {
	
	public Funcionario criar(String cpf, String interno_externo, String cargo, float salario){
		Pessoa p = null;
		try {
			p = PessoaDAO.getInstance().buscar(cpf);
		} catch (Exception e) {
			System.out.println("Erro ao encontrar pessoa");
			return null;
		}
		
		if (p==null) {
			System.out.println("Erro ao encontrar pessoa");
		}else {
			Funcionario Funcionario = new Funcionario(p, interno_externo, cargo, salario);
			try {
				Funcionario cadastrado = FuncionarioDAO.getInstance().salvar(Funcionario);
				System.out.println("Salvo " + cadastrado.getPessoa().getNome() + " com sucesso");
				return cadastrado;
			} catch (Exception eSalvar) {
				System.out.println("Erro ao salvar Funcionario!");
				return null;
			}
		}
		return null;
	}

	public List<Funcionario> listar(){
		try {
			List<Funcionario> l = FuncionarioDAO.getInstance().listar();
			System.out.println("Listar com sucesso: " + l.size());
			return l;
		} catch (Exception eListar) {
			System.out.println("Erro ao listar Funcionario(s)!");
			return null;
		}
	}

	public Funcionario buscar(String cpf) {
		try {
			Funcionario b = FuncionarioDAO.getInstance().buscar(cpf);
			System.out.println("Achado com sucesso: " + b.getPessoa().getNome());
			return b;
		} catch (Exception eBuscar) {
			System.out.println("Erro ao buscar Funcionario!");
			return null;
		}
	}

	public Funcionario atualizar(String cpf, String interno_externo, String cargo, float salario){
		
		Funcionario b = null;
		
		try {
			b = FuncionarioDAO.getInstance().buscar(cpf);
		} catch (Exception eBuscar) {
			System.out.println("Erro ao buscar cpf!");
			return null;
		}

		if (b==null) {
			System.out.println("Funcionario não encontrada pelo CPF");
			return null;
		}else {
			b.setCargo(cargo);
			b.setInterno_externo(interno_externo);
			b.setSalario(salario);
			try {
				Funcionario atualizado = FuncionarioDAO.getInstance().atualizar(b);
				System.out.println("Atualizado com sucesso: " + atualizado.getPessoa().getNome());
				return atualizado;
			} catch (Exception eSalvar) {
				System.out.println("Erro ao atualizar Funcionario!");
				return null;
			}
		}
	}

	public void deletar(String cpf){
		try {
			FuncionarioDAO.getInstance().deletar(cpf);
			System.out.println("Excluído com sucesso");
		} catch (Exception e) {
			System.out.println("Erro ao excluir Funcionario!");
		}
	}
}
