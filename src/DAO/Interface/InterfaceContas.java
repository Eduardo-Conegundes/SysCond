package DAO.Interface;
import Models.Contas;
import java.util.List;

public interface InterfaceContas {
	void salvar(Contas e);
    List listar();
    Contas listarId(int id);
    void atualizar(Contas conta);
    void deletar(int id);
    
}