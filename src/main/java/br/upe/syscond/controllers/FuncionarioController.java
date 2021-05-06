package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.FuncionarioDAO;
import br.upe.syscond.models.Funcionario;
import br.upe.syscond.models.Pessoa;

public class FuncionarioController implements InterfaceFuncionarioController {

	public Funcionario criar(Funcionario funcionario){
		if (this.buscar(funcionario) != null) {
			return null;
		}	
		try {	 
			return FuncionarioDAO.getInstance().salvar(funcionario);
		} catch (Exception eSalvar) {
			System.err.println("Erro no sistema ao salvar Funcionario!");
			return null;
		}

	}

	public List<Funcionario> listar(){
		try {
			List<Funcionario> lista = FuncionarioDAO.getInstance().listar();
			return lista;
		} catch (Exception eListar) {
			System.err.println("Erro no sistema ao listar Funcionario(s)!");
			return null;
		}
	}

	public Funcionario buscar(Funcionario buscar) {
		List<Funcionario> lista = this.listar();
		
		for (Funcionario funcionario : lista) {
			if(funcionario.equals(buscar)) {
				return funcionario;				
			}
		}
		
		return null;
	}

	public Funcionario atualizar(Funcionario antigo, Funcionario novo){
		if(this.buscar(antigo)!= null) {
			try {
				novo.setId(antigo.getId());
				Funcionario atualizado = FuncionarioDAO.getInstance().atualizar(novo);
				return atualizado;
			} catch (Exception eSalvar) {
				System.err.println("Erro ao atualizar Funcionario!");
				return null;
			}
		}
		return null;
	}

	public boolean deletar(Funcionario funcionario){
		try {
			int id = this.buscar(funcionario).getId();
			FuncionarioDAO.getInstance().deletar(id);
			return true;
		} catch (Exception e) {
			System.err.println("Erro ao excluir Funcionario!");
			return false;
		}
	}
}
