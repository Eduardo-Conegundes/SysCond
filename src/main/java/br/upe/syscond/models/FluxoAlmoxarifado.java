package br.upe.syscond.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class FluxoAlmoxarifado {
	//@Id @GeneratedValue(generator = "idFluxoAlmoxarifado")
	private int id;
	private ServicoProduto produto;
	private int qtd;
	private String tipoTransacao; //entrada ou saida
	private Almoxarifado estoque;

	public FluxoAlmoxarifado() {
		// TODO Auto-generated constructor stub
	}
	public FluxoAlmoxarifado(ServicoProduto produto, int qtd, String tipoTransacao, Almoxarifado estoque){
		this.produto = produto;
		this.qtd = qtd;
		this.tipoTransacao = tipoTransacao;
		this.estoque = estoque;
	}

	public ServicoProduto getProduto() {
		return produto;
	}


	public void setProduto(ServicoProduto produto) {
		this.produto = produto;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public String getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public Almoxarifado getEstoque() {
		return estoque;
	}

	public void setEstoque(Almoxarifado estoque) {
		this.estoque = estoque;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}