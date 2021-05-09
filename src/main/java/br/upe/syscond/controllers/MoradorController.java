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
	 * @throws--> se apoeração  de salva falhar, sera lançada uma Exception.
	 */ 
	public Morador criar(Morador morador) throws Exception{

		try {
			return moradorDAO.salvar(morador);
		} catch (Exception eCriar) {
			throw eCriar;
		}
	}
	
	/**
	 * @return--> Caso a operação de listar seja bem sucedida, ela retona uma lista com todos os morador salvos no banco de dados.
	 * @throws--> se apoeração de listar falhar, sera lançada uma Exception.
	 */
	public List<Morador> listar() throws Exception{
		try {
			return moradorDAO.listar();
		} catch (Exception eListar) {
			throw eListar;
		}
	}
	
	/**
	 * @param --> O metodo buscar recebe um parametro morador -com todos os atributos de um usuario- do tipo morador para realizar uma busca no banco de dados do morador solicitado.
	 * @return--> Caso a operação  de Buscar seja bem sucedida, ela retona o morador deseja que esta no Banco de dados. 
	 * @throws Exception--> se apoeração de listar falhar, sera lançada uma Exception.
	 */
	public Morador buscar(Morador morador) throws Exception{
		try {
			return moradorDAO.buscar(morador);
		} catch (Exception eBuscar) {
			throw eBuscar;
		}
	}
	
	/**
	 * @param --> O metodo atualizar recebe um parametro morador-com um ou diversos atributos internalizados- do tipo morador para atualizar o morador antigo no banco de dados.
	 * @return--> Caso a operação de atualizar seja bem sucedida, ela retona o morador antigo com as informações atualizadas no banco de dados.
	 * @throws--> se apoeração  de salva falhar, sera lançada uma Exception.
	 */
	public Morador atualizar(Morador novo) throws Exception{
		try {
			return moradorDAO.atualizar(novo);
		} catch (Exception eAtualizar) {
			throw eAtualizar;
		}
	}
	
	/**
	 * @param --> O metodo deletar recebe um parametro morador-com todos os atibutos atributos internalizados- do tipo morador para exclusão do morador solicitado banco de dados.
	 * @return--> Caso a operação de deletar seja bem sucedida, ela retona o valor boleano TRUE.
	 * @throws--> se apoeração  de deletar falhar, sera lançada uma Exception.
	 */
	public void deletar(Morador morador) throws Exception{
		try {
			moradorDAO.deletar(morador);
		} catch (Exception eDeletar) {
			throw eDeletar;
		}
	}

}
