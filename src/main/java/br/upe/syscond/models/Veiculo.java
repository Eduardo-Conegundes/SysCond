package br.upe.syscond.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Veiculo implements Serializable {
    @Id @GeneratedValue(generator = "idVeiculo")
    private int id;
    @ManyToOne
    private Apartamento apartamento;
    @Column(nullable = false)
    private String placa;
    
    public Veiculo() {}
    /**
     * 
     * @param placa
     * @param apartamento
     */
    public Veiculo(String placa, Apartamento apartamento){
        this.placa = placa; 
        this.apartamento = apartamento;
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
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/**
	 * @return the apartamento
	 */
	public Apartamento getApartamento() {
		return apartamento;
	}

	/**
	 * @param apartamento the apartamento to set
	 */
	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}
	
	public String getApartamentoString() {
		return apartamento.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return Objects.equals(apartamento, other.apartamento) && Objects.equals(placa, other.placa);
	}


    
}
