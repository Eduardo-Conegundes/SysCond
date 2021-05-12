package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.InterfaceVeiculo;
import br.upe.syscond.dao.VeiculoDAO;
import br.upe.syscond.models.Veiculo;

public class VeiculoController implements InterfaceVeiculoController {

	static InterfaceVeiculo veiculoDAO = VeiculoDAO.getInstance();

	
	public Veiculo criar(Veiculo veiculo) throws Exception{
			return veiculoDAO.salvar(veiculo);
	}
	
	
	public List<Veiculo> listar() throws Exception{
			return veiculoDAO.listar();
	}
	
	
	public Veiculo buscar(Veiculo veiculo) throws Exception{
			return veiculoDAO.buscar(veiculo);
	}
	
	public Veiculo atualizar(Veiculo novo) throws Exception{
			return veiculoDAO.atualizar(novo);
	}
	
	public void deletar(Veiculo veiculo) throws Exception{
			veiculoDAO.deletar(veiculo);
	}
}
