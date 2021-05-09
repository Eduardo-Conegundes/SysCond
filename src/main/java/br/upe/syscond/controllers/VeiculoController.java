package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.InterfaceVeiculo;
import br.upe.syscond.dao.VeiculoDAO;
import br.upe.syscond.models.Veiculo;

public class VeiculoController implements InterfaceVeiculoController {

	static InterfaceVeiculo veiculoDAO = VeiculoDAO.getInstance();

	/**
	 * @param Veiculo
	 * @return Veiculo || null
	 * @throws Exception 
	 */
	public Veiculo criar(Veiculo veiculo) throws Exception{
		try {
			return veiculoDAO.salvar(veiculo);
		} catch (Exception eSalvar) {
			throw eSalvar;
		}
	}
	/**
	 * @return Veiculo[] || null
	 * @throws Exception 
	 */
	public List<Veiculo> listar() throws Exception{
		try {
			return veiculoDAO.listar();
		} catch (Exception eListar) {
			throw eListar;
		}

	}
	/**
	 * @param Veiculo
	 * @return Veiculo || null
	 * @throws Exception 
	 */
	public Veiculo buscar(Veiculo veiculo) throws Exception{
		try {
			return veiculoDAO.buscar(veiculo);
		} catch (Exception eBuscar) {
			throw eBuscar;
		}
	}
	/**
	 * @param Veiculo novo
	 * @return Veiculo || null
	 * @throws Exception 
	 */
	public Veiculo atualizar(Veiculo novo) throws Exception{
		try {
			return veiculoDAO.atualizar(novo);
		} catch (Exception eAtualizar) {
			throw eAtualizar;
		}
	}
	/**
	 * @param Veiculo
	 * @return boolean
	 * @throws Exception 
	 */
	public void deletar(Veiculo veiculo) throws Exception{
		try {
			veiculoDAO.deletar(veiculo);
		} catch (Exception eDeletar) {
			throw eDeletar;
		}
	}
}
