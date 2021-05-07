package br.upe.syscond.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contas {
	@Id @GeneratedValue(generator = "idConta")
	private int id;
	private String identificador;
	private String pagador; //quando recebemos
	private String beneficiario;  //quando pagamos
	private float valor;
	private LocalDate dataEmissao;
	private LocalDate dataVencimento;
	private Boolean AReceber;//true=a receber / false=a pagar
	private Boolean statusPaga;

	public Contas() {

	}
	/**
	 * @param identificador
	 * @param pagador
	 * @param beneficiario
	 * @param valor
	 * @param dataEmissao
	 * @param dataVencimento
	 * @param aReceber
	 * @param statusPaga
	 */
	public Contas(String identificador, String pagador, String beneficiario, float valor, LocalDate dataEmissao,
			LocalDate dataVencimento, Boolean aReceber, Boolean statusPaga) {
		super();
		this.identificador = identificador;
		this.pagador = pagador;
		this.beneficiario = beneficiario;
		this.valor = valor;
		this.dataEmissao = dataEmissao;
		this.dataVencimento = dataVencimento;
		AReceber = aReceber;
		this.statusPaga = statusPaga;
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
	public LocalDate getDataEmissao() {
		return dataEmissao;
	}
	/**
	 * @param dataEmissao the dataEmissao to set
	 */
	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	/**
	 * @return the dataVencimento
	 */
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	/**
	 * @param dataVencimento the dataVencimento to set
	 */
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	/**
	 * @return the aReceber
	 */
	public Boolean getAReceber() {
		return AReceber;
	}
	/**
	 * @param aReceber the aReceber to set
	 */
	public void setAReceber(Boolean aReceber) {
		AReceber = aReceber;
	}
	/**
	 * @return the statusPaga
	 */
	public Boolean getStatusPaga() {
		return statusPaga;
	}
	/**
	 * @param statusPaga the statusPaga to set
	 */
	public void setStatusPaga(Boolean statusPaga) {
		this.statusPaga = statusPaga;
	}
	@Override
	public boolean equals(Object obj) {
		Contas conta = (Contas)obj;
		if(
				(this.identificador.compareTo(conta.getIdentificador()) == 0) &&
				(this.pagador.compareTo(conta.getPagador()) == 0) &&
				(this.beneficiario.compareTo(conta.getBeneficiario()) == 0) &&
				(this.valor == conta.getValor()) &&
				(this.dataEmissao.compareTo(conta.getDataEmissao()) == 0) &&
				(this.dataVencimento.compareTo(conta.getDataVencimento()) == 0) &&
				(this.AReceber == conta.getAReceber()) &&
				(this.statusPaga == (conta.getStatusPaga()))

				) {
			return true;
		}else {
			return false;			
		}
	}

}
