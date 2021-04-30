package br.upe.syscond.controllers;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.upe.syscond.models.Apartamento;
import br.upe.syscond.models.Espaco;
import br.upe.syscond.models.Morador;
import br.upe.syscond.models.Pessoa;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EspacoTest {
	static Pessoa pessoa = new PessoaController().criar(new Pessoa(RandomStringUtils.randomAlphabetic(5), "66666", "666666", "LuizAu@gmail.com"));
	static Apartamento apartamento = new ApartamentoController().criar(new Apartamento(RandomStringUtils.randomAlphanumeric(1), 2, 2));
	static Morador morador = new MoradorController().criar(new Morador(pessoa, apartamento));
	
	static InterfaceLocacaoController controlador = new EspacoController();
	
	static Espaco espaco = init();
	
	private static Espaco init(){
		try {
			Date data = null, hor_inicio = null, hor_fim = null;
			data = new SimpleDateFormat("yyyy-MM-dd").parse("2021-04-30");
			hor_inicio = new SimpleDateFormat("HH:mm").parse("14:30");
			hor_fim = new SimpleDateFormat("HH:mm").parse("17:30");
			
			return new Espaco(data, hor_inicio, hor_fim, morador, "salao", 0);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Test
	public void t1esteCriar() throws ParseException {
		System.out.println("teste2");
		EspacoTest.espaco = controlador.criar(espaco);
		assertNotEquals(0, espaco.getId());
	}
	
	@Test
	public void t2esteListar() {
		List<Espaco> lista = null;
		
		lista = controlador.listar();
		
		assertNotNull(lista);
	}
	
	@Test
	public void t3esteAtualizar() {
		
		Date data = null, hor_inicio = null, hor_fim = null;
		
		try {
			data = new SimpleDateFormat("yyyy-MM-dd").parse("2021-04-30");
			hor_inicio = new SimpleDateFormat("HH:mm").parse("10:30");
			hor_fim = new SimpleDateFormat("HH:mm").parse("19:30");
		} catch (ParseException e) {
		}
		
		Espaco atualizado = new Espaco(data,hor_inicio,hor_fim,espaco.getMorador(),"Atualizado",0);
		
		atualizado = controlador.atualizar(espaco, atualizado);
		
		assertNotEquals(0, atualizado.getId());
		espaco = atualizado;
	}
	
	@Test
	public void t4esteDeletar() {
		boolean teste = false;
		teste = controlador.deletar(espaco);
		assertTrue(teste);
	}
}
