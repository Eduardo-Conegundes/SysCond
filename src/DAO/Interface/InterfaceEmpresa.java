package DAO.Interface;
import Models.Empresa;
import java.util.List;

public interface InterfaceEmpresa {
    
    void salvar(Empresa e);
    List listar();
    Empresa listarId(String id);
    void atualizar(Empresa e);
    void deletar(String cnpj);
    
}
