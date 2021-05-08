package br.upe.syscond.dao;

import java.util.List;

import br.upe.syscond.models.Veiculo;

public interface InterfaceVeiculo {
    
	Veiculo salvar(Veiculo veiculo) throws Exception;
    List<Veiculo> listar() throws Exception;
    Veiculo buscar(Veiculo veiculo) throws Exception;
    Veiculo atualizar(Veiculo veiculo) throws Exception;
    void deletar(Veiculo veiculo) throws Exception;
    
}
