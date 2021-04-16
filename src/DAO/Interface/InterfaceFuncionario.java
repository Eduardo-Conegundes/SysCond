/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Models.Funcionario;
import java.util.List;


public interface InterfaceFuncionario {
    Funcionario salvar(Funcionario func) throws Exception;
    List<Funcionario> listar() throws Exception;
    Funcionario buscar(String cpf) throws Exception;
    Funcionario atualizar(Funcionario func) throws Exception;
    void deletar(String cpf) throws Exception;
    
}
