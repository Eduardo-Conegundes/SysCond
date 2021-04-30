package br.upe.syscond.dao;
import java.util.List;

import br.upe.syscond.models.Empresa;

public interface InterfaceEmpresa {
    
    Empresa salvar(Empresa e) throws Exception;
    List<Empresa> listar() throws Exception;
    Empresa buscar(int id) throws Exception;
    Empresa atualizar(Empresa e) throws Exception;
    void deletar(int id) throws Exception;
    
}
