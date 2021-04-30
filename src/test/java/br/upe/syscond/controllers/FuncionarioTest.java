package br.upe.syscond.controllers;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.upe.syscond.models.Funcionario;
import br.upe.syscond.models.Pessoa;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FuncionarioTest {
	static String nome = RandomStringUtils.randomAlphabetic(5);
	static String cpf = RandomStringUtils.randomAlphabetic(5);
	static String telefone = RandomStringUtils.randomAlphabetic(5);
	static String email = RandomStringUtils.randomAlphabetic(5);
	
	static Pessoa pessoa = new Pessoa(nome, cpf, telefone, email);
	static InterfacePessoaController controladorPessoa = new PessoaController();
	
	static Funcionario funcionario = new Funcionario(pessoa, "interno", "supervisor",(float)8000.00);
	static InterfaceFuncionarioController controlador = new FuncionarioController();
	
	@Test
	public void t1esteCriarFuncionario() {
		controladorPessoa.criar(pessoa);
		funcionario = controlador.criar(funcionario);
		
		assertNotEquals(0 , funcionario.getId());
	}

	@Test
	public void t2esteAtualizarFuncionario() {
		Funcionario novo = new Funcionario(pessoa, "Externoooo", "supervisor",(float)8000.00);
		
		novo = controlador.atualizar(funcionario, novo);
		
		assertNotNull(novo.getId());
	}

	@Test
	public void t3esteListarFuncionarios() {
		List<Funcionario> lista = controlador.listar();
		assertNotEquals(0, lista.size());
	}

	@Test
	public void t4esteDeletarFuncionario() {
		boolean deletaFuncionario = controlador.deletar(funcionario);
		
		assertTrue(deletaFuncionario);
	}

}
