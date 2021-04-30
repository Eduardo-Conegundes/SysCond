package br.upe.syscond.controllers;


import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.upe.syscond.models.Pessoa;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PessoaTest {
	static Pessoa pessoa = new Pessoa(RandomStringUtils.randomAlphabetic(8).toUpperCase(), "66666", "666666", "LuizAu@gmail.com");
	static PessoaController controlador = new PessoaController();


	@Test
	public void t1esteCriarPessoa() {
		Pessoa pessoanova = null;
		pessoanova = controlador.criar(pessoa);
		assertNotNull(pessoanova);
	}


	@Test
	public void t2esteAtualizarPessoa() {
		Pessoa pessoamodificada = new Pessoa("Luiz Augusto Alapenha", "66666", "62452346", "LuizAu@gmail.com");
		pessoamodificada = controlador.atualizar(pessoa, pessoamodificada);
		
		assertNotEquals(0, pessoamodificada.getId());
		pessoa = pessoamodificada;
	}

	@Test
	public void t3esteListarPessoas() {
		List<Pessoa> listapessoas = null;
		listapessoas = controlador.listar();
		assertNotNull(listapessoas);

	}

	@Test
	public void t4esteDeletarPessoas() {
		boolean teste = false;
		teste = controlador.deletar(pessoa);
		assertTrue(teste);
	}

}
