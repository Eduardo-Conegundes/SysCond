package br.upe.Controllers.Interface;

import java.util.List;
import br.upe.Models.Veiculo;

public interface InterfaceVeiculoController {
	public Veiculo criar(Veiculo veiculo);
	public List<Veiculo> listar();
	public Veiculo buscar(String placa);
	public Veiculo atualizar(int idApartamentoNovo, Veiculo veiculo);
	public void deletar(String placa);
}
