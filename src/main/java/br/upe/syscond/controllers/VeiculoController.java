package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.InterfaceVeiculo;
import br.upe.syscond.dao.VeiculoDAO;
import br.upe.syscond.models.Veiculo;

public class VeiculoController implements InterfaceVeiculoController {

	static InterfaceVeiculo veiculoDAO = VeiculoDAO.getInstance();

	/**
	 * @param --> O metodo criar recebe um parametro veiculo-com todos atributos internalizados- do tipo veiculo para salvar no banco de dados.
	 * @return--> Caso a operacao de criar seja bem sucedida, ela retona um veiculo salvo no banco de dados.
	 * @throws--> se operacaoo  de salva falhar, sera lancada uma Exception.
	 */ 
	public Veiculo criar(Veiculo veiculo) throws Exception{
			return veiculoDAO.salvar(veiculo);
	}
	
	/**
	 * @return--> Caso a operacao de listar seja bem sucedida, ela retona uma lista com todas os veiculo salvos no banco de dados.
	 * @throws--> se operacao de listar falhar, sera lancada uma Exception.
	 */
	public List<Veiculo> listar() throws Exception{
			return veiculoDAO.listar();
	}
	
	/**
	 * @param --> O metodo buscar recebe um parametro veiculo -com todos os atributos de uma pessoa- do tipo veiculo para realizar uma busca no banco de dados do veiculo solicitada.
	 * @return--> Caso a operacao  de Buscar seja bem sucedida, ela retona o veiculo deseja que esta no Banco de dados. 
	 * @throws Exception--> se operacao de listar falhar, sera lancada uma Exception.
	 */
	public Veiculo buscar(Veiculo veiculo) throws Exception{
			return veiculoDAO.buscar(veiculo);
	}
	
	/**
	 * @param --> O metodo atualizar recebe um parametro novo-com um ou diversos atributos internalizados- do tipo veiculo para atualizar o veiculo já cadastrado no banco de dados.
	 * @return--> Caso a operacao de atualizar seja bem sucedida, ela retona o veiculo com as informacoes atualizadas no banco de dados.
	 * @throws--> se operacao  de salva falhar, sera lancada uma Exception.
	 */
	public Veiculo atualizar(Veiculo novo) throws Exception{
			return veiculoDAO.atualizar(novo);
	}
	/**
	 * @param --> O metodo deletar recebe um parametro veiculo-com todos os atibutos atributos internalizados- do tipo veiculo para exclusao do veiculo solicitado banco de dados.
	 * @return--> Caso a operacao de deletar seja bem sucedida, ela retona o valor boleano TRUE.
	 * @throws--> se operacao  de deletar falhar, sera lancada uma Exception.
	 */
	public void deletar(Veiculo veiculo) throws Exception{
			veiculoDAO.deletar(veiculo);
	}
}
