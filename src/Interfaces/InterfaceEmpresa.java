/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


import Models.Empresa;
import java.util.List;

/**
 *
 * @author admin
 */
public interface InterfaceEmpresa {
    
    void salvar(Empresa e);
    List listar();
    void atualizar(Empresa e);
    void deletar(Empresa e);
    
}
