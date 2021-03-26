package Models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Morador implements Serializable {

    @Id
    @OneToOne
    private Pessoa pessoa;
    @ManyToOne
    private Apartamento apartamento;

    public Morador() {
    }

    public Morador(Pessoa pessoa, Apartamento apartamento) {
        this.pessoa = pessoa;
        this.apartamento = apartamento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Apartamento getApartamento() {
        return apartamento;
    }

    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }

}
