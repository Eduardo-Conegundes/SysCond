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
    
	ServicoProduto salvar(ServicoProduto sp) throws Exception;
    List<ServicoProduto> listar() throws Exception;
    ServicoProduto buscar(int id) throws Exception;
    ServicoProduto atualizar(ServicoProduto sp) throws Exception;
    void deletar(int id) throws Exception;
    
}
