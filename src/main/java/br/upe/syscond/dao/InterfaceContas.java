package br.upe.syscond.dao;
import java.util.List;

import br.upe.syscond.models.Contas;

public interface InterfaceContas {
	Contas salvar(Contas e) throws Exception;
	List<Contas> listar() throws Exception;
    Contas buscar(int id) throws Exception;
    Contas atualizar(Contas conta) throws Exception;
    void deletar(int id) throws Exception;
    
}