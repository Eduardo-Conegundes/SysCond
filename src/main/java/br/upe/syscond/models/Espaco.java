package br.upe.syscond.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Espaco implements Serializable {
	@Id @GeneratedValue(generator = "idLocacao")
	private int id;
	@Temporal(TemporalType.DATE)
	private Date data;
	@Temporal(TemporalType.TIME)
	private Date horarioInicio;
	@Temporal(TemporalType.TIME)
	private Date horarioFim;
	@OneToOne
	private Morador morador;
	private String espaco;
	private float valor;


	public Espaco() {
	}
	/**
	 * 
	 * @param data
	 * @param horarioInicio
	 * @param horarioFim
	 * @param morador
	 * @param espaco
	 * @param valor
	 */
	public Espaco(Date data, Date horarioInicio, Date horarioFim,
			Morador morador, String espaco, float valor) {
		this.data = data;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
		this.morador = morador;
		this.espaco = espaco;
		this.valor = valor;
	}

/**
 * 
 * @return id
 */
	public int getId() {
		return id;
	}
/**
 * 
 * @param id
 */
	public void setId(int id) {
		this.id = id;
	}
/**
 * 
 * @return data
 */
	public java.util.Date getData() {
		return data;
	}
/**
 * 
 * @param data
 */
	public void setData(java.util.Date data) {
		this.data = data;
	}
/**
 * 
 * @return horarioInicio
 */
	public java.util.Date getHorarioInicio() {
		return horarioInicio;
	}
/**
 * 
 * @param horarioInicio
 */
	public void setHorarioInicio(java.util.Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
/**
 * 
 * @return horarioFim
 */
	public java.util.Date getHorarioFim() {
		return horarioFim;
	}
/**
 * 
 * @param horarioFim
 */
	public void setHorarioFim(java.util.Date horarioFim) {
		this.horarioFim = horarioFim;
	}
	/**
	 * 
	 * @return morador
	 */
	public Morador getMorador() {
		return morador;
	}
	/**
	 * 
	 * @param morador
	 */
	public void setMorador(Morador morador) {
		this.morador = morador;
	}
	/**
	 * 
	 * @return espaco
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
	
	public String getMoradorToString(){
		return this.morador.getPessoaString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Espaco other = (Espaco) obj;
		return Objects.equals(data, other.data) && Objects.equals(espaco, other.espaco)
				&& Objects.equals(horarioFim, other.horarioFim) && Objects.equals(horarioInicio, other.horarioInicio)
				&& Objects.equals(morador, other.morador)
				&& Float.floatToIntBits(valor) == Float.floatToIntBits(other.valor);
	}



}
