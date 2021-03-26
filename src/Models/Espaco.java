package Models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class Espaco implements Serializable {

    @Id ///(Acredito que essa entidade fica melhor tendo o ID como chave Primaria)
    @GeneratedValue(generator = "idGenerator")
    private long id;
    private String nome;
    private int qtdPessoa;

    public Espaco() {
    }

    public Espaco(String nome, int qtdPessoa) {
        this.nome = nome;
        this.qtdPessoa = qtdPessoa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdPessoa() {
        return qtdPessoa;
    }

    public void setQtdPessoa(int qtdPessoa) {
        this.qtdPessoa = qtdPessoa;
    }

}
