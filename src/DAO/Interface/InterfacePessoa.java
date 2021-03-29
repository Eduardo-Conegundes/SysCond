package DAO.Interface;

import Models.Pessoa;
import java.util.List;

public interface InterfacePessoa {

    void salvar(Pessoa p);
    List listar();
    void atualizar(Pessoa p);
    void deletar(Pessoa p);
    
}