package br.upe.syscond.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class FluxoAlmoxarifado {
	//@Id @GeneratedValue(generator = "idFluxoAlmoxarifado")
	private int id;
	private int qtd;
	private String tipoTransacao; //entrada ou saida
	private Almoxarifado estoque;

	public FluxoAlmoxarifado() {}
	
	/**
	 * 
	 * @param produto
	 * @param qtd
	 * @param tipoTransacao
	 * @param estoque
	 */
	public FluxoAlmoxarifado(int qtd, String tipoTransacao, Almoxarifado estoque){
		this.qtd = qtd;
		this.tipoTransacao = tipoTransacao;
		this.estoque = estoque;
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
	 * @return the qtd
	 */
	public int getQtd() {
		return qtd;
	}
	/**
	 * @param qtd the qtd to set
	 */
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	/**
	 * @return the tipoTransacao
	 */
	public String getTipoTransacao() {
		return tipoTransacao;
	}
	/**
	 * @param tipoTransacao the tipoTransacao to set
	 */
	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}
	/**
	 * @return the estoque
	 */
	public Almoxarifado getEstoque() {
		return estoque;
	}
	/**
	 * @param estoque the estoque to set
	 */
	public void setEstoque(Almoxarifado estoque) {
		this.estoque = estoque;
	}



}