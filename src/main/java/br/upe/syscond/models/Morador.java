package br.upe.syscond.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Morador implements Serializable {


	@Id @GeneratedValue(generator = "idMorador")
    private int id;
    @OneToOne
    private Pessoa pessoa;
    @ManyToOne
    private Apartamento apartamento;

    public Morador() {}
    
    public Morador(Pessoa pessoa, Apartamento apartamento) {
        this.pessoa = pessoa;
        this.apartamento = apartamento;
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
     * 
     * @return pessoa
     */
	public Pessoa getPessoa() {
		return pessoa;
	}
	/**
	 * 
	 * @param pessoa
	 */
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	/**
	 * 
	 * @return apartamento
	 */
	public Apartamento getApartamento() {
		return apartamento;
	}
	/**
	 * 
	 * @param apartamento
	 */
	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}
	
	public String getPessoaString() {
		return pessoa.toString();
	}
	
	public String getApartamentoString() {
		return apartamento.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Morador other = (Morador) obj;
		return Objects.equals(apartamento, other.apartamento) && Objects.equals(pessoa, other.pessoa);
	}

	
}
