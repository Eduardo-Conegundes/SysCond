package br.upe.DAO.Interface;
import java.util.List;

import br.upe.Models.Empresa;

public interface InterfaceEmpresa {
    
    Empresa salvar(Empresa e) throws Exception;
    List<Empresa> listar() throws Exception;
    Empresa buscar(String id) throws Exception;
    Empresa atualizar(Empresa e) throws Exception;
    void deletar(String cnpj) throws Exception;
    
}
