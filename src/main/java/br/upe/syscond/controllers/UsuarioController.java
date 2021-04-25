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
				System.out.println("E-mail j� cadastrado!");
				return null;
			}
		}

		try {
			userCriado = UsuarioDAO.getInstance().salvar(user);
			System.out.println("Salvo " + userCriado.getEmail() + " com sucesso");
			return userCriado;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao salvar usu�rio!");
			return null;
		}

	}

	public List<Usuario> listar(){
		try {
			List<Usuario> users = UsuarioDAO.getInstance().listar();
			System.out.println("Listar com sucesso: " + users.size());
			return users;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar usu�rio(s)!");
			return null;
		}
	}

	public Usuario buscar(int id){
		Usuario userBuscar= null;
		try {
			userBuscar = UsuarioDAO.getInstance().buscar(id);
			System.out.println("Achado com sucesso: " + userBuscar);
			return userBuscar;
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar usu�rio!");
			return null;
		}
	}

	public Usuario atualizar(int id, Usuario user){
		Usuario userBuscar = null;
		try {
			userBuscar = this.buscar(id);
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar usu�rio!");
			return null;
		}

		if (userBuscar==null) {
			System.out.println("Usu�rio n�o encontrada pelo ID");
			return null;
		}		

		user.setId(userBuscar.getId());

		try {
			Usuario userAtualizado = UsuarioDAO.getInstance().atualizar(user);
			System.out.println("Atualizado com sucesso: " + userAtualizado.getEmail());
			return userAtualizado;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao atualizar usu�rio!");
			return null;
		}
	}

	public void deletar(int id){
		try {
			UsuarioDAO.getInstance().deletar(id);
			System.out.println("Exclu�do com sucesso");
		} catch (Exception e) {
			System.err.println("Erro ao excluir Usuario!");
		}
	}
}
