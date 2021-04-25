package br.upe.syscond.dao;

import java.util.List;

import br.upe.syscond.models.ServicoProduto;

public interface InterfaceServicoProduto {
    
	ServicoProduto salvar(ServicoProduto sp) throws Exception;
    List<ServicoProduto> listar() throws Exception;
    ServicoProduto buscar(int id) throws Exception;
    ServicoProduto atualizar(ServicoProduto sp) throws Exception;
    void deletar(int id) throws Exception;
    
}
