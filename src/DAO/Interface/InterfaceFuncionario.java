/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Models.Funcionario;
import java.util.List;

/**
 *
 * @author admin
 */
public interface InterfaceFuncionario {
    void salvar(Funcionario func);
    List listar();
    void atualizar(Funcionario func);
    void deletar(Funcionario func);
    
}
