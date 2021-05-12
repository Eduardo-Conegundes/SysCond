package br.upe.syscond.models;

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
	private List<Contas> contas;
	private float saldo;
	
	public Contabil() {}
	/**
	 * 
	 * @param contas
	 * @param saldo
	 */
	public Contabil(List<Contas> contas, float saldo) {
		this.contas = contas;
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
		return contas;
	}
	/**
	 * @param contas the contas to set
	 */
	public void setContas(List<Contas> contas) {
		this.contas = contas;
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
	/**
	 * 
	 * @return contas em string
	 */
	public String getContasString() {
		return this.contas.toString();
	}
	
	
}
