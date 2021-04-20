package br.upe.DAO.Interface;

import java.util.List;

import br.upe.Models.Usuario;

/**
 *
 * @author flavi
 */
public interface InterfaceUsuario {
    
    Usuario salvar(Usuario u) throws Exception;
    List<Usuario> listar() throws Exception;
    Usuario buscar(int id) throws Exception;
    Usuario atualizar(Usuario u) throws Exception;
    void deletar(int id) throws Exception;
    
}
