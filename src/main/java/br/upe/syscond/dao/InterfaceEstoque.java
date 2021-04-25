package br.upe.syscond.dao;

import java.util.List;

import br.upe.syscond.models.Almoxarifado;

public interface InterfaceEstoque {
    Almoxarifado salvar(Almoxarifado F) throws Exception;
    List<Almoxarifado> listar() throws Exception;
    void atualizar(Almoxarifado F) throws Exception;
    void deletar(Almoxarifado F) throws Exception;
    
}
