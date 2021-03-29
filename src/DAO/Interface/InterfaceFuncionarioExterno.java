/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Models.FuncionarioExterno;
import java.util.List;

/**
 *
 * @author flavi
 */
public interface InterfaceFuncionarioExterno {
    void salvar(FuncionarioExterno fe);
    List listar();
    FuncionarioExterno listarId(int id);
    void atualizar(FuncionarioExterno fe);
    void deletar(FuncionarioExterno fe);
}
