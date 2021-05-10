package br.upe.syscond.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import br.upe.syscond.dao.InterfaceLocacao;
import br.upe.syscond.dao.LocacaoDAO;
import br.upe.syscond.models.Espaco;

public class EspacoController implements InterfaceLocacaoController {
	
	/**
	*@criacao de variavel statica do tipo Usuario, que recebe um UsuarioDAO
	*/	
	static InterfaceLocacao espacoDAO = LocacaoDAO.getInstance();

	/**
	 * @param --> O metodo criar recebe um parametro locacao-com todos atributos internalizados- do tipo Espaco para salvar no banco de dados.
	 * @return--> Caso a operacao de criar seja bem sucedida, ela retona uma locacao salvo no banco de dados.
	 * @throws--> se operacaoo  de salva falhar, sera lancada uma Exception.
	 */ 
	public Espaco criar(Espaco locacao)throws Exception{
		return espacoDAO.salvar(locacao);
	}
	
	/**
	 * @param --> O metodo buscar recebe um parametro locacao -com todos os atributos de uma locacao- do tipo Espaco para realizar uma busca no banco de dados da locacao solicitada.
	 * @return--> Caso a operacao  de Buscar seja bem sucedida, ela retona a locacao deseja que esta no Banco de dados. 
	 * @throws Exception--> se operacao de listar falhar, sera lancada uma Exception.
	 */
	public Espaco buscar(Espaco locacao)throws Exception{
		return espacoDAO.buscar(locacao); 
	}
	
	/**
	 * @param --> O metodo atualizar recebe dois parametros: antigo e novo-com um ou diversos atributos internalizados- do tipo Espaco para atualizar a locacao antiga no banco de dados.
	 * @return--> Caso a operacao de atualizar seja bem sucedida, ela retona a locacao antiga com as informacoes atualizadas no banco de dados.
	 * @throws--> se operacao  de salva falhar, sera lancada uma Exception.
	 */
	public Espaco atualizar( Espaco novo)throws Exception{
		return espacoDAO.atualizar(novo);
	}
	/**
	 * @param --> O metodo deletar recebe um parametro locacao-com todos os atibutos atributos internalizados- do tipo Espaco para exclusao da locacao solicitado banco de dados.
	 * @return--> Caso a operacao de deletar seja bem sucedida, ela retona o valor boleano TRUE.
	 * @throws--> se operacao  de deletar falhar, sera lancada uma Exception.
	 */
	public void deletar(Espaco locacao)throws Exception{
		 espacoDAO.deletar(locacao);
	}
	
	/**
	 * @return--> Caso a operacao de listar seja bem sucedida, ela retona uma lista de locacao com todas as locacao salvos no banco de dados.
	 * @throws--> se operacao de listar falhar, sera lancada uma Exception.
	 */
	public List<Espaco> listar()throws Exception{
		return espacoDAO.listar();

	}
	
	/**
	 * @param --> O metodo listar recebe um parametro data do tipo Date  para Listar as locacoes naquela data que estão cadastrada no banco de dados.
	 * @return--> Caso a operacao de listar por data seja bem sucedida, ela retona uma lista com todas as locacao salvos no banco de dados pela data solicitada.
	 * @throws--> se operacao de listar falhar, sera lancada uma Exception.
	 */
	public List<Espaco> listar(Date data)throws Exception{ //não soube mexer nesse

		List<Espaco> todosEspacos = this.listar();
		List<Espaco> espacosDia = new ArrayList<Espaco>();

		for (int i = 0; i < todosEspacos.size(); i++) {
			if(todosEspacos.get(i).getData().compareTo(data)==0) {
				espacosDia.add(todosEspacos.get(i));
			}
		}	
		return espacosDia;
	}

}
