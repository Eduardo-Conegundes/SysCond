package DAO.Interface;
import Models.Empresa;
import java.util.List;

public interface InterfaceEmpresa {
    
    void salvar(Empresa e) throws Exception;
    List listar();
    Empresa listarId(String id) throws Exception;
    void atualizar(Empresa e) throws Exception;
    void deletar(String cnpj) throws Exception;
    
}
