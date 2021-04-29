package br.upe.syscond.controllers;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import br.upe.syscond.models.Pessoa;



public class PessoaTest {
	Pessoa pessoacriada = new Pessoa("Luiz Augusto", "66666", "666666", "LuizAu@gmail.com");
	PessoaController pessoaCont = new PessoaController();


	@Test
	public void testeCriarPessoa() {
		Pessoa pessoanova = null;
		pessoanova = pessoaCont.criar(pessoacriada);
		assertNotNull(pessoanova);

	}


	@Test
	public void testeAtualizarPessoa() {
		Pessoa pessoamodificada = new Pessoa("Luiz Augusto Alapenha", "66666", "62452346", "LuizAu@gmail.com");
		pessoamodificada = pessoaCont.atualizar(pessoamodificada);


		assertEquals(pessoacriada.getCpf(), pessoamodificada.getCpf());
		assertEquals(pessoacriada.getNome(), pessoamodificada.getNome());
		assertEquals(pessoacriada.getTelefone(), pessoamodificada.getTelefone());
		assertEquals(pessoacriada.getEmail(), pessoamodificada.getEmail());
	}

	@Test
	public void testeListarPessoas() {
		List<Pessoa> listapessoas = pessoaCont.listar();
		assertNotEquals(0, listapessoas.size());

	}

	@Test
	public void testeDeletarPessoas() {
		boolean deletapessoa = pessoaCont.deletar(pessoacriada);
		System.out.println(deletapessoa);
		assertTrue(deletapessoa);
	}

}
