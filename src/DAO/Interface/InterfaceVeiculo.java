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
    
    void salvar(Veiculo c);
    List<Veiculo> listar();
    Veiculo listarId(int id);
    void atualizar(Veiculo c);
    void deletar(Veiculo c);
    
}
