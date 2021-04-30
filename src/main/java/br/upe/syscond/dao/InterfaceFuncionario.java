package br.upe.syscond.dao;

import java.util.List;

import br.upe.syscond.models.Funcionario;


public interface InterfaceFuncionario {
    Funcionario salvar(Funcionario func) throws Exception;
    List<Funcionario> listar() throws Exception;
    Funcionario buscar(int id) throws Exception;
    Funcionario atualizar(Funcionario func) throws Exception;
    void deletar(int id) throws Exception;
    
}
