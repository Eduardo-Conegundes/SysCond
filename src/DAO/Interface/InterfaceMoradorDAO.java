package DAO.Interface;

import Models.Morador;
import java.util.List;

public interface InterfaceMoradorDAO {

    void salvar(Morador m);
    List listar();
    void atualizar(Morador m);
    void deletar(Morador m);
    
}