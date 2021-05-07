package br.upe.syscond.models;

import java.util.List;

//@Entity
public class Almoxarifado {

	//@Id @GeneratedValue(generator = "idAlmoxarifado")
	private int id;
	//@OneToMany
	private List<FluxoAlmoxarifado> fluxoalmoxarifado;

	/**
	 * 
	 * @param fluxoalmoxarifado
	 */
	public Almoxarifado(List<FluxoAlmoxarifado> fluxoalmoxarifado) {
		this.fluxoalmoxarifado = fluxoalmoxarifado;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the fluxoalmoxarifado
	 */
	public List<FluxoAlmoxarifado> getFluxoalmoxarifado() {
		return fluxoalmoxarifado;
	}


	/**
	 * @param fluxoalmoxarifado the fluxoalmoxarifado to set
	 */
	public void setFluxoalmoxarifado(List<FluxoAlmoxarifado> fluxoalmoxarifado) {
		this.fluxoalmoxarifado = fluxoalmoxarifado;
	}




}
