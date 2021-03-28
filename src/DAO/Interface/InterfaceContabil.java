package DAO.Interface;
import Models.Contabil;
import java.util.List;

public interface InterfaceContabil {
	void salvar(Contabil e);
    List listar();
    void atualizar(Contabil e);
    void deletar(int id);
    
}
