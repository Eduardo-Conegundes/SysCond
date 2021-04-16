package DAO.Interface;
import Models.Contas;
import java.util.List;

public interface InterfaceContas {
	Contas salvar(Contas e) throws Exception;
	List<Contas> listar();
    Contas buscar(int id) throws Exception;
    Contas atualizar(Contas conta) throws Exception;
    void deletar(int id) throws Exception;
    
}