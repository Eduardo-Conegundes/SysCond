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

	static ApartamentoController controlador = new ApartamentoController();

	static Apartamento apartamento = new Apartamento(bloco, numero, 2);

	@Test
	public void t1esteCriar() {
		Apartamento criado = null;		
		criado = controlador.criar(apartamento);
		int id = criado.getId();
		
		assertNotNull(criado);
		assertNotNull(id);
		
		apartamento.setId(id);
	}
	
	@Test
	public void t2esteListar() {
		List<Apartamento> lista = controlador.listar();
		//lista não pode ser vazia
		assertNotEquals(0, lista.size());
	}
	
	@Test
	public void t3esteAtualizar() {
		
		String bloco = "c";
		int numero = 100;
		int vagas = 2;
		
		Apartamento novo = new Apartamento(bloco, numero, vagas);
		
		novo = controlador.atualizar(apartamento, novo);
		
		assertEquals(apartamento.getId(), novo.getId());
		
	}
	
	@Test
	public void t4esteDeletar() {
		boolean teste = false;
		teste = controlador.deletar(apartamento);
		assertTrue(teste);
	}
}
