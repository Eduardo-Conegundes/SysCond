package br.upe.syscond.dao;
import java.util.List;

import br.upe.syscond.models.Contabil;

public interface InterfaceContabil {
	Contabil salvar(Contabil e) throws Exception;
    List<Contabil> listar() throws Exception;
    Contabil buscar(int id) throws Exception;
    Contabil atualizar(Contabil e) throws Exception;
    void deletar(int id) throws Exception;
    
}
