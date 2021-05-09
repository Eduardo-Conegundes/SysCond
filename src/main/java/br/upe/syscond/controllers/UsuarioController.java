package br.upe.syscond.controllers;

	/**
	*@import Importação das bibliotecas necessárias
	*/
import java.util.List;
import br.upe.syscond.dao.InterfaceUsuario;
import br.upe.syscond.dao.UsuarioDAO;
import br.upe.syscond.models.Usuario;

public class UsuarioController implements InterfaceUsuarioController{

	/**
	*@criação de variavel statica do tipo Usuario, que recebe um UsuarioDAO
	*/	
	static InterfaceUsuario userDAO = UsuarioDAO.getInstance();
	
	/**
	 * @param --> O metodo criar recebe um parametro user-com diversos atributos internalizados- do tipo Usuario para salvar no banco de dados.
	 * @return--> Caso a operação de criar seja bem sucedida, ela retona um usuario salvo no banco de dados.
	 * @throws--> se apoeração  de salva falhar, sera lançada uma Exception.
	 */
	public Usuario criar(Usuario user) throws Exception{
		try {
			return userDAO.salvar(user);
		} catch (Exception eSalvar) {
			throw eSalvar;
		}
	}
	
	/**
	 * @return--> Caso a operação de listar seja bem sucedida, ela retona uma lista com todos os usuarios salvos no banco de dados.
	 * @throws--> se apoeração de listar falhar, sera lançada uma Exception.
	 */
	public List<Usuario> listar() throws Exception{
		try {
			return userDAO.listar();
		} catch (Exception eListar) {
			throw eListar;
		}
	}
	
	/**
	 * @param --> O metodo buscar recebe um parametro user -com todos os atributos de um usuario- do tipo Usuario para realizar uma busca no banco de dados do apartamento desejado.
	 * @return--> Caso a operação  de Buscar seja bem sucedida, ela retona o Usuario deseja que esta no Banco de dados. 
	 * @throws Exception--> se apoeração de listar falhar, sera lançada uma Exception.
	 */
	public Usuario buscar(Usuario user) throws Exception{
		try {
			return userDAO.buscar(user);
		} catch (Exception eBuscar) {
			throw eBuscar;
		}
	}
	
	/**
	 * @param --> O metodo atualizar recebe um parametro novo-com um ou diversos atributos internalizados- do tipo usuario para atualizar o apartamento antigo no banco de dados.
	 * @return--> Caso a operação de atualizar seja bem sucedida, ela retona o usuario antigo com as informações atualizadas no banco de dados.
	 * @throws--> se apoeração  de salva falhar, sera lançada uma Exception.
	 */
	public Usuario atualizar(Usuario novo) throws Exception{
		try {
			return userDAO.atualizar(novo);
		} catch (Exception eBuscar) {
			throw eBuscar;
		}
	}
	
	/**
	 * @param --> O metodo deletar recebe um parametro user-com todos os atibutos atributos internalizados- do tipo usuario para exclusão do usuario no banco de dados.
	 * @return--> Caso a operação de deletar seja bem sucedida, ela retona o valor boleano TRUE.
	 * @throws--> se apoeração  de deletar falhar, sera lançada uma Exception.
	 */
	public boolean deletar(Usuario user) throws Exception{
		try {
			userDAO.deletar(user);
			return true;
		} catch (Exception eDeletar) {
			throw eDeletar;
		}
	}
}
