package br.upe.DAO.Interface;

import java.util.List;

import br.upe.Models.Pessoa;

public interface InterfacePessoa {

    Pessoa salvar(Pessoa p) throws Exception;
    List<Pessoa> listar() throws Exception;
    Pessoa buscar(String cpf) throws Exception;
    Pessoa atualizar(Pessoa p) throws Exception;
    void deletar(String cpf) throws Exception;
    
}