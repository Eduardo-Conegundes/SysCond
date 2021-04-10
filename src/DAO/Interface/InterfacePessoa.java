package DAO.Interface;

import Models.Pessoa;
import java.util.List;

public interface InterfacePessoa {

    Pessoa salvar(Pessoa p);
    List listar();
    Pessoa buscar(String cpf);
    void atualizar(Pessoa p);
    void deletarPorId(String cpf);
    
}