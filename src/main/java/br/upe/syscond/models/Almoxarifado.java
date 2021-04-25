package br.upe.syscond.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//@Entity
public class Almoxarifado {

	//@Id @GeneratedValue(generator = "idAlmoxarifado")
	private int id;
	//@OneToMany
	private List<FluxoAlmoxarifado> fluxoalmoxarifado;


	public Almoxarifado(List<FluxoAlmoxarifado> fluxoalmoxarifado) {
		this.fluxoalmoxarifado = fluxoalmoxarifado;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public List<FluxoAlmoxarifado> getAlmoxarifado() {
		return fluxoalmoxarifado;
	}
	
	public void setAlmoxarifado(List<FluxoAlmoxarifado> fluxoalmoxarifado) {
		this.fluxoalmoxarifado = fluxoalmoxarifado;
	}


}
