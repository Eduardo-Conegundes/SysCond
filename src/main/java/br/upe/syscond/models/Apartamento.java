package br.upe.syscond.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Apartamento {

	@Id @GeneratedValue(generator = "idApartamento")
	private int id;
    private int numero;
    private String bloco;
    private int vagas;

    public Apartamento(){}

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
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
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
}
