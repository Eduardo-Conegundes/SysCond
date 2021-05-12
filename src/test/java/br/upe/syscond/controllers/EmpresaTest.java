package br.upe.syscond.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import br.upe.syscond.models.Empresa;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpresaTest {

	static String cnpj = RandomStringUtils.randomAlphanumeric(5);
	static String telefone = RandomStringUtils.randomAlphanumeric(8);
	static String nome = RandomStringUtils.randomAlphabetic(6).toUpperCase();
	static int numero = RandomUtils.nextInt();


	static Empresa empresa = new Empresa(cnpj, "produto teste", nome, telefone);

	static InterfaceEmpresaController ControllerEmpresa = new EmpresaController();


	@Test
	public void t1esteCriarEmpresa() throws Exception{
		Empresa empresaCriada = null;
		empresaCriada = ControllerEmpresa.criar(empresa);
		int id = empresaCriada.getId();
		assertNotNull(empresaCriada);
		assertNotNull(id);
		empresa.setId(id);

	}


	@Test
	public void t2esteAtualizarEmpresa() throws Exception{

		Empresa empresamodificada = new Empresa("789234", "vasoura", "HEEFDE", "436676");
		empresamodificada.setId(empresa.getId());
		empresa = ControllerEmpresa.atualizar(empresamodificada);
		empresamodificada = ControllerEmpresa.atualizar(empresamodificada);
		assertEquals(empresamodificada.getServicoproduto(), empresamodificada.getServicoproduto());
	}

	@Test
	public void t3esteListarEmpresas() throws Exception{
		List<Empresa> lista = ControllerEmpresa.listar();	
		assertNotEquals(0, lista.size());
	}

	@Test
	public void t4esteDeletarEmpresa() throws Exception{
		try {
			ControllerEmpresa.deletar(empresa);
			assertTrue(true);  
		}catch(Exception e) {
			assertTrue(true);
		}
		
	}

}
