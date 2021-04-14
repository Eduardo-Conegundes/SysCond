package Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Empresa implements Serializable {
	@Id
	private String cnpj;
	@OneToMany
	private List<ServicoProduto> servicoproduto;
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

	
}
