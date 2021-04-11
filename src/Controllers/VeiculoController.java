package Controllers;

import java.util.List;

import DAO.ApartamentoDAO;
import DAO.VeiculoDAO;
import Models.Apartamento;
import Models.Veiculo;

public class VeiculoController {
	public Veiculo criar(String placa, int id){
		Apartamento ap = null;
		Veiculo Veiculo1 = null;
		try {
			ap = ApartamentoDAO.getInstance().buscar(id);
			Veiculo1 = new Veiculo(placa, ap);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao buscar apartamento relacionado ao veículo!");
		}
		
		try {
			Veiculo p = VeiculoDAO.getInstance().salvar(Veiculo1);
			System.out.println("Veiculo de placa:" + p.getPlaca() + "salvo com sucesso!");
			return p;
		} catch (Exception eSalvar) {
			System.out.println("Erro ao salvar veiculo!");
			return null;
		}
	}

	public List<Veiculo> listar(){
		try {
			List<Veiculo> l = VeiculoDAO.getInstance().listar();
			System.out.println("Listar com sucesso: " + l);
			return l;
		} catch (Exception eListar) {
			System.out.println("Erro ao listar Veiculo(s)!");
			return null;
		}

	}

	public Veiculo buscar(String placa){
		try {
			Veiculo b = VeiculoDAO.getInstance().buscar(placa);
			System.out.println("Achado com sucesso!");
			return b;
		} catch (Exception eBuscar) {
			System.out.println("Erro ao buscar Veiculo!");
			return null;
		}
	}

	//atualizar apartamento e não a placa!
	public Veiculo atualizar(String placa, int idApartamentoNovo){
		Apartamento ap = null;
		Veiculo Veiculo2 = null;
		Veiculo b = null;

		try {
			ap = ApartamentoDAO.getInstance().buscar(idApartamentoNovo);
			Veiculo2 = new Veiculo(placa, ap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			b = VeiculoDAO.getInstance().buscar(placa);
		} catch (Exception eBuscar) {
			System.out.println("Erro ao buscar veículo!");
			return null;
		}
		
		if (b==null) {
			System.out.println("Veiculo não encontrado.");
			return null;
		}		
		
		try {
			Veiculo a = VeiculoDAO.getInstance().atualizar(Veiculo2);
			System.out.println("Veiculo atualizado com sucesso.");
			return a;
		} catch (Exception eSalvar) {
			System.out.println("Erro ao atualizar veiculo!");
			return null;
		}
	}

	public void deletarPorId(String placa){
		try {
			VeiculoDAO.getInstance().deletar(placa);
			System.out.println("Excluído com sucesso");
		} catch (Exception e) {
			System.out.println("Erro ao excluir Veiculo!");
		}
	}
}
