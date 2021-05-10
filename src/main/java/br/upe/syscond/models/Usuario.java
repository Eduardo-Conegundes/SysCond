package br.upe.syscond.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@SuppressWarnings("serial")
@Entity
public class Usuario implements Serializable {
    
    @Id @GeneratedValue(generator = "idUsuario")
    private int id;
    @Column(unique=true)
    private String email;
    @Column
    private String senha;

    public Usuario() {}

    /**
     * 
     * @param email
     * @param senha
     */
	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}
	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 
	 * @return senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * 
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	/**
	 * @param obj
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(senha, other.senha);
	}
	
}
