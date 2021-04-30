package br.upe.syscond.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Empresa implements Serializable {
	@Id @GeneratedValue(generator = "idEmpresa")
	private int id;
	@OneToMany
	private List<ServicoProduto> servicoproduto;
	private String cnpj;
	private String nome;
	private String telefone;

	public Empresa() {
	}

	public Empresa(String cnpj, List<ServicoProduto> servicoproduto, String nome, String telefone){
		this.cnpj = cnpj;
		this.nome = nome;
		this.servicoproduto = servicoproduto;
		this.telefone = telefone;
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
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @return the servicoproduto
	 */
	public List<ServicoProduto> getServicoproduto() {
		return servicoproduto;
	}

	/**
	 * @param servicoproduto the servicoproduto to set
	 */
	public void setServicoproduto(List<ServicoProduto> servicoproduto) {
		this.servicoproduto = servicoproduto;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}

	
}
