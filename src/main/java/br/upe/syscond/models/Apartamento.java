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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

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
