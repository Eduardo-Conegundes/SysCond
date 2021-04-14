package Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FluxoEstoque {
    @Id
    @GeneratedValue(generator = "idFluxoEstoque")
    private int id;
    
    private ServicoProduto produto;
    private int qtd;
    private String tipoTransacao;
    
    @ManyToOne
    private Estoque estoque;
    

    public FluxoEstoque(ServicoProduto produto, int qtd, String tipoTransacao, Estoque estoque){
        this.produto = produto;
        this.qtd = qtd;
        this.tipoTransacao = tipoTransacao;
        this.estoque = estoque;
    }
    /**
     * @return the produto
     */
    public ServicoProduto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(ServicoProduto produto) {
        this.produto = produto;
    }

    /**
     * @return the qtd
     */
    public int getQtd() {
        return qtd;
    }

    /**
     * @param qtd the qtd to set
     */
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    /**
     * @return the tipoTransacao
     */
    public String getTipoTransacao() {
        return tipoTransacao;
    }

    /**
     * @param tipoTransacao the tipoTransacao to set
     */
    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    /**
     * @return the estoque
     */
    public Estoque getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
    
    
}
