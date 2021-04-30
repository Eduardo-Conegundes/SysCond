package br.upe.syscond.controllers;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.upe.syscond.models.Contas;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContabilTest {
	
	static String identificador = RandomStringUtils.randomAlphabetic(5);
	static String pagador = RandomStringUtils.randomAlphabetic(5);
	static String beneficiario = RandomStringUtils.randomAlphabetic(5);
	static float valor = new Random().nextFloat();
	static LocalDate dataEmissao = LocalDate.now();
	static LocalDate dataVencimento = LocalDate.now();
	static Boolean AReceber = true;
	static Boolean statusPaga = true;
	
	InterfaceContabilController controlador = ContabilController.getInstance();
	
	static Contas conta = new Contas(identificador, pagador, beneficiario, valor, dataEmissao, dataVencimento, AReceber, statusPaga);
	static Contas contaAtualizada = new Contas("atualizada", "atualizada" , "atualizada", valor, dataEmissao, dataVencimento, AReceber, statusPaga);

	@Test
	public void t1esteCriar(){
		Contas criada = null;
		criada = controlador.criar(conta);
		assertNotEquals(0, criada.getId());
		conta.setId(criada.getId());
	}
	
	@Test
	public void t2esteListar() {
		List<Contas> lista = null;
		
		lista = controlador.listar();
		
		assertNotNull(lista);
		
	}
	
	@Test
	public void t3esteAtualizar() {
		conta = controlador.atualizar(conta, contaAtualizada);
		
		boolean teste = conta.equals(contaAtualizada);
		
		assertTrue(teste);
		
	}
	
	@Test
	public void t4esteDeletar() {
		boolean teste = controlador.deletar(conta);
		
		assertTrue(teste);
	}

}
