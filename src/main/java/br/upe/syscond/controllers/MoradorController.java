package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.InterfaceMorador;
import br.upe.syscond.dao.MoradorDAO;
import br.upe.syscond.models.Morador;

public class MoradorController implements InterfaceMoradorController{
	
	static InterfaceMorador moradorDAO = MoradorDAO.getInstance();
	
	/**
	 * @param Morador
	 * @return Morador || null
	 * @throws Exception 
	 */
	public Morador criar(Morador morador) throws Exception{

		try {
			return moradorDAO.salvar(morador);
		} catch (Exception eCriar) {
			throw eCriar;
		}
	}
	/**
	 * @return Morador[] || null
	 * @throws Exception 
	 */
	public List<Morador> listar() throws Exception{
		try {
			return moradorDAO.listar();
		} catch (Exception eListar) {
			throw eListar;
		}
	}
	/**
	 * @param Morador
	 * @return Morador[] || null
	 * @throws Exception 
	 */
	public Morador buscar(Morador morador) throws Exception{
		try {
			return moradorDAO.buscar(morador);
		} catch (Exception eBuscar) {
			throw eBuscar;
		}
	}
	/**
	 * @param Morador novo
	 * @return Morador || null
	 * @throws Exception 
	 */
	public Morador atualizar(Morador novo) throws Exception{
		try {
			return moradorDAO.atualizar(novo);
		} catch (Exception eAtualizar) {
			throw eAtualizar;
		}
	}
	/**
	 * @param Morador antigo
	 * @return boolean
	 * @throws Exception 
	 */
	public void deletar(Morador morador) throws Exception{
		try {
			moradorDAO.deletar(morador);
		} catch (Exception eDeletar) {
			throw eDeletar;
		}
	}

}
