package Models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ServicoProduto implements Serializable {
	@Id
	@GeneratedValue(generator = "idServicoProduto")
	private int id;
	@OneToOne
	private Empresa empresa;
	private String categoria;
	private String nome; 
	private float valor;

	public ServicoProduto() {
	}

	public ServicoProduto(String nome, float valor, Empresa empresa, String categoria) {
		this.nome = nome;
		this.valor = valor;
		this.empresa = empresa;
		this.categoria = categoria;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}




}
