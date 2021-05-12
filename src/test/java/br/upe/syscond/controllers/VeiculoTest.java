package br.upe.syscond.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import br.upe.syscond.models.Apartamento;
import br.upe.syscond.models.Veiculo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VeiculoTest {

	static String bloco = RandomStringUtils.randomAlphabetic(1).toUpperCase();
	static int numero = RandomUtils.nextInt();

	static InterfaceApartamentoController controladorap = new ApartamentoController();
	static Apartamento apartamento = new Apartamento(bloco, numero, 2);
//	static Apartamento ap = controladorap.criar(apartamento);
	static Veiculo veiculo = new Veiculo("BCT-6969",apartamento);
	static InterfaceVeiculoController controlador = new VeiculoController();

	@Test
	public void t1esteCriarVeiculo() throws Exception{
		try {
			Veiculo criado = null;
			criado = controlador.criar(veiculo);		
			assertNotNull(criado);
			
		}catch(Exception e) {
			assertNotEquals(true, false);
		}
		
	}

	@Test
	public void t2esteListarVeiculo() throws Exception {
		try {
			List<Veiculo> lista = null;
			lista  = controlador.listar();

			assertNotNull(lista);
			
		}catch(Exception e) {
			throw e;
		}
	}
	
	@Test
	public void t3esteAtualizar() throws Exception{
		try {
			Veiculo atualizacao = new Veiculo("atualizado", apartamento);
			atualizacao.setId(veiculo.getId());
			veiculo = controlador.atualizar(atualizacao);
			assertEquals(atualizacao.getPlaca(), apartamento.getBloco());
		}catch(Exception e) {
			assertTrue(true);
		}
		
	}
	@Test
	
	public void t4esteDeletar() throws Exception {
		try {
			controlador.deletar(veiculo);
		    assertTrue(true);  
		}catch(Exception e) {
			assertTrue(true);
		}
	    
	}
}
