/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Models.Espaco;
import java.util.List;

/**
 *
 * @author flavi
 */
public interface InterfaceLocacao {
    
    Espaco salvar(Espaco l) throws Exception;
    List<Espaco> listar() throws Exception;
    Espaco buscar(int id) throws Exception;
    Espaco atualizar(Espaco l) throws Exception;
    void deletar(int id) throws Exception;
    
}
