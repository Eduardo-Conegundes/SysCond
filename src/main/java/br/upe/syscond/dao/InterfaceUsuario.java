package br.upe.syscond.dao;

import java.util.List;

import br.upe.syscond.models.Usuario;

public interface InterfaceUsuario {
    
    Usuario salvar(Usuario u) throws Exception;
    List<Usuario> listar() throws Exception;
    Usuario buscar(int id) throws Exception;
    Usuario buscar(Usuario u) throws Exception;
    Usuario atualizar(Usuario u) throws Exception;
    void deletar(Usuario user) throws Exception;
    
}
