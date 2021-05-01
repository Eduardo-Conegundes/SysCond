package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.VeiculoDAO;
import br.upe.syscond.models.Veiculo;
 
public class VeiculoController implements InterfaceVeiculoController{
	
	public Veiculo criar(Veiculo veiculo){
		if (this.buscar(veiculo) != null) {
			return null;
		}
		try {
			return VeiculoDAO.getInstance().salvar(veiculo);
		} catch (Exception eSalvar) {
			System.err.println("Erro ao salvar veiculo!");
			return null;
		}
	}

	public List<Veiculo> listar(){
		try {
			return VeiculoDAO.getInstance().listar();
		} catch (Exception eListar) {
			return null;
		}

	}

	public Veiculo buscar(Veiculo veiculo){
		List<Veiculo> lista = this.listar();
		for (Veiculo veiculo2 : lista) {
			if(veiculo2.equals(veiculo)) {
				return veiculo2;
			}
		}
		return null;
	}

	public Veiculo atualizar(Veiculo antigo, Veiculo novo){
		try {
			novo.setId(this.buscar(antigo).getId());
			return VeiculoDAO.getInstance().atualizar(novo);
		} catch (Exception eSalvar) {
			System.err.println("Erro ao atualizar veiculo!");
			return null;
		}
	}

	public boolean deletar(Veiculo veiculo){
		try {
			int id = this.buscar(veiculo).getId();
			VeiculoDAO.getInstance().deletar(id);
			return true;
		} catch (Exception e) {
			System.err.println("Erro ao excluir Veiculo!");
			return false;
		}
	}
}
