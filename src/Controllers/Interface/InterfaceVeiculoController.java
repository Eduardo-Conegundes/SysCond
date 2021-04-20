package Controllers.Interface;

import java.util.List;

import Models.Veiculo;

public interface InterfaceVeiculoController {
	public Veiculo criar(String placa, int id);
	public List<Veiculo> listar();
	public Veiculo buscar(String placa);
	public Veiculo atualizar(String placa, int idApartamentoNovo);
	public void deletarPorId(String placa);
}
