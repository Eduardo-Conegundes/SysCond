package br.upe.syscond.dao;

import java.util.List;

import br.upe.syscond.models.Espaco;

public interface InterfaceLocacao {
    
    Espaco salvar(Espaco l) throws Exception;
    List<Espaco> listar() throws Exception;
    Espaco buscar(int id) throws Exception;
    Espaco atualizar(Espaco l) throws Exception;
    void deletar(int id) throws Exception;
    
}
