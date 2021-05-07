package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.InterfaceUsuario;
import br.upe.syscond.dao.UsuarioDAO;
import br.upe.syscond.models.Usuario;

public class UsuarioController implements InterfaceUsuarioController{
	
	static InterfaceUsuario userDAO = UsuarioDAO.getInstance();
	
	/**
	 * @param Usuario
	 * @return Usuario || null
	 * @throws Exception 
	 */
	public Usuario criar(Usuario user) throws Exception{
		try {
			return userDAO.salvar(user);
		} catch (Exception eSalvar) {
			throw eSalvar;
		}
	}
	/**
	 * @return Usuario[] || null
	 * @throws Exception 
	 */
	public List<Usuario> listar() throws Exception{
		try {
			return userDAO.listar();
		} catch (Exception eListar) {
			throw eListar;
		}
	}
	/**
	 * @param Usuario
	 * @return Usuario || null
	 * @throws Exception 
	 */
	public Usuario buscar(Usuario user) throws Exception{
		try {
			return userDAO.buscar(user);
		} catch (Exception eBuscar) {
			throw eBuscar;
		}
	}
	/**
	 * @param Usuario
	 * @return Usuario || null
	 * @throws Exception 
	 */
	public Usuario atualizar(Usuario novo) throws Exception{
		try {
			return userDAO.atualizar(novo);
		} catch (Exception eBuscar) {
			throw eBuscar;
		}
	}
	/**
	 * @param Usuario
	 * @return boolean
	 * @throws Exception 
	 */
	public boolean deletar(Usuario user) throws Exception{
		try {
			userDAO.deletar(user);
			return true;
		} catch (Exception eDeletar) {
			throw eDeletar;
		}
	}
}
