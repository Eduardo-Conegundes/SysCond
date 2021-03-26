package Models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Estoque implements Serializable {
    @Id
    @GeneratedValue(generator = "idGenerator")
    private long id;
    @ManyToOne
    private Funcionario pessoa;

    public Estoque (Funcionario pessoa){
        this.pessoa = pessoa;
    }
    
    public Funcionario getPessoa() {
        return pessoa;
    }

    public void setPessoa(Funcionario pessoa) {
        this.pessoa = pessoa;
    }
    
}
