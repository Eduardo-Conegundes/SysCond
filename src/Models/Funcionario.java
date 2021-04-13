package Models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Funcionario implements Serializable {
    @Id
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
    
    public String getCargo() {
		return cargo;
	}
    
    public void setCargo(String cargo) {
		this.cargo = cargo;
	}

    public Pessoa getPessoa() {
		return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
	this.pessoa = pessoa;
    }

    public String getInterno_externo() {
        return interno_externo;
    }

    public void setInterno_externo(String interno_externo) {
        this.interno_externo = interno_externo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

}
