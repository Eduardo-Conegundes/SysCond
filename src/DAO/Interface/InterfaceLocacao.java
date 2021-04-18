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
    
    Locacao salvar(Locacao l) throws Exception;
    List<Locacao> listar() throws Exception;
    Locacao buscar(int id) throws Exception;
    Locacao atualizar(Locacao l) throws Exception;
    void deletar(int id) throws Exception;
    
}
