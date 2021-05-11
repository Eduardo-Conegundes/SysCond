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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApartamentoTest {

	static String bloco = RandomStringUtils.randomAlphabetic(1).toUpperCase();
	static int numero = RandomUtils.nextInt();

	static InterfaceApartamentoController controlador = new ApartamentoController();

	static Apartamento apartamento = new Apartamento(bloco, numero, 2);

	@Test
	public void t1esteCriar() throws Exception{
		Apartamento criado = null;		
		criado = controlador.criar(apartamento);
		int id = criado.getId();

		assertNotNull(criado);
		assertNotNull(id);

		apartamento.setId(id);
	}

	@Test
	public void t2esteListar() throws Exception{
		List<Apartamento> lista = controlador.listar();

		assertNotEquals(0, lista.size());
	}

	@Test
	public void t3esteAtualizar() throws Exception{

		String bloco = "B";
		int numero = 100;
		int vagas = 2;
		

		Apartamento novo = new Apartamento(bloco, numero, vagas);
		novo.setId(apartamento.getId());
		apartamento = controlador.atualizar(novo);
		assertEquals(bloco, apartamento.getBloco());
	}

	@Test
	public void t4esteDeletar() throws Exception {		
	    controlador.deletar(apartamento);
	    assertTrue(true);    
	}
}
