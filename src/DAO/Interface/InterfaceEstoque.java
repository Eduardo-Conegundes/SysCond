
package DAO.Interface;



import Models.Estoque;

import java.util.List;

public interface InterfaceEstoque {
    void salvar(Estoque F) throws Exception;
    List listar();
    void atualizar(Estoque F) throws Exception;
    void deletar(Estoque F) throws Exception;
    
}
