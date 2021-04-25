package br.upe.syscond.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Funcionario implements Serializable {
    @Id @OneToOne
    private Pessoa pessoa;
    private String interno_externo;
    private String cargo;
    private float salario;

    public Funcionario(){}
    
    public Funcionario(Pessoa pessoa, String interno_externo, String cargo, float salario) {
        this.pessoa = pessoa;
        this.interno_externo = interno_externo;
        this.salario = salario;
        this.cargo = cargo;
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
	 * @return the interno_externo
	 */
	public String getInterno_externo() {
		return interno_externo;
	}

	/**
	 * @param interno_externo the interno_externo to set
	 */
	public void setInterno_externo(String interno_externo) {
		this.interno_externo = interno_externo;
	}

	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/**
	 * @return the salario
	 */
	public float getSalario() {
		return salario;
	}

	/**
	 * @param salario the salario to set
	 */
	public void setSalario(float salario) {
		this.salario = salario;
	}
    
}
