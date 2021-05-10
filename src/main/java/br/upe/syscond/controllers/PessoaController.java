package br.upe.syscond.controllers;

import java.util.List;
import br.upe.syscond.dao.InterfacePessoa;
import br.upe.syscond.dao.PessoaDAO;
import br.upe.syscond.models.Pessoa;

public class PessoaController implements InterfacePessoaController {
	/**
	*@criacao de variavel statica do tipo Usuario, que recebe um PessoaDAO
	*/	
	static InterfacePessoa pessoaDAO = PessoaDAO.getInstance();

	/**
	 * @param --> O metodo criar recebe um parametro pessoa-com todos atributos internalizados- do tipo pessoa para salvar no banco de dados.
	 * @return--> Caso a operacao de criar seja bem sucedida, ela retona um pessoa salvo no banco de dados.
	 * @throws--> se operacaoo  de salva falhar, sera lancada uma Exception.
	 */ 
	public Pessoa criar(Pessoa pessoa)throws Exception{	
		return pessoaDAO.salvar(pessoa);
	}
	
	/**
	 * @return--> Caso a operacao de listar seja bem sucedida, ela retona uma lista com todas as pessoa salvos no banco de dados.
	 * @throws--> se operacao de listar falhar, sera lancada uma Exception.
	 */
	public List<Pessoa> listar()throws Exception{
		return pessoaDAO.listar();

	}
	
	/**
	 * @param --> O metodo buscar recebe um parametro pessoa -com todos os atributos de uma pessoa- do tipo pessoa para realizar uma busca no banco de dados da pessoa solicitada.
	 * @return--> Caso aoperacao  de Buscar seja bem sucedida, ela retona a pessoa deseja que esta no Banco de dados. 
	 * @throws Exception--> se operacao de listar falhar, sera lancada uma Exception.
	 */
	public Pessoa buscar(Pessoa pessoa)throws Exception{
	return pessoaDAO.buscar(pessoa);
	}
	
	/**
	 * @param --> O metodo atualizar recebe um parametro pessoa-com um ou diversos atributos internalizados- do tipo pessoa para atualizar a pessoa antiga no banco de dados.
	 * @return--> Caso a operacao de atualizar seja bem sucedida, ela retona a pessoa antiga com as informacoes atualizadas no banco de dados.
	 * @throws--> se operacao  de salva falhar, sera lancada uma Exception.
	 */
	public Pessoa atualizar(Pessoa pessoa)throws Exception{
		return pessoaDAO.atualizar(pessoa);

	}

	/**
	 * @param --> O metodo deletar recebe um parametro pessoa-com todos os atibutos atributos internalizados- do tipo pessoa para exclusao da pessoa solicitado banco de dados.
	 * @return--> Caso a operacao de deletar seja bem sucedida, ela retona o valor boleano TRUE.
	 * @throws--> se operacao  de deletar falhar, sera lancada uma Exception.
	 */
	public boolean deletar(Pessoa pessoa)throws Exception{
		pessoaDAO.deletar(pessoa);
		return true;
	}
}
