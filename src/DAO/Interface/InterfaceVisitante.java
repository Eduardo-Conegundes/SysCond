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
	Visitante salvar(Visitante v) throws Exception;
    List<Visitante> listar() throws Exception;
    Visitante buscar(String cpf) throws Exception;
    Visitante atualizar(Visitante v) throws Exception;
    void deletar(String cpf) throws Exception;
}
