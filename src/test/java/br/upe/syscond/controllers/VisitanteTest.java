package br.upe.syscond.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;
import java.util.Random;

import org.junit.Test;

import br.upe.syscond.models.Apartamento;
import br.upe.syscond.models.Pessoa;
import br.upe.syscond.models.Visitante;

public class VisitanteTest {

	@Test
	public void TestarVisitante() {

		String str = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		StringBuffer sb=new StringBuffer();
		Random random = new Random();

		for (int i=0;i<16;++i)
			sb.append(str.charAt(random.nextInt(16)));

		String cpf = sb.toString();


		Apartamento apt = new Apartamento("Teste", 202, 1);
		apt.setId(1);
		Pessoa pessoa = new Pessoa("Teste", cpf, "81993939393", "flavio@email.com.br");
		InterfaceVisitanteController visitCont = new VisitanteController();
		Visitante idBancoVisitante = visitCont.criar(pessoa, apt);

		assertEquals(cpf, idBancoVisitante.getPessoa().getCpf());

	}

	@Test
	public void TestarListarVisitante() {
		InterfaceVisitanteController visitCont = new VisitanteController();
		List<Visitante> listaVisitante = visitCont.listar();

		assertNotEquals(0,listaVisitante.size());
	}

	@Test
	public void TestarBuscarVisitante() {
		InterfaceVisitanteController visitCont = new VisitanteController();
		String nomeVisitante = "Flavio";
		Visitante visitante = visitCont.buscar("299.299.299-20");

		assertEquals(nomeVisitante, visitante.getPessoa().getNome());
	}
}
