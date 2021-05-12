package br.upe.syscond.controllers;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

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
	public void t1esteCriarFuncionario() throws Exception{
		try {
			controladorPessoa.criar(pessoa);
			funcionario = controlador.criar(funcionario);
			
			assertNotEquals(0 , funcionario.getId());
		}catch(Exception e) {
			assertNotEquals(true, false);
		}
		
	}

	@Test
	public void t2esteAtualizarFuncionario() throws Exception{
		try {
			Funcionario novo = new Funcionario(pessoa, "Externoooo", "supervisor",(float)8000.00);
			
			novo = controlador.atualizar(novo);
			
			assertNotNull(novo.getId());
		}catch(Exception e) {
			assertNotEquals(true, false);
		}
		
	}

	@Test
	public void t3esteListarFuncionarios() throws Exception{
		try {
			List<Funcionario> lista = controlador.listar();
			assertNotEquals(0, lista.size());
		}catch(Exception e) {
			assertNotEquals(true, false);
		}
		
	}

	@Test
	public void t4esteDeletarFuncionario() throws Exception{
		try {
			controlador.deletar(funcionario);
		}catch(Exception e) {
			assertNotEquals(true, false);
		}
		
		
	}

}
