package br.upe.syscond.dao;

import java.util.List;

import br.upe.syscond.models.Pessoa;

public interface InterfacePessoa {

    Pessoa salvar(Pessoa pessoa) throws Exception;
    List<Pessoa> listar() throws Exception;
    Pessoa buscar(Pessoa Pessoa) throws Exception;
    Pessoa atualizar(Pessoa pessoa) throws Exception;
    void deletar(Pessoa Pessoa) throws Exception;
    
}