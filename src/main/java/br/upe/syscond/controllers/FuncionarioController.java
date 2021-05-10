package br.upe.syscond.controllers;

import java.util.List;
import br.upe.syscond.dao.FuncionarioDAO;
import br.upe.syscond.dao.InterfaceFuncionario;
import br.upe.syscond.models.Funcionario;

public class FuncionarioController implements InterfaceFuncionarioController {
	
	/**
	*@criação de variavel statica do tipo Usuario, que recebe um UsuarioDAO
	*/	
	static InterfaceFuncionario funcionarioDAO = FuncionarioDAO.getInstance();
	
	/**
	 * @param --> O metodo criar recebe um parametro funcionario-com diversos atributos internalizados- do tipo funcionario para salvar no banco de dados.
	 * @return--> Caso a operação de criar seja bem sucedida, ela retona um funcionario salvo no banco de dados.
	 */ 
	public Funcionario criar(Funcionario funcionario) throws Exception{ 
			return funcionarioDAO.salvar(funcionario);
	}
	
	/**
	 * @return--> Caso a operação de listar seja bem sucedida, ela retona uma lista com todos os funcionario salvos no banco de dados.
	 */
	public List<Funcionario> listar() throws Exception{
			return funcionarioDAO.listar();
	}
	
	/**
	 * @param --> O metodo buscar recebe um parametro funcionario -com todos os atributos de um usuario- do tipo funcionario para realizar uma busca no banco de dados do funcionario solicitado.
	 * @return--> Caso a operação  de Buscar seja bem sucedida, ela retona o funcionario deseja que esta no Banco de dados. 
	 */
	public Funcionario buscar(Funcionario funcionario) throws Exception {
			return funcionarioDAO.buscar(funcionario);
	}
	
	/**
	 * @param --> O metodo atualizar recebe um parametro funcionario-com um ou diversos atributos internalizados- do tipo funcionario para atualizar o funcionario antigo no banco de dados.
	 * @return--> Caso a operação de atualizar seja bem sucedida, ela retona o funcionario antigo com as informações atualizadas no banco de dados.
	 */
	public Funcionario atualizar(Funcionario funcionario) throws Exception{
			return funcionarioDAO.atualizar(funcionario);	
	}
	
	/**
	 * @param --> O metodo deletar recebe um parametro funcionario-com todos os atibutos atributos internalizados- do tipo funcionario para exclusão do funcionariono solicitado banco de dados.
	 * @return--> Caso a operação de deletar seja bem sucedida, ela retona o valor boleano TRUE.
	 */
	public void deletar(Funcionario funcionario) throws Exception{
			funcionarioDAO.deletar(funcionario);
	}
}
