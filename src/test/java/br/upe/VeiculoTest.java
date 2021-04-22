/**
 * 
 */
package br.upe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import br.upe.Controllers.ApartamentoController;
import br.upe.Controllers.VeiculoController;
import br.upe.Models.Apartamento;
import br.upe.Models.Veiculo;

public class VeiculoTest {

	@Test
	public void CriarVeiculo(){
		Apartamento apt = new Apartamento("A", 202, 1);
		Veiculo veiculo = new Veiculo("BCT-6969", apt);
		Veiculo veiculoCriado = null;
		VeiculoController veiCont = new VeiculoController();
		ApartamentoController aptCont = new ApartamentoController();
		
		aptCont.criar(apt);		
		veiculoCriado = veiCont.criar(veiculo);
		
		assertNotNull(veiculoCriado);
	}
	
	@Test
	public void ListarVeiculo() {
		VeiculoController veiCont = new VeiculoController();
		List<Veiculo> veiculosListados = veiCont.listar();
		
	}
}
