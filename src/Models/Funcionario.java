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
    private String tipo;
    private float salario;

    public Funcionario(){}
    
    public Funcionario(Pessoa pessoa, String tipo, float salario) {
        this.pessoa = pessoa;
        this.tipo = tipo;
        this.salario = salario;
    }

    public Pessoa getPessoa() {
		return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
	this.pessoa = pessoa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

}
