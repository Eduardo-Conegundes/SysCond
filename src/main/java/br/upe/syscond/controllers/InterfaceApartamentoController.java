package br.upe.syscond.controllers;

import java.util.ArrayList;
import java.util.List;

import br.upe.syscond.models.Apartamento;

public interface InterfaceApartamentoController {
	/**
	 * 
	 * @param apartamento
	 * @return apartamento
	 * @throws Exception
	 */
	public Apartamento criar(Apartamento apartamento) throws Exception;
	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	public List<Apartamento> listar() throws Exception;

	/**
	 * 
	 * @param apartamento
	 * @return
	 * @throws Exception 
	 */
	public Apartamento buscar(Apartamento apartamento) throws Exception;
	/**
	 * 
	 * @param novo
	 * @return
	 * @throws Exception 
	 */
	public Apartamento atualizar(Apartamento novo) throws Exception;
	/**
	 * 
	 * @param apartamento
	 * @return
	 * @throws Exception 
	 */
	public void deletar(Apartamento apartamento) throws Exception;

}
