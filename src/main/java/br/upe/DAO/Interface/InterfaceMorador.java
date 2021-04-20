package br.upe.DAO.Interface;

import java.util.List;

import br.upe.Models.Morador;

public interface InterfaceMorador{

    Morador salvar(Morador m) throws Exception;
    List<Morador> listar() throws Exception;
    Morador buscar(String cpf) throws Exception;
    Morador atualizar(Morador m) throws Exception;
    void deletar(String cpf) throws Exception;
    
}