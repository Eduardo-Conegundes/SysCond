package Interfaces;

import Models.Apartamento;
import java.util.List;

public interface InterfaceApartamentoDAO {

    void salvar(Apartamento a);
    List<Apartamento> listar();
    void atualizar(Apartamento a);
    void deletar(Apartamento a);
    
}