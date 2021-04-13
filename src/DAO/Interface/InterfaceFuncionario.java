/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Models.Funcionario;
import java.util.List;


public interface InterfaceFuncionario {
    Funcionario salvar(Funcionario func);
    List<Funcionario> listar();
    Funcionario buscar(String cpf);
    Funcionario atualizar(String cpf);
    void deletar(String cpf);
    
}
