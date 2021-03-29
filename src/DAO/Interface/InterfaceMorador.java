package DAO.Interface;

import Models.Morador;
import java.util.List;

public interface InterfaceMorador{

    void salvar(Morador m);
    List listar();
    Morador listarId(int id);
    void atualizar(Morador m);
    void deletar(Morador m);
    
}