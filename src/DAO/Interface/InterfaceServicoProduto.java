/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Models.ServicoProduto;
import java.util.List;

/**
 *
 * @author flavi
 */
public interface InterfaceServicoProduto {
    
    void salvar(ServicoProduto sp);
    List listar();
    void atualizar(ServicoProduto sp);
    void deletar(ServicoProduto sp);
    
}
