package Models;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Locacao implements Serializable {
	@Id
	@GeneratedValue(generator = "idLocacao")
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	@OneToOne
	private Morador morador;
	private String espaco;
	private float valor;


	public Locacao() {
	}

	public Locacao(Calendar data, Morador morador, String espaco, float valor){
		this.data = data;
		this.morador = morador;
		this.espaco = espaco;
		this.valor = valor;
	}

	public Morador getMorador() {
		return morador;
	}
	public void setMorador(Morador morador) {
		this.morador = morador;
	}
	public String getEspaco() {
		return espaco;
	}
	public void setEspaco(String espaco) {
		this.espaco = espaco;
	} 

	public float getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}    

	public void setData(Calendar data) {
		this.data = data;
	}

	public Calendar getData() {
		return data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

}
