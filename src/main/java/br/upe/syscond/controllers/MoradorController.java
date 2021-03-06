package br.upe.syscond.controllers;

import java.util.List;
import br.upe.syscond.dao.InterfaceMorador;
import br.upe.syscond.dao.MoradorDAO;
import br.upe.syscond.models.Morador;

public class MoradorController implements InterfaceMoradorController{

	/**
	*@criação de variavel statica do tipo Morador, que recebe um MoradorDAO
	*/	
	static InterfaceMorador moradorDAO = MoradorDAO.getInstance();
	
	/**
	 * @param --> O metodo criar recebe um parametro morador-com diversos atributos internalizados- do tipo morador para salvar no banco de dados.
	 * @return--> Caso a operação de criar seja bem sucedida, ela retona um morador salvo no banco de dados.
	 */ 
	public Morador criar(Morador morador) throws Exception{
			return moradorDAO.salvar(morador);
	}
	
	/**
	 * @return--> Caso a operação de listar seja bem sucedida, ela retona uma lista com todos os morador salvos no banco de dados.
	 */
	public List<Morador> listar() throws Exception{
			return moradorDAO.listar();
	}
	
	/**
	 * @param --> O metodo buscar recebe um parametro morador -com todos os atributos de um usuario- do tipo morador para realizar uma busca no banco de dados do morador solicitado.
	 * @return--> Caso a operação  de Buscar seja bem sucedida, ela retona o morador deseja que esta no Banco de dados. 
	 */
	public Morador buscar(Morador morador) throws Exception{
			return moradorDAO.buscar(morador);

	}
	
	/**
	 * @param --> O metodo atualizar recebe um parametro morador-com um ou diversos atributos internalizados- do tipo morador para atualizar o morador antigo no banco de dados.
	 * @return--> Caso a operação de atualizar seja bem sucedida, ela retona o morador antigo com as informações atualizadas no banco de dados.
	 */
	public Morador atualizar(Morador novo) throws Exception{
			return moradorDAO.atualizar(novo);
	}
	
	/**
	 * @param --> O metodo deletar recebe um parametro morador-com todos os atibutos atributos internalizados- do tipo morador para exclusão do morador solicitado banco de dados.
	 * @return--> Caso a operação de deletar seja bem sucedida, ela retona o valor boleano TRUE.
	 */
	public void deletar(Morador morador) throws Exception{
			moradorDAO.deletar(morador);
	}

}
