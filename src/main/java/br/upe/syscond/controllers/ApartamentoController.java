package br.upe.syscond.controllers;

	/**
	*@import --> Importacao das bibliotecas necessarias
	*/
import java.util.List;
import br.upe.syscond.dao.ApartamentoDAO;
import br.upe.syscond.dao.InterfaceApartamento;
import br.upe.syscond.models.Apartamento;


public class ApartamentoController implements InterfaceApartamentoController {
	
	/**
	*@Variavel --> variavel statica global do tipo apartamento, que recebe um apartamentoDAO
	*/
	static InterfaceApartamento aptDAO = ApartamentoDAO.getInstance();
	
	/**
	 * @param --> O metodo criar recebe um parametro apartamento-com diversos atributos internalizados- do tipo apartamento para salvar no banco de dados.
	 * @return--> Caso a operação de criar seja bem sucedida, ela retona um apartamento salvo no banco de dados.
	 * @throws--> se apoeração  de criar falhar, sera lançada uma Exception.
	 */
	public Apartamento criar(Apartamento apartamento) throws Exception{
			return aptDAO.salvar(apartamento);	
	}
	
	/**
	 * @return--> Caso a operação de listar seja bem sucedida, ela retona uma lista com todos os apartamento salvos no banco de dados.
	 * @throws--> se apoeração de listar falhar, sera lançada uma Exception.
	 */
	public List<Apartamento> listar() throws Exception{
			return aptDAO.listar();
	}
	
	/**
	 * @param --> O metodo recebe um parametro bloco do tipo String.
	 * @return --> Caso a operação  de listar seja bem sucedida, ela retona uma lista dos apartamentos no Banco de dados relacionado ao bloco desejado.
	 * @throws Exception --> se apoeração de listar falhar, sera lançada uma Exception.
	 */
	public List<Apartamento> listarPorBlocos(String bloco) throws Exception {
			return aptDAO.listarPorBloco(bloco);
	}
	
	public List<Apartamento> listarBlocos() throws Exception {
            return aptDAO.listarBlocos();
    }
	
	/**
	 * @param --> O metodo buscar recebe um parametro pesquisar -com diversos atributos internalizados- do tipo apartamento para realizar uma busca no banco de dados do apartamento desejado.
	 * @return--> Caso a operação  de Buscar seja bem sucedida, ela retona o apartamento deseja que esta no Banco de dados. 
	 * @throws Exception--> se apoeração de listar falhar, sera lançada uma Exception.
	 */
	public Apartamento buscar(Apartamento pesquisar) throws Exception {
			return aptDAO.buscar(pesquisar);
	}
	
	/**
	 * @param --> O metodo atualizar recebe um parametro novo-com um ou diversos atributos internalizados- do tipo apartamento para atualizar o apartamento antigo no banco de dados.
	 * @return--> Caso a operação de atualizar seja bem sucedida, ela retona o apartamento antigo com as informações atualizadas no banco de dados.
	 * @throws--> se apoeração  de atualizar falhar, sera lançada uma Exception.
	 */
	public Apartamento atualizar(Apartamento novo) throws Exception{
			return aptDAO.atualizar(novo);
	}
	
	/**
	 * @param --> O metodo deletar recebe um parametro apartamento-com os atibutos atributos internalizados- do tipo apartamento para exclusão do apartamento no banco de dados.
	 * @return--> Caso a operação de deletar seja bem sucedida, ela retona o valor boleano TRUE.
	 * @throws--> se apoeração  de deletar falhar, sera lançada uma Exception.
	 */
	public void deletar(Apartamento apartamento) throws Exception {
			aptDAO.deletar(apartamento);
	}
	
	/**
	 * @param --> O metodo recebe um parametro numero do tipo inteiro.
	 * @return --> Caso a operação  de listar seja bem sucedida, ela retona uma lista dos apartamentos no Banco de dados relacionado ao numero desejado.
	 * @throws Exception --> se apoeração de listar falhar, sera lançada uma Exception.
	 */
	public List<Apartamento> listarPorNumeros(Integer numero) throws Exception {
			return aptDAO.listarPorNumero(numero);
	}
	
	/**
	 * @return--> Caso a operação de listar seja bem sucedida, ela retona uma lista com todos os numero de apartamento salvos no banco de dados.
	 * @throws--> se apoeração de listar falhar, sera lançada uma Exception.
	 */	
	public List<Apartamento> listarNumeros() throws Exception {
			return aptDAO.listarNumeros();
	}

}
