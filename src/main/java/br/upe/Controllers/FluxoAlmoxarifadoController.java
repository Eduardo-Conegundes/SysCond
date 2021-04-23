package br.upe.Controllers;

import java.util.List;

import br.upe.DAO.AlmoxarifadoDAO;
import br.upe.DAO.ContasDAO;
import br.upe.DAO.FluxoAlmoxarifadoDAO;
import br.upe.Models.Almoxarifado;
import br.upe.Models.Contas;
import br.upe.Models.FluxoAlmoxarifado;


public class FluxoAlmoxarifadoController {
	private static FluxoAlmoxarifadoController instance;
	private Almoxarifado almoxarifado;

	public static FluxoAlmoxarifadoController getInstance() {
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
	
	
	public FluxoAlmoxarifado criar(FluxoAlmoxarifado fluxo){

		FluxoAlmoxarifado fluxocriado = null;

		List<FluxoAlmoxarifado> BDfluxo = this.listar();

		if(BDfluxo.size()==0) {
			try {
				System.out.println("Conta Salva com Sucesso!");
				fluxocriado = FluxoAlmoxarifadoDAO.getInstance().salvar(fluxo);
				return fluxocriado;	
			} catch (Exception eSalvar) {
				System.err.println("Erro ao salvar conta");
			}
		}else{
			for (int i = 0; i < BDfluxo.size(); i++) {
				if(BDfluxo.get(i).equals(fluxo.getId())) {
					System.out.println("Fluxo já exitente!");
					return null;
				}
			}
			try {
				
			} catch (Exception eSalvar) {
				System.err.println("Erro ao salvar conta");
			}
		}
		return null;
		
	}
	
	
	public List<FluxoAlmoxarifado> listar(){
		try {
			List<FluxoAlmoxarifado> fluxorecebido = FluxoAlmoxarifadoDAO.getInstance().listar();
			System.out.println("Lido com sucesso!");
			return fluxorecebido;
		} catch (Exception eListar) {
			eListar.printStackTrace();
			System.err.println("Erro ao listar Conta(s)!");
			return null;
		}
	}
	
	public FluxoAlmoxarifado Transação() {
		///Falta implemenetarrr pois acho que minhas ideias esta certa, mas também está errada
		return null;
		
	}

}
