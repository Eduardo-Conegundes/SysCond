package Models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Estoque implements Serializable {
	
	@Id
	private int id;

	@OneToMany
	private FluxoEstoque estoque;

	public Estoque() {
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
	 * @return the estoque
	 */
	public FluxoEstoque getEstoque() {
		return estoque;
	}

	/**
	 * @param estoque the estoque to set
	 */
	public void setEstoque(FluxoEstoque estoque) {
		this.estoque = estoque;
	}

}