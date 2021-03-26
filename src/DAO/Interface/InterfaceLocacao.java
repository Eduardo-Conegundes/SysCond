/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Models.Locacao;
import java.util.List;

/**
 *
 * @author flavi
 */
public interface InterfaceLocacao {
    
    void salvar(Locacao l);
    List listar();
    void atualizar(Locacao l);
    void deletar(Locacao l);
    
}
