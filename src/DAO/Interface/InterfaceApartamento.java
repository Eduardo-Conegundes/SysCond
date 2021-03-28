package DAO.Interface;

import Models.Apartamento;
import java.util.List;

public interface InterfaceApartamentoDAO {

    void salvar(Apartamento a);
    List<Apartamento> listar();
    void atualizar(Apartamento a);
    void deletar(String bloco, int numero);
    
}