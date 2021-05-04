package br.upe.syscond.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.upe.syscond.dao.AlmoxarifadoDAO;
import br.upe.syscond.dao.FluxoAlmoxarifadoDAO;
import br.upe.syscond.models.Almoxarifado;
import br.upe.syscond.models.FluxoAlmoxarifado;


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
		if (fluxo.getTipoTransacao().equals("saida")) {
			int countAux = 0;
			List<FluxoAlmoxarifado> BDfluxo = this.listar();

			if(BDfluxo.size()==0) {
				System.err.println("Não há estoque.");
				return null;
			}

			for (int i = 0; i < BDfluxo.size(); i++) {
				if(BDfluxo.get(i).getProduto().getNome().equals(fluxo.getProduto().getNome())) {
					if (BDfluxo.get(i).getTipoTransacao().equals("saida")) {
						countAux-=BDfluxo.get(i).getQtd();
					}else if (BDfluxo.get(i).getTipoTransacao().equals("entrada")) {
						countAux+=BDfluxo.get(i).getQtd();
					}
				}
			}

			if (countAux-fluxo.getQtd() < 0) {
				System.err.println("Não há estoque suficiente para retirar.");
				return null;
			}else {
				try {
					fluxocriado = FluxoAlmoxarifadoDAO.getInstance().salvar(fluxo);
					return fluxocriado;	
				} catch (Exception eSalvar) {
					System.err.println("Erro ao salvar transação!");
					return null;
				}
			}
		}else if (fluxo.getTipoTransacao().equals("entrada")) {
			try {
				fluxocriado = FluxoAlmoxarifadoDAO.getInstance().salvar(fluxo);
				return fluxocriado;	
			} catch (Exception eSalvar) {
				System.err.println("Erro ao salvar transação!");
				return null;
			}
		}
		
		return null;
	}

	public List<FluxoAlmoxarifado> listar(){		
		
		
		List<FluxoAlmoxarifado> BDfluxo = this.listar();
		List<Object> ListAux =  new ArrayList<Object>();
		
		if(BDfluxo.size()==0) {
			System.err.println("Não há estoque.");
			return null;
		}

		for (int j = 0; j < BDfluxo.size(); j++) {
			int countAux = 0;
			for (int i = 0; i < BDfluxo.size(); i++) {
				if(BDfluxo.get(i).getProduto().getNome().equals(BDfluxo.get(j).getProduto().getNome())) {
					if (BDfluxo.get(i).getTipoTransacao().equals("saida")) {
						countAux-=BDfluxo.get(i).getQtd();
					}else if (BDfluxo.get(i).getTipoTransacao().equals("entrada")) {
						countAux+=BDfluxo.get(i).getQtd();
					}
				}
			}
			
			//Object object = new Object(produto:BDFluxo.get(j).getProduto().getNome()); 
			Object object = new Object();
			object.name = 1;
			ListAux.add(ListAux);
		}
		
		try {
			List<FluxoAlmoxarifado> fluxorecebido = FluxoAlmoxarifadoDAO.getInstance().listar();
			System.out.println("Lido com sucesso!");
			return fluxorecebido;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar Conta(s)!");
			return null;
		}
	}

	//	public FluxoAlmoxarifado Transa��o() {
	//		///Falta implemenetarrr pois acho que minhas ideias esta certa, mas tamb�m est� errada
	//		return null;
	//		
	//	}

}
