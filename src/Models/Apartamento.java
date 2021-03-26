package Models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(ApartamentoPK.class)
public class Apartamento implements Serializable {
   @Id
    private int numero;
    @Id
    private String bloco;
    private int vagas;

    public Apartamento(){}

    public Apartamento(String bloco, int numero,  int vagas) {
        this.numero = numero;
        this.bloco = bloco;
        this.vagas = vagas;
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
