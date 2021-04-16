package Models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contas {
	@Id
	@GeneratedValue(generator = "idConta")
	private int id;
	private String identificador;
	private String pagador; //quando recebemos
	private String beneficiario;  //quando pagamos
	private float valor;
	private Calendar dataEmissao;
	private Calendar dataVencimento;
	private Boolean AReceber;//true=a receber / false=a pagar
	
	public Contas() {
			
	}
	
	/**
	 * @param identificador
	 * @param pagador
	 * @param beneficiario
	 * @param valor
	 * @param dataEmissao
	 * @param dataVencimento
	 * @param AReceber
	 */
	public Contas(String identificador, String pagador, String beneficiario, float valor, Calendar dataEmissao,
			Calendar dataVencimento, Boolean AReceber) {
		this.identificador = identificador;
		this.pagador = pagador;
		this.beneficiario = beneficiario;
		this.valor = valor;
		this.dataEmissao = dataEmissao;
		this.dataVencimento = dataVencimento;
		this.AReceber = AReceber;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the identificador
	 */
	public String getIdentificador() {
		return identificador;
	}
	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	/**
	 * @return the pagador
	 */
	public String getPagador() {
		return pagador;
	}
	/**
	 * @param pagador the pagador to set
	 */
	public void setPagador(String pagador) {
		this.pagador = pagador;
	}
	/**
	 * @return the beneficiario
	 */
	public String getBeneficiario() {
		return beneficiario;
	}
	/**
	 * @param beneficiario the beneficiario to set
	 */
	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}
	/**
	 * @return the valor
	 */
	public float getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(float valor) {
		this.valor = valor;
	}
	/**
	 * @return the dataEmissao
	 */
	public Calendar getDataEmissao() {
		return dataEmissao;
	}
	/**
	 * @param dataEmissao the dataEmissao to set
	 */
	public void setDataEmissao(Calendar dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	/**
	 * @return the dataVencimento
	 */
	public Calendar getDataVencimento() {
		return dataVencimento;
	}
	/**
	 * @param dataVencimento the dataVencimento to set
	 */
	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	/**
	 * @return the AReceber
	 */
	public Boolean AReceber() {
		return AReceber;
	}
	/**
	 * @param AReceber the AReceber to set
	 */
	public void setAReceber(Boolean AReceber) {
		this.AReceber = AReceber;
	}
	
	
}
