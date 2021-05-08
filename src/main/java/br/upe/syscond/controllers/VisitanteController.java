package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.InterfaceVisitante;
import br.upe.syscond.dao.VisitanteDAO;
import br.upe.syscond.models.Visitante;

public class VisitanteController implements InterfaceVisitanteController{
	
	static InterfaceVisitante visitanteDAO = VisitanteDAO.getInstance();
	
	/**
	 * @param Visitante
	 * @return Visitante || null
	 * @throws Exception 
	 */
	public Visitante criar(Visitante visitante) throws Exception {
		try {
			return visitanteDAO.salvar(visitante);		
		} catch (Exception eSalvar) {
			throw eSalvar;
		}
	}
	/**
	 * @param Visitante
	 * @return Visitante || null
	 * @throws Exception 
	 */
	public List<Visitante> buscar(Visitante visitante) throws Exception{
		try {
			return visitanteDAO.buscar(visitante);
		} catch (Exception eBuscar) {
			throw eBuscar;
		}
	}
	/**
	 * @return Visitante[] || null
	 * @throws Exception 
	 */
	public List<Visitante> listar() throws Exception{
		try {
			return visitanteDAO.listar();
		} catch (Exception eListar) {
			throw eListar;
		}
	}

}
