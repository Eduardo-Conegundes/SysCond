package br.upe.syscond.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import br.upe.syscond.models.Apartamento;
import br.upe.syscond.models.Veiculo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VeiculoTest {

	static String bloco = RandomStringUtils.randomAlphabetic(1).toUpperCase();
	static int numero = RandomUtils.nextInt();

	static InterfaceApartamentoController controladorap = new ApartamentoController();
	static Apartamento apartamento = new Apartamento(bloco, numero, 2);
//	static Apartamento ap = controladorap.criar(apartamento);
	static Veiculo veiculo = new Veiculo("BCT-6969",apartamento);
	static InterfaceVeiculoController controlador = new VeiculoController();

	@Test
	public void t1esteCriarVeiculo() throws Exception{
		Veiculo criado = null;
		criado = controlador.criar(veiculo);		
		assertNotNull(criado);
	}

	@Test
	public void t2esteListarVeiculo() throws Exception {

		List<Veiculo> lista = null;
		lista  = controlador.listar();

		assertNotNull(lista);

	}
	
	@Test
	public void t3esteAtualizar() throws Exception{
		Veiculo atualizacao = new Veiculo("atualizado", apartamento);
		atualizacao.setId(veiculo.getId());
		veiculo = controlador.atualizar(atualizacao);
		assertEquals(atualizacao.getPlaca(), apartamento.getBloco());
	}
	@Test
	public void t4esteDeletar() throws Exception {
	    controlador.deletar(veiculo);
	    assertTrue(true);  
	}
}
