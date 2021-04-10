package DAO.Interface;

import Models.Apartamento;

import java.util.List;

public interface InterfaceApartamento {

    Apartamento salvar(Apartamento a) throws Exception;
    List<Apartamento> listar() throws Exception;
    Apartamento buscar(int id) throws Exception;
    Apartamento atualizar(Apartamento a) throws Exception;
    void deletarPorId(int id) throws Exception;
    
}