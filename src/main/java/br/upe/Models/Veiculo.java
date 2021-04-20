package br.upe.Models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Veiculo implements Serializable {
    @Id
    private String placa;
    @ManyToOne
    private Apartamento apartamento;
    
    public Veiculo() {}
    
    public Veiculo(String placa, Apartamento apartamento){
        this.placa = placa; 
        this.apartamento = apartamento;
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

    
    
}
