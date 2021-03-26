package Models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ServicoProduto implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;

	@ManyToMany(mappedBy="servicoproduto")
	private List<Empresa> empresa;
	private String categoria;
	private String nome;
	private float valor;

	public ServicoProduto() {
	}


	public ServicoProduto( String nome, float valor, String categoria){
		this.nome = nome;
		this.valor = valor;
		this.categoria = categoria;       
	}

	public ServicoProduto(String nome, float valor, List<Empresa> empresa, String categoria) {
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

	public List<Empresa> getEmpresa() {
		return empresa;
	}

	public void setEmpresa(List<Empresa> empresa) {
		this.empresa = empresa;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}




}
