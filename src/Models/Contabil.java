package Models;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Contabil {
	
	
	@OneToMany
	private List<Contas> ContasAPagar;
	@OneToMany
	private List<Contas> ContasAReceber;
	
	@Id
	private int id;
	private Calendar data;
	private String pagador; //quando recebemos
	private String beneficiario;  //quando pagamos
	private float saldo;
	
	public Contabil(List<Contas> contasAPagar, List<Contas> contasAReceber, Calendar data, String pagador,
			String beneficiario, float saldo) {
		ContasAPagar = contasAPagar;
		ContasAReceber = contasAReceber;
		this.data = data;
		this.pagador = pagador;
		this.beneficiario = beneficiario;
		this.saldo = saldo;
	}
	
	public List<Contas> getContasAPagar() {
		return ContasAPagar;
	}
	public void setContasAPagar(List<Contas> contasAPagar) {
		ContasAPagar = contasAPagar;
	}
	public List<Contas> getContasAReceber() {
		return ContasAReceber;
	}
	public void setContasAReceber(List<Contas> contasAReceber) {
		ContasAReceber = contasAReceber;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
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
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
}
