package DAO.Interface;

import Models.Espaco;
import java.util.List;

public interface InterfaceEspaco {
    
    void salvar(Espaco ep);
    List listar();
    void atualizar(Espaco ep);
    void deletar(long id);
}
