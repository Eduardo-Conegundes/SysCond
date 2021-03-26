/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Models.Estoque;
import java.util.List;

/**
 *
 * @author flavi
 */
public interface InterfaceEstoque {
    void salvar(Estoque est);
    List listar();
    void atualizar(Estoque est);
    void deletar(Estoque est);
    
}
