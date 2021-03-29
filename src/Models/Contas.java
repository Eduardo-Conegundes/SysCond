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

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getPagador() {
		return pagador;
	}
	public void setPagador(String pagador) {
		this.pagador = pagador;
	}
	public String getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
