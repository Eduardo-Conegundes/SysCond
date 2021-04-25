package br.upe.syscond.dao;

import java.util.List;

import br.upe.syscond.models.Veiculo;

public interface InterfaceVeiculo {
    
	Veiculo salvar(Veiculo c) throws Exception;
    List<Veiculo> listar() throws Exception;
    Veiculo buscar(String placa) throws Exception;
    Veiculo atualizar(Veiculo c) throws Exception;
    void deletar(String placa) throws Exception;
    
}
