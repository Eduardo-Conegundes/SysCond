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
		Apartamento ap = (Apartamento) obj;
		if((ap.getBloco().compareTo(this.bloco)== 0) && ap.getNumero() == this.numero) {
			return true;			
		}else {
			return false;
		}
	}
}
