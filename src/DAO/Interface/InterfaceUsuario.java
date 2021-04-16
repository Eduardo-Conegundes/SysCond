/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Models.Usuario;
import java.util.List;

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
