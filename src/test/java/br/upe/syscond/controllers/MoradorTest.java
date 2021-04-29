package br.upe.syscond.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import br.upe.syscond.models.Apartamento;
import br.upe.syscond.models.Morador;
import br.upe.syscond.models.Pessoa;


public class MoradorTest {

	static String bloco = RandomStringUtils.randomAlphabetic(1).toUpperCase();
	static int numero = RandomUtils.nextInt();

	static ApartamentoController apcont = new ApartamentoController();
	static PessoaController pessoacont = new PessoaController();

	static Apartamento apartamento = new Apartamento(bloco, numero, 3);
	static Pessoa pessoa = new Pessoa("Luiz Augusto", "66666", "666666", "LuizAu@gmail.com");

	MoradorController moradorcont = new MoradorController();

	Morador Moradorcriado = new Morador(pessoa, apartamento);




	@Test
	public void testeCriarMorador() {
		apcont.criar(apartamento);
		pessoacont.criar(pessoa);

		Morador morador = null;		
		morador = moradorcont.criar(morador);
		assertNotNull(morador);

	}


	//Eu tenhop quase certezza que isso está ERRRARDOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
	@Test
	public void testeAtualizarMorador() {

		Apartamento novoAP = new Apartamento("B", 50, 3);
		Morador moradorNovo = new Morador(pessoa, novoAP);
		moradorNovo = moradorcont.atualizar(moradorNovo);

		//## OU ISSOOO
		assertEquals(Moradorcriado.getApartamento().getBloco(), moradorNovo.getApartamento().getBloco());
		assertEquals(Moradorcriado.getApartamento().getNumero(), moradorNovo.getApartamento().getNumero());
		assertEquals(Moradorcriado.getApartamento().getId(), moradorNovo.getApartamento().getId());

		assertEquals(Moradorcriado.getPessoa().getCpf(), moradorNovo.getPessoa().getCpf());
		assertEquals(Moradorcriado.getPessoa().getNome(), moradorNovo.getPessoa().getNome());
		assertEquals(Moradorcriado.getPessoa().getTelefone(), moradorNovo.getPessoa().getTelefone());
		assertEquals(Moradorcriado.getPessoa().getEmail(), moradorNovo.getPessoa().getEmail());

		//## OU ISSOOO

		//	assertEquals(Moradorcriado.getApartamento(), moradorNovo.getApartamento());
		//	assertEquals(Moradorcriado.getPessoa(), moradorNovo.getPessoa());

	}


	@Test
	public void testeListarMoradores() {
		List<Morador> listamoradores = moradorcont.listar();
		assertNotEquals(0, listamoradores.size());
	}


	@Test
	public void testeDeletarmorador() {
		boolean moradordeletado = moradorcont.deletar(Moradorcriado);
		System.out.println(moradordeletado);
		assertTrue(moradordeletado);
	}
}

