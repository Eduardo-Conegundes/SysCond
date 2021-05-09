package br.upe.syscond.dao;
import java.time.LocalDate;
import java.util.List;

import br.upe.syscond.models.Contas;

public interface InterfaceContas {
	Contas salvar(Contas contas) throws Exception;
	List<Contas> listar() throws Exception;
	List<Contas> listarPorData(LocalDate data) throws Exception;
    Contas buscar(Contas contas) throws Exception;
    Contas atualizar(Contas conta) throws Exception;
    void deletar(Contas conta) throws Exception;
    
}