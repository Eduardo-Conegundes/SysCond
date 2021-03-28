package DAO.Interface;
import Models.Contas;
import java.util.List;

public interface InterfaceContas {
	void salvar(Contas e);
    List listar();
    void atualizar(Contas e);
    void deletar(int id);
    
}
