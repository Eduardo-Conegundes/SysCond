package Models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
public class Locacao implements Serializable {
    @Id
    @GeneratedValue(generator = "idLocacao")
    private long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @OneToOne
    private Apartamento apartamento;
    @OneToOne
    private Espaco espaco;
    private float valor;

    public Locacao() {
    }

    public Locacao(Date data, Apartamento apartamento, Espaco espaco, float valor){
        this.data = data;
        this.apartamento = apartamento;
        this.espaco = espaco;
        this.valor = valor;
    }

    public Apartamento getApartamento() {
        return apartamento;
    }


    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }

    public Espaco getEspaco() {
        return espaco;
    }


    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }    

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData() {
        return data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
}
