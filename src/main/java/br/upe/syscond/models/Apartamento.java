package br.upe.syscond.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"numero", "bloco"}))
public class Apartamento {

	@Id @GeneratedValue(generator = "idApartamento")
	private int id;
	private int numero;
	private String bloco;
	private int vagas;
	

	public Apartamento(){}

	/**
	 * @param bloco
	 * @param numero
	 * @param vagas
	 */
	public Apartamento(String bloco, int numero,  int vagas) {
		this.bloco = bloco;
		this.numero = numero;
		this.vagas = vagas;
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
	 * @return the number
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the number to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the bloco
	 */
	public String getBloco() {
		return bloco;
	}

	/**
	 * @param bloco the bloco to set
	 */
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	/**
	 * @return the vagas
	 */
	public int getVagas() {
		return vagas;
	}

	/**
	 * @param vagas the vagas to set
	 */
	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	/**
	 * @return String dos atributos do Apartamento
	 */
	@Override
	public String toString() {
		return "Bloco: " + bloco + ", Núm: " + numero;
	}

	/**
	 * @param obj 
	 * @return se o obj é igual em bloco e número
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Apartamento other = (Apartamento) obj;
		if (bloco == null) {
			if (other.bloco != null) {
				return false;
			}
		} else if (!bloco.equals(other.bloco)) {
			return false;
		}
		if (numero != other.numero) {
			return false;
		}
		if (vagas != other.vagas) {
			return false;
		}
		return true;
	}
}
