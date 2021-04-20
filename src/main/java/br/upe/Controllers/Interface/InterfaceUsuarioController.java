package br.upe.Controllers.Interface;

import java.util.List;

import br.upe.Models.Usuario;

public interface InterfaceUsuarioController {
	public Usuario criar(Usuario user);
	public List<Usuario> listar();
	public Usuario buscar(int id);
	public Usuario atualizar(int id, Usuario user);
	public void deletar(int id);

}
