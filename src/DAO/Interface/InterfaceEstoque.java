
package DAO.Interface;

import Models.Estoque;

import java.util.List;

public interface InterfaceEstoque {
    void salvar(Estoque F);
    List listar();
    void atualizar(Estoque F);
    void deletar(Estoque F);
    
}
