package br.upe.syscond.dao;

import java.util.List;

import br.upe.syscond.models.Visitante;

public interface InterfaceVisitante {
	Visitante salvar(Visitante v) throws Exception;
    List<Visitante> listar() throws Exception;
    List<Visitante> buscar(Visitante v) throws Exception;
}
