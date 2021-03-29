package DAO.Interface;

import Models.Pessoa;
import java.util.List;

public interface InterfacePessoa {

    void salvar(Pessoa p);
    List listar();
    Pessoa listarId(int id);
    void atualizar(Pessoa p);
    void deletarPorId(String cpf);
    
}