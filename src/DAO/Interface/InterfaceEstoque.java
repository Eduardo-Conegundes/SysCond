
package DAO.Interface;

import Models.Funcionario;
import Models.Estoque;

import java.util.List;

public interface InterfaceEstoque {
    void salvar(Funcionario F);
    List listar();
    Estoque listarId(int id);
    void atualizar(Funcionario F);
    void deletar(Funcionario F);
    
}
