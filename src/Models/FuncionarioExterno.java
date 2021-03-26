package Models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class FuncionarioExterno implements Serializable{

    @Id
    @OneToOne
    private Pessoa pessoa;
    @ManyToOne
    private Empresa empresa;

    public FuncionarioExterno() {}
    
    public FuncionarioExterno(Pessoa pessoa, Empresa empresa) {
        this.pessoa = pessoa;
        this.empresa = empresa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
}
