package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.UsuarioDAO;
import br.upe.syscond.models.Usuario;

public class UsuarioController implements InterfaceUsuarioController{

	public Usuario criar(Usuario user){
		Usuario userCriado = null;
		List<Usuario> users = this.listar();

		for (Usuario user2 : users) {
			if(user.getEmail().compareTo(user2.getEmail()) == 0) {
				return null;
			}
		}

		try {
			userCriado = UsuarioDAO.getInstance().salvar(user);
			return userCriado;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao salvar usu�rio!");
			return null;
		}

	}

	public List<Usuario> listar(){
		try {
			List<Usuario> users = UsuarioDAO.getInstance().listar();
			return users;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar usu�rio(s)!");
			return null;
		}
	}

	public Usuario buscar(Usuario user){
		List<Usuario> users = this.listar();
		try {
		for (Usuario user2 : users) {
			if((user.getEmail().compareTo(user2.getEmail()) == 0) && user.getSenha().compareTo(user2.getSenha())==0) {
				return UsuarioDAO.getInstance().buscar(user2.getId());				
			}
		}
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar usu�rio!");
			return null;
		}
		return null;
	}

	public Usuario atualizar(Usuario antigo, Usuario novo){
		try {
			int id = this.buscar(antigo).getId();
			novo.setId(id);
			return UsuarioDAO.getInstance().atualizar(novo);
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar usu�rio!");
			return null;
		}
	}

	public boolean deletar(Usuario user){
		int id = user.getId();
		try {
			UsuarioDAO.getInstance().deletar(id);
			return true;
		} catch (Exception e) {
			System.err.println("Erro ao excluir Usuario!");
			return true;
		}
	}
}
