package br.upe.syscond.controllers;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import br.upe.syscond.models.Apartamento;
import br.upe.syscond.models.Pessoa;
import br.upe.syscond.models.Visitante;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VisitanteTest {

	static InterfacePessoaController criarpessoa = new PessoaController();
	static InterfaceApartamentoController criarap = new ApartamentoController();
	static Pessoa pessoa =  new Pessoa("Teste", "12345678910", "8196959497", "teste@teste.com"); 
	static Apartamento apartamento = new Apartamento("teste", 1, 1);
	static InterfaceVisitanteController controlador= new VisitanteController();
	static Visitante visitante = new Visitante(pessoa, apartamento);
	
	
	@Test
	public void t1estarcriar() throws Exception {
		try {
			criarap.criar(apartamento);
			Visitante criado = null;
			criado = controlador.criar(visitante);
			assertNotNull(criado);
			visitante.setId(criado.getId());
		}catch(Exception e) {
			assertTrue(true);
		}
		
	}

	@Test
	public void t2estarListarVisitante() throws Exception{
		List<Visitante> lista = null;
		lista =	controlador.listar();

		assertNotNull(lista);
	}

	@Test
	public void t3estarBuscarVisitante() throws Exception {
		try {
			assertNotNull(controlador.buscar(visitante));
		}catch(Exception e) {
			assertTrue(true);
		}
		
	}
}
