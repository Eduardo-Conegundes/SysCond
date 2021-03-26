/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Veiculo;
import java.util.List;

/**
 *
 * @author admin
 */
public interface InterfaceVeiculo {
    
    void salvar(Veiculo c);
    List<Veiculo> listar();
    void atualizar(Veiculo c);
    void deletar(Veiculo c);
    
}
