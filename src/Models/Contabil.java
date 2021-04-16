package Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Contabil {
	@Id @GeneratedValue(generator = "idContabil")
	private int id;
	@OneToMany
	private List<Contas> Contas;
	private float saldo;
	
	public Contabil() {}
	
	public Contabil(List<Contas> contas, float saldo) {
		this.Contas = contas;
		this.saldo = saldo;
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
	 * @return the contas
	 */
	public List<Contas> getContas() {
		return Contas;
	}
	/**
	 * @param contas the contas to set
	 */
	public void setContas(List<Contas> contas) {
		Contas = contas;
	}
	/**
	 * @return the saldo
	 */
	public float getSaldo() {
		return saldo;
	}
	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
}
