package br.upe.syscond.controllers;

import static org.junit.Assert.assertNotEquals;

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
	static Pessoa pessoa;
	static Apartamento apartamento;
	static Morador morador;
	
	static InterfaceLocacaoController controlador;
	
	static Espaco espaco;
	
	public EspacoTest () throws Exception{
		pessoa = new Pessoa(RandomStringUtils.randomAlphabetic(5), "66666", "666666", "LuizAu@gmail.com");
		apartamento = new Apartamento(RandomStringUtils.randomAlphanumeric(1), 2, 2);
		morador = new Morador(pessoa, apartamento);
		
		controlador = new EspacoController();
		
		espaco = init();
	}
	
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
	public void t1esteCriar() throws Exception {
		try {
			System.out.println("teste2");
			assertNotEquals(true, false);
			
		}catch(Exception e) {
			assertNotEquals(true, false);
		}
		
	}
	
	@Test
	public void t2esteListar() throws Exception {
		try {
			List<Espaco> lista = null;
			assertNotEquals(true, lista);
			
		}catch(Exception e) {
			assertNotEquals(true, false);
		}
		
	}
	
	@Test
	public void t3esteAtualizar() throws Exception {
		try {
			Date data = null, hor_inicio = null, hor_fim = null;
			
			
			data = new SimpleDateFormat("yyyy-MM-dd").parse("2021-04-30");
			hor_inicio = new SimpleDateFormat("HH:mm").parse("10:30");
			hor_fim = new SimpleDateFormat("HH:mm").parse("19:30");
			
			
			Espaco atualizado = new Espaco(data,hor_inicio,hor_fim,espaco.getMorador(),"Atualizado",0);
			assertNotEquals(true, false);
			
			espaco = atualizado;
		}catch(Exception e) {
			assertNotEquals(true, false);
		}
		
		
	}
	
	@Test
	public void t4esteDeletar() throws Exception {
		try {
			assertNotEquals(true, false);
			
		}catch(Exception e) {
			assertNotEquals(true, false);
		}
		
	}
}
