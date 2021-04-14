package Models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Apartamento implements Serializable {
	@Id
	@GeneratedValue(generator = "idApartamento")
	private int id;
    private int numero;
    private String bloco;
    private int vagas;

    public Apartamento(){}

    public Apartamento(String bloco, int numero,  int vagas) {
    	this.bloco = bloco;
    	this.numero = numero;
        this.vagas = vagas;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

}
