package br.upe.syscond.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import br.upe.syscond.models.Funcionario;
import br.upe.syscond.models.Pessoa;



public class FuncionarioTest {

	Pessoa pessoa = new Pessoa("Luiz Augusto", "66666", "666666", "LuizAu@gmail.com");
	PessoaController pessoaCont = new PessoaController();
	FuncionarioController funciocont = new FuncionarioController();
	Funcionario funcionariocriado = new Funcionario(pessoa, "interno", "superviso",(float)8000.00);


	@Test
	public void testeCriarEmpresa() {
		Funcionario funcionarionovo = null;

		pessoaCont.criar(pessoa);

		funcionarionovo = funciocont.criar(funcionariocriado);

		assertNotNull(funcionarionovo);

	}


	@SuppressWarnings("deprecation")
	@Test
	public void testeAtualizarEmpresa() {
		Funcionario funcionariomodificado = new Funcionario(pessoa, "Externoooo", "superviso",(float)8000.00);
		funcionariomodificado = funciocont.atualizar(funcionariomodificado);


		assertEquals(funcionariocriado.getPessoa(), funcionariomodificado.getPessoa());
		assertEquals(funcionariocriado.getInterno_externo(), funcionariomodificado.getInterno_externo());
		assertEquals(funcionariocriado.getCargo(), funcionariomodificado.getCargo());
		assertEquals(funcionariocriado.getSalario(), funcionariomodificado.getSalario());


	}

	@Test
	public void testeListarFuncionarios() {
		List<Funcionario> lista = funciocont.listar();
		assertNotEquals(0, lista.size());

	}

	@Test
	public void testeDeletarFuncionario() {
		boolean deletaFuncionario = funciocont.deletar(funcionariocriado);
		System.out.println(deletaFuncionario);
		assertTrue(deletaFuncionario);
	}

}
