package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.UsuarioDAO;
import br.upe.syscond.models.Usuario;

public class UsuarioController implements InterfaceUsuarioController{
	/**
	 * @param Usuario
	 * @return Usuario || null
	 */
	public Usuario criar(Usuario user){
		
		if(this.buscar(user) != null) {
			return null;
		}

		try {
			return UsuarioDAO.getInstance().salvar(user);
		} catch (Exception eSalvar) {
			System.err.println("Erro ao salvar usu�rio!");
			return null;
		}

	}
	/**
	 * @return Usuario[] || null
	 */
	public List<Usuario> listar(){
		try {
			List<Usuario> users = UsuarioDAO.getInstance().listar();
			return users;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar usu�rio(s)!");
			return null;
		}
	}
	/**
	 * @param Usuario
	 * @return Usuario || null
	 */
	public Usuario buscar(Usuario user){
		List<Usuario> users = this.listar();

		for (Usuario user2 : users) {
			if(user2.equals(user)) {
				return user2;				
			}
		}
		return null;
	}
	/**
	 * @param Usuario
	 * @return Usuario || null
	 */
	public Usuario atualizar(Usuario novo){
		try {
			
			return UsuarioDAO.getInstance().atualizar(novo);
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar usu�rio!");
			return null;
		}
	}
	/**
	 * @param Usuario
	 * @return boolean
	 */
	public boolean deletar(Usuario user){
		int id = this.buscar(user).getId();
		try {
			UsuarioDAO.getInstance().deletar(id);
			return true;
		} catch (Exception e) {
			System.err.println("Erro ao excluir Usuario!");
			return true;
		}
	}
}
