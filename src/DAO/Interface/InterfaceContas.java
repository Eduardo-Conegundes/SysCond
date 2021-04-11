package DAO.Interface;
import Models.Contas;
import java.util.List;

public interface InterfaceContas {
	void salvar(Contas e) throws Exception;
    List listar();
    Contas listarId(int id) throws Exception;
    void atualizar(Contas conta) throws Exception;
    void deletar(int id) throws Exception;
    
}