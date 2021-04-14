package Models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Contas {
	@Id
	@GeneratedValue(generator = "idConta")
	private int id;
	private String identificador;
	private String pagador; //quando recebemos
	private String beneficiario;  //quando pagamos
	private float valor;
	private Calendar data;
	private String status;//a receber / a pagar
	public Contas() {
		
	}
	
	public Contas(String status, String identificador, String pagador, String beneficiario, float valor, Calendar data) {
		this.identificador = identificador;
		this.pagador = pagador;
		this.beneficiario = beneficiario;
		this.valor = valor;
		this.data = data;
		this.status = status;
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
	 * @return the data
	 */
	public Calendar getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Calendar data) {
		this.data = data;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
