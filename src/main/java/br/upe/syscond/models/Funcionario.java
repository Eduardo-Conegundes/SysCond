package br.upe.syscond.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Funcionario implements Serializable {
    @Id @GeneratedValue(generator = "idFuncionario") 
    private int id;
    @OneToOne
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(cargo, other.cargo) && Objects.equals(interno_externo, other.interno_externo)
				&& Objects.equals(pessoa, other.pessoa)
				&& Float.floatToIntBits(salario) == Float.floatToIntBits(other.salario);
	}
    
}