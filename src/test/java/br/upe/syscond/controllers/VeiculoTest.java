package br.upe.syscond.controllers;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.upe.syscond.models.Apartamento;
import br.upe.syscond.models.Veiculo;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VeiculoTest {

	static Apartamento apartamento = new ApartamentoController().criar(new Apartamento("A", 202, 1));
	static Veiculo veiculo = new Veiculo("BCT-6969", apartamento);
	static InterfaceVeiculoController controlador = new VeiculoController();

	@Test
	public void t1esteCriarVeiculo(){
		Veiculo criado = null;
		criado = controlador.criar(veiculo);		

		assertNotNull(criado);
	}

	@Test
	public void t2esteListarVeiculo() {

		List<Veiculo> lista = null;
		lista  = controlador.listar();

		assertNotNull(lista);

	}
	
	@Test
	public void t3esteAtualizar() {
		Veiculo atualizacao = new Veiculo("atualizado", apartamento);
		
		atualizacao = controlador.atualizar(veiculo, atualizacao);
		assertNotEquals(0, atualizacao.getId());
		
		veiculo = atualizacao;
	}
	@Test
	public void t4esteDeletar() {
		boolean teste = false;
		
		teste = controlador.deletar(veiculo);
		
		assertTrue(teste);
	}
}
