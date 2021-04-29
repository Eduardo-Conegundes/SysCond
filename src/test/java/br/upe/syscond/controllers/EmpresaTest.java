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



public class EmpresaTest {

	ServicoProdutoController Sprod = new ServicoProdutoController();
	ArrayList<ServicoProduto> listaproduto = new ArrayList<ServicoProduto>();
	Empresa empresa = new Empresa("789234", listaproduto, "Jesus Humilha o Satanas", "666666");
	EmpresaController empcont = new EmpresaController();


	@Test
	public void testeCriarEmpresa() {
		Empresa empresaCriada = null;
		ServicoProduto Serv = new ServicoProduto("papel", (float)10.00, empresaCriada, "higienico");
		Sprod.criar(Serv);
		listaproduto.add(Serv);	

		empresaCriada = empcont.criar(empresa);

		assertNotNull(empresaCriada);

	}


	@Test
	public void testeAtualizarEmpresa() {

		Empresa empresamodificada = new Empresa("789234", listaproduto, "HEEFDE", "436676");

		empresamodificada = empcont.atualizar(empresamodificada);

		assertEquals(empresa.getCnpj(), empresamodificada.getCnpj());
		assertNotEquals(empresa.getNome(), empresamodificada.getNome());
		assertNotEquals(empresa.getServicoproduto(), empresamodificada.getServicoproduto());
		assertNotEquals(empresa.getTelefone(), empresamodificada.getTelefone());

	}

	@Test
	public void testeListarEmpresas() {
		List<Empresa> lista = empcont.listar();
		assertNotEquals(0, lista.size());

	}

	@Test
	public void testeDeletarEmpresa() {
		boolean deletaEmpresa = empcont.deletar(empresa);
		System.out.println(deletaEmpresa);
		assertTrue(deletaEmpresa);
	}





}
