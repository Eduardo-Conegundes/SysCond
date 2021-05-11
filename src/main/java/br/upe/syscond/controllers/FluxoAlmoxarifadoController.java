package br.upe.syscond.controllers;

import java.util.List;
import br.upe.syscond.dao.AlmoxarifadoDAO;
import br.upe.syscond.dao.FluxoAlmoxarifadoDAO;
import br.upe.syscond.dao.InterfaceFluxoAlmoxarifado;
import br.upe.syscond.models.Almoxarifado;
import br.upe.syscond.models.FluxoAlmoxarifado;


public class FluxoAlmoxarifadoController implements InterfaceFluxoAlmoxarifadoController{
	private static FluxoAlmoxarifadoController instance;
	private Almoxarifado almoxarifado;
	private static InterfaceFluxoAlmoxarifado fluxoDAO = FluxoAlmoxarifadoDAO.getInstance();

	/**
	 * 
	 * @return--> Se existir um controlador de almoxarifado ele retornara a sua instancia, caso contrario ele criara uma instancia.
	 * @throws--> se operacaoo  de verificacao ou de salva falhar, sera lancada uma Exception.
	 */
	public static FluxoAlmoxarifadoController getInstance() throws Exception {
		if(instance == null) {
			instance = new FluxoAlmoxarifadoController();
		}
		return instance;
	}

	private FluxoAlmoxarifadoController() {
		if(AlmoxarifadoDAO.getInstance().listar().size()==0) {
			try {
				this.almoxarifado = AlmoxarifadoDAO.getInstance().salvar(new Almoxarifado(null));;    
			} catch (Exception e) {
				System.out.println("Erro!");
			}
		}else {
			this.almoxarifado = AlmoxarifadoDAO.getInstance().buscar(1);
		}
	}

	/**
	 * @param --> O metodo criar recebe um parametro fluxo-com todos atributos internalizados- do tipo fluxo para salvar no banco de dados.
	 * @return--> Caso a operacao de criar seja bem sucedida, ela retona uma fluxo salvo no banco de dados.
	 * @throws--> se operacaoo  de salva falhar, sera lancada uma Exception.
	 */ 
	public FluxoAlmoxarifado criar(FluxoAlmoxarifado fluxo)throws Exception{
			fluxo.setEstoque(almoxarifado);
			return fluxoDAO.salvar(fluxo);
	}
	
	/**
	 * @return--> Caso a operacao de listar seja bem sucedida, ela retona uma lista com todas as FluxoAlmoxarifado salvas no banco de dados.
	 * @throws--> se operacao de listar falhar, sera lancada uma Exception.
	 */
	public List<FluxoAlmoxarifado> listar() throws Exception{
			return fluxoDAO.listar();
	}
	
	/**
	 * @param --> O metodo buscar recebe um parametro fluxo -com todos os atributos de uma fluxo- do tipo fluxo para realizar uma busca no banco de dados da fluxo solicitada.
	 * @return--> Caso aoperacao  de Buscar seja bem sucedida, ela retona a fluxo deseja que esta no Banco de dados. 
	 * @throws Exception--> se operacao de listar falhar, sera lancada uma Exception.
	 */
	public FluxoAlmoxarifado buscar(FluxoAlmoxarifado fluxo) throws Exception{
			return fluxoDAO.buscar(fluxo);
	}
	
	/**
	 * @param --> O metodo atualizar recebe um parametro nova-com um ou diversos atributos internalizados- do tipo fluxo para atualizar a fluxo antiga no banco de dados.
	 * @return--> Caso a operacao de atualizar seja bem sucedida, ela retona a FluxoAlmoxarifado com as informacoes atualizadas no banco de dados.
	 */
	public FluxoAlmoxarifado atualizar(FluxoAlmoxarifado nova) throws Exception{
			return fluxoDAO.atualizar(nova);
	}
	
	/**
	 * @param --> O metodo deletar recebe um parametro fluxo-com todos os atibutos atributos internalizados- do tipo fluxo para exclusao da fluxo solicitado banco de dados.
	 * @return--> Caso a operacao de deletar seja bem sucedida, ela retona o valor boleano TRUE.
	 */
	public void deletar(FluxoAlmoxarifado fluxo) throws Exception{
			fluxoDAO.deletar(fluxo);
	}

}
