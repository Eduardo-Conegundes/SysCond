package Models;

import java.io.Serializable;
import javax.persistence.ManyToOne;

public class Estoque implements Serializable {
	private Funcionario pessoa;

	public Estoque() {
	}

	public Estoque (Funcionario pessoa){
		this.pessoa = pessoa;
	}

	public Funcionario getPessoa() {
		return pessoa;
	}

	public void setPessoa(Funcionario pessoa) {
		this.pessoa = pessoa;
	}

}