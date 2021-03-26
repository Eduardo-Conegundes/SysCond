/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Morador;
import Models.Visitante;
import java.util.List;

/**
 *
 * @author flavi
 */
public interface InterfaceVisitante {
    void salvar(Visitante v);
    List listar();
    void atualizar(Visitante v);
    void deletar(Visitante v);
}
