package br.upe.syscond.dao;
import java.util.List;

import br.upe.syscond.models.Empresa;

public interface InterfaceEmpresa {
    
    Empresa salvar(Empresa empresa) throws Exception;
    List<Empresa> listar() throws Exception;
    Empresa buscar(Empresa empresa) throws Exception;
    Empresa atualizar(Empresa empresa) throws Exception;
    void deletar(Empresa empresa) throws Exception;
    
}
