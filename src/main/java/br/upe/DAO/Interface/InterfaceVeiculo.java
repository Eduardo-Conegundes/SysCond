package br.upe.DAO.Interface;

import java.util.List;

import br.upe.Models.Veiculo;

public interface InterfaceVeiculo {
    
	Veiculo salvar(Veiculo c) throws Exception;
    List<Veiculo> listar() throws Exception;
    Veiculo buscar(String placa) throws Exception;
    Veiculo atualizar(Veiculo c) throws Exception;
    void deletar(String placa) throws Exception;
    
}
