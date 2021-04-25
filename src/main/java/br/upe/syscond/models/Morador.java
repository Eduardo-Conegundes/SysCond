package br.upe.syscond.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Morador implements Serializable {

    @Id @OneToOne
    private Pessoa pessoa;
    @ManyToOne
    private Apartamento apartamento;

    public Morador() {
    }

    public Morador(Pessoa pessoa, Apartamento apartamento) {
        this.pessoa = pessoa;
        this.apartamento = apartamento;
    }

	/**
	 * @return the pessoa
	 */
	public Pessoa getPessoa() {
		return pessoa;
	}

	/**
	 * @param pessoa the pessoa to set
	 */
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	/**
	 * @return the apartamento
	 */
	public Apartamento getApartamento() {
		return apartamento;
	}

	/**
	 * @param apartamento the apartamento to set
	 */
	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}


}
