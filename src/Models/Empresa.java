package Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ServicoProduto> getServicoproduto() {
		return servicoproduto;
	}

	public void setServicoproduto(List<ServicoProduto> servicoproduto) {
		this.servicoproduto = servicoproduto;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
