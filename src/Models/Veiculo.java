package Models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Apartamento getApartamento() {
        return apartamento;
    }

    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }
    
}
