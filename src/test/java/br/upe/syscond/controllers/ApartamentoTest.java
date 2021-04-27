package br.upe.syscond.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import br.upe.syscond.models.Apartamento;

public class ApartamentoTest {

	static String bloco = RandomStringUtils.randomAlphabetic(1).toUpperCase();
	static int numero = RandomUtils.nextInt();

	static ApartamentoController controlador = new ApartamentoController();

	static Apartamento apartamento = new Apartamento(bloco, numero, 2);

	@Test
	public void testeCriar() {
		Apartamento criado = null;		
		criado = controlador.criar(apartamento);
		int id = criado.getId();

		assertNotNull(criado);
		assertNotNull(id);

	}
	
	@Test
	public void testeListar() {
		List<Apartamento> lista = controlador.listar();
		
		//lista não pode ser vazia
		assertNotEquals(0, lista.size());
	}
	
	@Test
	public void testeAtualizar() {
		Apartamento novo = new Apartamento("c", 100, 2);
		
		novo = controlador.atualizar(apartamento, novo);
				
		assertEquals(apartamento.getId(), novo.getId());
		assertNotEquals(apartamento.getBloco(), novo.getBloco());
		assertNotEquals(apartamento.getNumero(), novo.getNumero());
		
	}
	
	@Test
	public void testeDeletar() {
		boolean teste = controlador.deletar(apartamento);
		System.out.println(teste);
		assertTrue(teste);
	}
}
