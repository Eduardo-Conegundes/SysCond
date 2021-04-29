package br.upe.syscond.controllers;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import br.upe.syscond.models.Usuario;


public class UsuarioTest {
	Usuario usuariocriado = new Usuario("LuizAu@gmail.com", "mamacita123", "66");
	UsuarioController userCont = new UsuarioController();

	@Test
	public void testeCriarUsuario() {


		Usuario usernova = null;
		usernova = userCont.criar(usuariocriado);
		int id = usuariocriado.getId();

		assertNotNull(id);
		assertNotNull(usernova);

	}


	@Test
	public void testeAtualizarUsuario() {
		Usuario usuariomodificado = new Usuario("LuizAu@gmail.com", "mamacitapapacito", "690");
		usuariomodificado = userCont.atualizar(usuariocriado, usuariomodificado);


		assertEquals(usuariocriado.getId(), usuariomodificado.getId());
		assertEquals(usuariocriado.getEmail(), usuariomodificado.getEmail());
		assertEquals(usuariocriado.getSenha(), usuariomodificado.getSenha());
		assertEquals(usuariocriado.getNivel(), usuariomodificado.getNivel());

	}

	@Test
	public void testeListarUsuarios() {
		List<Usuario> listaUsers = userCont.listar();
		assertNotEquals(0, listaUsers.size());

	}

	@Test
	public void testeDeletarPessoas() {
		boolean deletaUser = userCont.deletar(usuariocriado);
		System.out.println(deletaUser);
		assertTrue(deletaUser);
	}

}
