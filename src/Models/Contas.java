package Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contas {
	
	@Id
	@GeneratedValue(generator = "idConta")
	
	private int id;
	private String identificador;
	private float valor;
	public int getId() {
		return id;
	}
	
	public Contas() {
		
	}
	
	public Contas(String identificador, float valor) {
		this.identificador = identificador;
		this.valor = valor;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public float getValor() {
		return valor;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}
	

	
}
