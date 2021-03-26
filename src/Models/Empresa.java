package Models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Empresa implements Serializable {
    @Id
    private String cnpj;
    
   @ManyToMany
    private List<ServicoProduto> servicoproduto;
    private String nome;
    private String tipo;
    private String telefone;

    public Empresa() {
    }
        public Empresa(String cnpj, String nome, String tipo, String telefone){
        this.cnpj = cnpj;
        this.nome = nome;
        this.tipo = tipo;
        this.telefone = telefone;
    }
    

    public Empresa(String cnpj, List<ServicoProduto> servicoproduto, String nome, String tipo, String telefone){
        this.cnpj = cnpj;
        this.nome = nome;
        this.tipo = tipo;
        this.servicoproduto = servicoproduto;
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<ServicoProduto> getServicoproduto() {
        return servicoproduto;
    }

    public void setServicoproduto(List<ServicoProduto> servicoproduto) {
        this.servicoproduto = servicoproduto;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
