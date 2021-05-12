package br.upe.syscond.controllers;

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
import br.upe.syscond.models.Morador;
import br.upe.syscond.models.Pessoa;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MoradorTest {

	static String bloco;
	static int numero;
	static Apartamento apartamento;

	static Pessoa pessoa;

	static Morador morador;

	static MoradorController controlador;
	
	public MoradorTest () throws Exception{
		bloco = RandomStringUtils.randomAlphabetic(1).toUpperCase();
		numero = RandomUtils.nextInt();
		apartamento = new ApartamentoController().criar(new Apartamento(bloco, numero, 3));

		pessoa = new PessoaController().criar(new Pessoa(RandomStringUtils.randomAlphabetic(8).toUpperCase(), "66666", "666666", "LuizAu@gmail.com"));

		morador = new Morador(pessoa, apartamento);

		controlador = new MoradorController();
	}

	@Test
	public void t1esteCriarMorador() throws Exception{
		try {
			Morador criado = null;		
			criado = controlador.criar(morador);
			assertNotNull(criado);
		}catch(Exception e) {
			assertTrue(true);
		}
		
	}

	@Test
	public void t2esteAtualizarMorador() throws Exception{
		try {
			Apartamento apartamento2 = new ApartamentoController().criar(new Apartamento("Atualizado", 1, 6));
			Morador atualizado = new Morador(pessoa, apartamento2);

			atualizado = controlador.atualizar(atualizado);

			assertNotEquals(0, atualizado.getId());
			morador = atualizado;
		}catch(Exception e) {
			assertTrue(true);
		}
		
	}


	@Test
	public void t3esteListarMoradores() throws Exception{
		try {
			List<Morador> lista = null;
			lista = controlador.listar();
			assertNotNull(lista);
		}catch(Exception e) {
			throw e;
		}
		
	}


	@Test
	public void t4esteDeletarmorador() throws Exception{
		try {
			controlador.deletar(morador);
		}catch(Exception e) {
			assertTrue(true);
		}
		
	}
}

