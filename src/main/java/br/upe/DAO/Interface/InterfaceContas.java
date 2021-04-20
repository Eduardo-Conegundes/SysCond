package br.upe.DAO.Interface;
import java.util.List;

import br.upe.Models.Contas;

public interface InterfaceContas {
	Contas salvar(Contas e) throws Exception;
	List<Contas> listar() throws Exception;
    Contas buscar(int id) throws Exception;
    Contas atualizar(Contas conta) throws Exception;
    void deletar(int id) throws Exception;
    
}