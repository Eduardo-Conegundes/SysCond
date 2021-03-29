package Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Contabil {
	@Id @GeneratedValue
	private int id;
	@OneToMany
	private List<Contas> Contas;
	private float saldo;
	
	public Contabil() {}
	public Contabil(List<Contas> contas, float saldo) {
		this.Contas = contas;
		this.saldo = saldo;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public List<Contas> getContasAPagar() {
		return Contas;
	}
	
	public void setContas(List<Contas> contas) {
		Contas = contas;
	}

	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

}
