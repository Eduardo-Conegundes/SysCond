package br.upe.syscond.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pessoa {

	@Id @GeneratedValue(generator = "idPessoa")
	private int id;
	@Column(nullable = false)
	private String cpf;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String telefone;
	@Column(nullable = false)
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Morador morador;

	public Pessoa() {
	}
	/**
	 * 
	 * @param nome
	 * @param cpf
	 * @param telefone
	 * @param email
	 */
	public Pessoa(String nome, String cpf, String telefone, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object obj) {
		Pessoa p = (Pessoa) obj;
		if(this.cpf.compareTo(p.getCpf())==0 &&
				this.email.compareTo(p.getEmail())==0 &&
				this.nome.compareTo(p.getNome())==0 &&
				this.telefone.compareTo(p.getTelefone())==0
				) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return nome;
	}

}

