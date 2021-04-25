package br.upe.syscond.dao;

import java.util.List;

import br.upe.syscond.models.Visitante;

public interface InterfaceVisitante {
	Visitante salvar(Visitante v) throws Exception;
    List<Visitante> listar() throws Exception;
    Visitante buscar(String cpf) throws Exception;
    Visitante atualizar(Visitante v) throws Exception;
    void deletar(String cpf) throws Exception;
}
