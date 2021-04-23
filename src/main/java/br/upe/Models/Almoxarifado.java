package br.upe.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Almoxarifado implements Serializable {
	@Id @GeneratedValue(generator = "idAlmoxarifado")
	private int id;
	@OneToMany
	private List<FluxoAlmoxarifado> Almoxarifado;

	public Almoxarifado() {
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
	 * @return the Almoxarifado
	 */
	public List<FluxoAlmoxarifado> getEstoque() {
		return Almoxarifado;
	}

	/**
	 * @param estoque the Almoxarifado to set
	 */
	public void setEstoque(List<FluxoAlmoxarifado> Almoxarifado) {
		this.Almoxarifado = Almoxarifado;
	}

}