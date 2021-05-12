package br.upe.syscond.controllers;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.upe.syscond.models.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioTest {
	static Usuario usuario = new Usuario("emailteste", "senhateste");
	UsuarioController controlador = new UsuarioController();
	Usuario user = null;
	
	@Test
	public void t1esteCriarUsuario() throws Exception{
		try {
			user = controlador.criar(usuario);
			assertNotNull(user);
		}catch(Exception e) {
			throw e;
		}
	}

	@Test
	public void t2esteAtualizarUsuario() throws Exception{
		try {
			user = null;
			user = controlador.criar(usuario);
			Usuario userAux = user;
			user.setEmail("alterado");
			Usuario modificado = controlador.atualizar(user);

			assertEquals(userAux.getId(), modificado.getId());
			usuario = modificado;
		}catch(Exception e) {
			throw e;
		}
	}

	@Test
	public void t3esteListarUsuarios() throws Exception{
		try {
			List<Usuario> lista = null;
			lista = controlador.listar();
			assertNotNull(lista);
		}catch(Exception e) {
			throw e;
		}
	}

	@Test
	public void t4esteDeletarPessoas() throws Exception{
		try {
			boolean teste = false;
			teste = controlador.deletar(usuario);
			assertTrue(teste);
		}catch(Exception e) {
			throw e;
		}
		
	}

}
