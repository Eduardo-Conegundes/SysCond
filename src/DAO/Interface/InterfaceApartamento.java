package DAO.Interface;

import Models.Apartamento;

import java.util.List;

public interface InterfaceApartamento {

    void salvar(Apartamento a);
    List<Apartamento> listar();
    Apartamento listarId(String bloco, int numero);
    void atualizar(Apartamento a);
    void deletar(String bloco, int numero);
    
}