package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.models.Usuario;

public interface InterfaceUsuarioController {
	public Usuario criar(Usuario user) throws Exception;
	public List<Usuario> listar() throws Exception;
	public Usuario buscar(Usuario user) throws Exception;
	public Usuario atualizar(Usuario novo) throws Exception;
	public boolean deletar(Usuario user) throws Exception;

}
