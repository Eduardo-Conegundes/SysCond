package br.upe.syscond.dao;

import java.util.List;

import br.upe.syscond.models.Apartamento;

public interface InterfaceApartamento {

    Apartamento salvar(Apartamento a) throws Exception;
    List<Apartamento> listar() throws Exception;
    Apartamento buscar(int id) throws Exception;
    Apartamento atualizar(Apartamento a) throws Exception;
    boolean deletar(int id) throws Exception;
    
}