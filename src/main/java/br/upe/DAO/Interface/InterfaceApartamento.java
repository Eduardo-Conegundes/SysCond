package br.upe.DAO.Interface;

import java.util.List;

import br.upe.Models.Apartamento;

public interface InterfaceApartamento {

    Apartamento salvar(Apartamento a) throws Exception;
    List<Apartamento> listar() throws Exception;
    Apartamento buscar(int id) throws Exception;
    Apartamento atualizar(Apartamento a) throws Exception;
    void deletar(int id) throws Exception;
    
}