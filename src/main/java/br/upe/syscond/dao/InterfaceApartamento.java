package br.upe.syscond.dao;

import java.util.List;

import br.upe.syscond.models.Apartamento;

public interface InterfaceApartamento {

    Apartamento salvar(Apartamento a) throws Exception;
    List<Apartamento> listar() throws Exception;
    List<Apartamento> listarPorBloco(String bloco) throws Exception;
    Apartamento buscar(Apartamento a) throws Exception;
    Apartamento atualizar(Apartamento a) throws Exception;
    void deletar(Apartamento a) throws Exception;
	List<Apartamento> listarPorNumero(Integer numero) throws Exception;
	List<Apartamento> listarBlocos() throws Exception;
	List<Apartamento> listarNumeros() throws Exception;
}