package DAO.Interface;
import Models.Contabil;

import java.util.List;

public interface InterfaceContabil {
	void salvar(Contabil e) throws Exception;
    List listar();
    Contabil listarId(int id);
    void atualizar(Contabil e) throws Exception;
    void deletar(int id) throws Exception;
    
}
