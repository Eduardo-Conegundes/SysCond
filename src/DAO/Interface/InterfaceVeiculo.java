/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Models.Veiculo;
import java.util.List;

/**
 *
 * @author admin
 */
public interface InterfaceVeiculo {
    
	Veiculo salvar(Veiculo c) throws Exception;
    List<Veiculo> listar() throws Exception;
    Veiculo buscar(String placa) throws Exception;
    Veiculo atualizar(Veiculo c) throws Exception;
    void deletar(String placa) throws Exception;
    
}
