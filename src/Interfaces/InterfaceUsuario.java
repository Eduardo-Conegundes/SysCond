/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Morador;
import Models.Usuario;
import java.util.List;

/**
 *
 * @author flavi
 */
public interface InterfaceUsuario {
    
    void salvar(Usuario u);
    List listar();
    void atualizar(Usuario u);
    void deletar(Usuario u);
    
}
