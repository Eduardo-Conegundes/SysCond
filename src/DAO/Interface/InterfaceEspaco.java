package DAO.Interface;

import Models.Espaco;
import java.util.List;

public interface InterfaceEspaco {
    
    void salvar(Espaco ep) throws Exception;
    List listar();
    Espaco listarId(int id) throws Exception;
    void atualizar(Espaco ep) throws Exception;
    void deletar(int id) throws Exception;
}
