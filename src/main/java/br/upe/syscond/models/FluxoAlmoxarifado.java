package br.upe.syscond.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FluxoAlmoxarifado {
	@Id @GeneratedValue(generator = "idFluxoAlmoxarifado")
	private int id;
	@Column(nullable = false)
	private int qtd;
	@Column(nullable = false)
	private String nomeDoProduto; 
	@ManyToOne
	private Almoxarifado estoque;

	public FluxoAlmoxarifado() {}
	
	/**
	 * 
	 * @param produto
	 * @param qtd
	 * @param nomeDoProduto
	 * @param estoque
	 */
	public FluxoAlmoxarifado(int qtd, String nomeDoProduto, Almoxarifado estoque){
		this.qtd = qtd;
		this.nomeDoProduto = nomeDoProduto;
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
	 * @return the nomeDoProduto
	 */
	public String getNomeDoProduto() {
		return nomeDoProduto;
	}
	/**
	 * @param nomeDoProduto the nomeDoProduto to set
	 */
	public void setNomeDoProduto(String nomeDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
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
	
	public String getProdutoString() {
		return nomeDoProduto.toString();
	}
	
	public String getQtdString() {
		return Integer.toString(qtd);
	}


}