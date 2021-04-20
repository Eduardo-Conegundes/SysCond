package br.upe.DAO.Interface;

import java.util.List;

import br.upe.Models.Estoque;

public interface InterfaceEstoque {
    void salvar(Estoque F) throws Exception;
    List<Estoque> listar() throws Exception;
    void atualizar(Estoque F) throws Exception;
    void deletar(Estoque F) throws Exception;
    
}
