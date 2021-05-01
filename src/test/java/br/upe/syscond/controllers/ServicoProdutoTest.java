package br.upe.syscond.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.upe.syscond.models.Empresa;
import br.upe.syscond.models.ServicoProduto;

public class ServicoProdutoTest {
	ServicoProdutoController Serprod = new ServicoProdutoController();
	ArrayList<ServicoProduto> listaproduto = new ArrayList<ServicoProduto>();
	Empresa empresa = new Empresa("789234", listaproduto, "Jesus Humilha o Satanas", "666666");
	EmpresaController empcont = new EmpresaController();
	ServicoProduto servicoProdCriado = new ServicoProduto("papel", (float)10.00, empresa, "higienico");


	//@Test
	public void testeCriarSerProd() {
		
		empcont.criar(empresa);
		ServicoProduto SerProdCriada = null;
		listaproduto.add(servicoProdCriado);	
		SerProdCriada = Serprod.criar(servicoProdCriado);

		assertNotNull(SerProdCriada);

	}


	//@Test
	public void testeAtualizarSerProd() {

		ServicoProduto ServProdModificada = new ServicoProduto("papel", (float)10.00, empresa, "crepom");
		ServProdModificada = Serprod.atualizar(ServProdModificada);

		assertEquals(servicoProdCriado.getId(), ServProdModificada.getId());
		assertEquals(servicoProdCriado.getNome(), ServProdModificada.getNome());
		assertEquals(servicoProdCriado.getValor(), ServProdModificada.getValor());
		assertEquals(servicoProdCriado.getCategoria(), ServProdModificada.getCategoria());

	}

	//@Test
	public void testeListarSersProds() {
		List<ServicoProduto> listaServicoProduto = Serprod.listar();
		assertNotEquals(0, listaServicoProduto.size());

	}

	//@Test
	public void testeDeletarSerProd() {
		boolean deletaSerProd = Serprod.deletar(servicoProdCriado);
		System.out.println(deletaSerProd);
		assertTrue(deletaSerProd);
	}

}
