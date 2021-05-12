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
	
	static String identificador;
	static String pagador;
	static String beneficiario;
	static float valor;
	static LocalDate dataEmissao;
	static LocalDate dataVencimento;
	static Boolean AReceber;
	static Boolean statusPaga;
	
	InterfaceContabilController controlador;
	
	static Contas conta;
	static Contas contaAtualizada;

	public ContabilTest () throws Exception{
		identificador = RandomStringUtils.randomAlphabetic(5);
		pagador = RandomStringUtils.randomAlphabetic(5);
		beneficiario = RandomStringUtils.randomAlphabetic(5);
		valor = new Random().nextFloat();
		dataEmissao = LocalDate.now();
		dataVencimento = LocalDate.now();
		AReceber = true;
		statusPaga = true;

		controlador = ContabilController.getInstance();
		
		conta = new Contas(identificador, pagador, beneficiario, valor, dataEmissao, dataVencimento, AReceber, statusPaga);
		contaAtualizada = new Contas("atualizada", "atualizada" , "atualizada", valor, dataEmissao, dataVencimento, AReceber, statusPaga);
	}
	
	@Test
	public void t1esteCriar() throws Exception{
		try {
			Contas criada = null;
			criada = controlador.criar(conta);
			assertNotEquals(0, criada.getId());
			conta.setId(criada.getId());
		}catch(Exception e) {
			throw e;
		}
	}
	
	@Test
	public void t2esteListar() throws Exception{
		try {
			List<Contas> lista = null;
			
			lista = controlador.listar();
			
			assertNotNull(lista);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@Test
	public void t3esteAtualizar() throws Exception{
		try {
			conta = controlador.atualizar(contaAtualizada);
			
			boolean teste = conta.equals(contaAtualizada);
			
			assertTrue(teste);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@Test
	public void t4esteDeletar() throws Exception{
		try {
			controlador.deletar(conta);
		}catch(Exception e) {
			throw e;
		}
		
	}

}
