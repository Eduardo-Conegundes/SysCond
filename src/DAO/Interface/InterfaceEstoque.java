
package DAO.Interface;

import Models.Funcionario;

import java.util.List;

public interface InterfaceEstoque {
    void salvar(Funcionario F);
    List listar();
    void atualizar(Funcionario F);
    void deletar(Funcionario F);
    
}
