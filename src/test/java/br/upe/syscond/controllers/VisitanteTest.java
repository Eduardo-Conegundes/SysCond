package br.upe.syscond.controllers;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.upe.syscond.models.Apartamento;
import br.upe.syscond.models.Pessoa;
import br.upe.syscond.models.Visitante;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VisitanteTest {

	static Pessoa pessoa = new PessoaController().criar(new Pessoa("Teste", "12345678910", "8196959497", "teste@teste.com"));
	static Apartamento apartamento = new ApartamentoController().criar(new Apartamento("teste", 1, 1));
	static Visitante visitante = new Visitante(pessoa,apartamento);

	static InterfaceVisitanteController controlador = new VisitanteController();

	@Test
	public void t1estarcriar() {
		Visitante criado = null;
		criado = controlador.criar(visitante);
		assertNotNull(criado);
		visitante.setId(criado.getId());
	}

	@Test
	public void t2estarListarVisitante() {
		List<Visitante> lista = null;
		lista =	controlador.listar();

		assertNotNull(lista);
	}

	@Test
	public void t3estarBuscarVisitante() {
		Visitante nao_encontrar = new Visitante(null,null);
		assertNull(controlador.buscar(nao_encontrar));
		assertNotNull(controlador.buscar(visitante));
	}
}
