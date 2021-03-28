package DAO.Interface;

import Models.Pessoa;
import java.util.List;

public interface InterfacePessoaDAO {

    void salvar(Pessoa p);
    List listar();
    void atualizar(Pessoa p);
    void deletar(Pessoa p);
    
}