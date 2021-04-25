package br.upe.syscond;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.upe.syscond.controllers.ApartamentoController;
import br.upe.syscond.models.Apartamento;

public class ApartamentoTest {
	
	@Test
	public void testeCriar() {
		ApartamentoController apcont = new ApartamentoController();
		Apartamento ap = new Apartamento("B", 202, 2);
		Apartamento criado = null;		
		
		criado = apcont.criar(ap);
		int id = criado.getId();
		
		assertNotNull(criado);
		assertNotNull(id);
		
		
	}
}
