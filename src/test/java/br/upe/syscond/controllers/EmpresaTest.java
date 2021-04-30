package br.upe.syscond.controllers;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.upe.syscond.models.Empresa;
import br.upe.syscond.models.ServicoProduto;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpresaTest {
	
	static String cnpj = RandomStringUtils.randomAlphanumeric(5);
	static String telefone = RandomStringUtils.randomAlphanumeric(8);
	static String nome = RandomStringUtils.randomAlphabetic(6).toUpperCase();
	static int numero = RandomUtils.nextInt();
	
	static ArrayList<ServicoProduto> listaprodutos = new ArrayList<ServicoProduto>();
	
	static Empresa empresa = new Empresa(cnpj, listaprodutos, nome, telefone);
	
	static EmpresaController ControllerEmpresa = new EmpresaController();


	@Test
	public void t1esteCriarEmpresa() {
		Empresa empresaCriada = null;

		empresaCriada = ControllerEmpresa.criar(empresa);

		empresa.setId(empresaCriada.getId());
		
		assertNotNull(empresaCriada);
		
	}


	@Test
	public void t2esteAtualizarEmpresa() {
		
		ArrayList<ServicoProduto> listaprodutos2 = new ArrayList<ServicoProduto>();

		Empresa empresamodificada = new Empresa("789234", listaprodutos2, "HEEFDE", "436676");

		empresamodificada = ControllerEmpresa.atualizar(empresa, empresamodificada);
		
		assertNotNull(empresamodificada.getId());

	}

	@Test
	public void t3esteListarEmpresas() {
		List<Empresa> lista = ControllerEmpresa.listar();
		
		assertNotEquals(0, lista.size());
	}

	@Test
	public void t4esteDeletarEmpresa() {
		boolean deletaEmpresa = ControllerEmpresa.deletar(empresa);
		assertTrue(deletaEmpresa);
	}





}
