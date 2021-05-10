package br.upe.syscond.dao;

import java.util.List;

import br.upe.syscond.models.Espaco;

public interface InterfaceLocacao {
    
    Espaco salvar(Espaco locacao) throws Exception;
    List<Espaco> listar() throws Exception;
    Espaco buscar(Espaco locacao) throws Exception;
    Espaco atualizar(Espaco locacao) throws Exception;
    void deletar(Espaco locacao) throws Exception;
    
}
