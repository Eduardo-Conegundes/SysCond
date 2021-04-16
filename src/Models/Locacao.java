package Models;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Locacao implements Serializable {
	@Id @GeneratedValue(generator = "idLocacao")
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

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the data
	 */
	public Calendar getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Calendar data) {
		this.data = data;
	}

	/**
	 * @return the morador
	 */
	public Morador getMorador() {
		return morador;
	}

	/**
	 * @param morador the morador to set
	 */
	public void setMorador(Morador morador) {
		this.morador = morador;
	}

	/**
	 * @return the espaco
	 */
	public String getEspaco() {
		return espaco;
	}

	/**
	 * @param espaco the espaco to set
	 */
	public void setEspaco(String espaco) {
		this.espaco = espaco;
	}

	/**
	 * @return the valor
	 */
	public float getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(float valor) {
		this.valor = valor;
	}

}
