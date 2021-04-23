package br.upe.DAO.Interface;

import java.util.List;

import br.upe.Models.Almoxarifado;

public interface InterfaceEstoque {
    void salvar(Almoxarifado F) throws Exception;
    List<Almoxarifado> listar() throws Exception;
    void atualizar(Almoxarifado F) throws Exception;
    void deletar(Almoxarifado F) throws Exception;
    
}
