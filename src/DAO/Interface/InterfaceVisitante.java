/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Models.Visitante;
import java.util.List;

/**
 *
 * @author flavi
 */
public interface InterfaceVisitante {
    void salvar(Visitante v);
    List listar();
    Visitante listarId(int id);
    void atualizar(Visitante v);
    void deletar(Visitante v);
}
