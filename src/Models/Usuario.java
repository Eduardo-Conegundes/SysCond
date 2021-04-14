package Models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(generator = "idUsuario")
    private int id;
    private String email;
    private String senha;
    private String nivel;
  

    public Usuario() {}


	public Usuario(String email, String senha, String nivel) {
		this.email = email;
		this.senha = senha;
		this.nivel = nivel;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNivel() {
		return nivel;
	}


	public void setNivel(String nivel) {
		this.nivel = nivel;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
    

}
