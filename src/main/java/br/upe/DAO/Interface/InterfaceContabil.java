package br.upe.DAO.Interface;
import java.util.List;

import br.upe.Models.Contabil;

public interface InterfaceContabil {
	Contabil salvar(Contabil e) throws Exception;
    List<Contabil> listar() throws Exception;
    Contabil buscar(int id) throws Exception;
    Contabil atualizar(Contabil e) throws Exception;
    void deletar(int id) throws Exception;
    
}
