package br.upe.Controllers;

import java.util.List;

import br.upe.Controllers.Interface.InterfaceVeiculoController;
import br.upe.DAO.VeiculoDAO;
import br.upe.Models.Apartamento;
import br.upe.Models.Veiculo;
 
public class VeiculoController implements InterfaceVeiculoController{
	public Veiculo criar(Veiculo veiculo){
		Apartamento apartamentoCadastrado = null;
		Veiculo CriarVeiculo = null;
		
		ApartamentoController aptCont = new ApartamentoController();
		try {
			apartamentoCadastrado = aptCont.buscar(veiculo.getApartamento().getId());
		} catch (Exception e) {
			System.err.println("Erro ao buscar apartamento relacionado ao veículo!");
		}
		
		if (apartamentoCadastrado == null) {
			System.out.println("Apartamento não cadastrado.");
			return null;
		}
		
		try {
			CriarVeiculo = VeiculoDAO.getInstance().salvar(veiculo);
			System.out.println("Veiculo de placa:" + CriarVeiculo.getPlaca() + "salvo com sucesso!");
			return CriarVeiculo;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao salvar veiculo!");
			return null;
		}
	}

	public List<Veiculo> listar(){
		try {
			List<Veiculo> VeiculosListados = VeiculoDAO.getInstance().listar();
			System.out.println("Listar com sucesso: " + VeiculosListados.size());
			return VeiculosListados;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar Veiculo(s)!");
			return null;
		}

	}

	public Veiculo buscar(String placa){
		try {
			Veiculo VeiculoBuscado = VeiculoDAO.getInstance().buscar(placa);
			System.out.println("Achado com sucesso!");
			return VeiculoBuscado;
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar veiculo!");
			return null;
		}
	}

	public Veiculo atualizar(int idApartamentoNovo, Veiculo veiculo){
		Apartamento apartamentoNovoCadastrado = null;
		ApartamentoController aptCont = new ApartamentoController();
		Veiculo veiculoCadastrado = null;

		try {
			apartamentoNovoCadastrado = aptCont.buscar(idApartamentoNovo);
			veiculoCadastrado = this.buscar(veiculo.getPlaca());
		} catch (Exception e) {
		}
		
		if (apartamentoNovoCadastrado == null || veiculoCadastrado == null) {
			System.out.println("Apartamento e/ou veículo não cadastrado.");
			return null;
		}
		
		try {
			veiculoCadastrado.setApartamento(apartamentoNovoCadastrado);
			veiculoCadastrado = VeiculoDAO.getInstance().atualizar(veiculoCadastrado);
			System.out.println("Veiculo atualizado com sucesso.");
			return veiculoCadastrado;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao atualizar veiculo!");
			return null;
		}
	}

	public void deletar(String placa){
		try {
			VeiculoDAO.getInstance().deletar(placa);
			System.out.println("Excluído com sucesso");
		} catch (Exception e) {
			System.err.println("Erro ao excluir Veiculo!");
		}
	}
}
