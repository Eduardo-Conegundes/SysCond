/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Espaco;
import java.util.List;

/**
 *
 * @author admin
 */
public interface InterfaceEspaco {
    
    void salvar(Espaco ep);
    List listar();
    void atualizar(Espaco ep);
    void deletar(Espaco ep);
    
}
