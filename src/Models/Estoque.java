package Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Estoque implements Serializable {
	
	@Id
	@GeneratedValue(generator = "idEstoque")
	private int id;

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