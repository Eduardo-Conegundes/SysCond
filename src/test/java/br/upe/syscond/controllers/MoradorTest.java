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

	static String bloco = RandomStringUtils.randomAlphabetic(1).toUpperCase();
	static int numero = RandomUtils.nextInt();
	static Apartamento apartamento = new ApartamentoController().criar(new Apartamento(bloco, numero, 3));

	static Pessoa pessoa = new PessoaController().criar(new Pessoa(RandomStringUtils.randomAlphabetic(8).toUpperCase(), "66666", "666666", "LuizAu@gmail.com"));

	static Morador morador = new Morador(pessoa, apartamento);

	static MoradorController controlador = new MoradorController();

	@Test
	public void t1esteCriarMorador() {
		Morador criado = null;		
		criado = controlador.criar(morador);
		assertNotNull(criado);
	}

	@Test
	public void t2esteAtualizarMorador() {
		Apartamento apartamento2 = new ApartamentoController().criar(new Apartamento("Atualizado", 1, 6));
		Morador atualizado = new Morador(pessoa, apartamento2);

		atualizado = controlador.atualizar(morador, atualizado);

		assertNotEquals(0, atualizado.getId());
		morador = atualizado;
	}


	@Test
	public void t3esteListarMoradores() {
		List<Morador> lista = null;
		lista = controlador.listar();
		assertNotNull(lista);
	}


	@Test
	public void t4esteDeletarmorador() {
		boolean teste = false; 

		teste = controlador.deletar(morador);

		assertTrue(teste);
	}
}

