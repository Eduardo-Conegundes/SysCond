package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.VeiculoDAO;
import br.upe.syscond.models.Apartamento;
import br.upe.syscond.models.Veiculo;
 
public class VeiculoController implements InterfaceVeiculoController{
	public Veiculo criar(Veiculo veiculo){
		Apartamento apartamentoCadastrado = null;
		Veiculo CriarVeiculo = null;
		
		ApartamentoController aptCont = new ApartamentoController();
		try {
			apartamentoCadastrado = aptCont.buscar(veiculo.getApartamento());
		} catch (Exception e) {
			System.err.println("Erro ao buscar apartamento relacionado ao veículo!");
		}
		
		if (apartamentoCadastrado == null) {
			return null;
		}
		
		try {
			CriarVeiculo = VeiculoDAO.getInstance().salvar(veiculo);
			return CriarVeiculo;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao salvar veiculo!");
			return null;
		}
	}

	public List<Veiculo> listar(){
		try {
			List<Veiculo> VeiculosListados = VeiculoDAO.getInstance().listar();
			return VeiculosListados;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar Veiculo(s)!");
			return null;
		}

	}

	public Veiculo buscar(String placa){
		try {
			Veiculo VeiculoBuscado = VeiculoDAO.getInstance().buscar(placa);
			return VeiculoBuscado;
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar veiculo!");
			return null;
		}
	}

	public Veiculo atualizar(Apartamento ApartamentoNovo, Veiculo veiculo){
		Apartamento apartamentoNovoCadastrado = null;
		ApartamentoController aptCont = new ApartamentoController();
		Veiculo veiculoCadastrado = null;

		try {
			apartamentoNovoCadastrado = aptCont.buscar(ApartamentoNovo);
			veiculoCadastrado = this.buscar(veiculo.getPlaca());
		} catch (Exception e) {
		}
		
		if (apartamentoNovoCadastrado == null || veiculoCadastrado == null) {
			return null;
		}
		
		try {
			veiculoCadastrado.setApartamento(apartamentoNovoCadastrado);
			veiculoCadastrado = VeiculoDAO.getInstance().atualizar(veiculoCadastrado);
			return veiculoCadastrado;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao atualizar veiculo!");
			return null;
		}
	}

	public void deletar(String placa){
		try {
			VeiculoDAO.getInstance().deletar(placa);
		} catch (Exception e) {
			System.err.println("Erro ao excluir Veiculo!");
		}
	}
}
