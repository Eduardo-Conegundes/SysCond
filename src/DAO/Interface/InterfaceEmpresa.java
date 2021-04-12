package DAO.Interface;
import Models.Empresa;
import java.util.List;

public interface InterfaceEmpresa {
    
    Empresa salvar(Empresa e) throws Exception;
    List<Empresa> listar();
    Empresa buscar(String id) throws Exception;
    Empresa atualizar(Empresa e) throws Exception;
    void deletar(String cnpj) throws Exception;
    
}
