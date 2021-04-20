package br.upe.DAO.Interface;

import java.util.List;

import br.upe.Models.Funcionario;


public interface InterfaceFuncionario {
    Funcionario salvar(Funcionario func) throws Exception;
    List<Funcionario> listar() throws Exception;
    Funcionario buscar(String cpf) throws Exception;
    Funcionario atualizar(Funcionario func) throws Exception;
    void deletar(String cpf) throws Exception;
    
}
