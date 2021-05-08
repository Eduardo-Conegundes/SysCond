package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.ApartamentoDAO;
import br.upe.syscond.dao.InterfaceApartamento;
import br.upe.syscond.models.Apartamento;

public class ApartamentoController implements InterfaceApartamentoController {
	
	static InterfaceApartamento aptDAO = ApartamentoDAO.getInstance();
	
	/**
	 * @param Apartamento
	 * @return Apartamento
	 * @throws Exception 
	 */
	public Apartamento criar(Apartamento apartamento) throws Exception{
		try {
			return aptDAO.salvar(apartamento);
		} catch (Exception eSalvar) {
			throw eSalvar;
		}	
	}
	
	/**
	 * @return Apartamento[]
	 * @throws Exception 
	 */
	public List<Apartamento> listar() throws Exception{
		try {
			return aptDAO.listar();
		} catch (Exception eListar) {
			throw eListar;
		}

	}
	
	/**
	 * @param String
	 * @return Apartamento[]
	 * @throws Exception 
	 */
	public List<Apartamento> listar(String bloco) throws Exception {
		try {
			return aptDAO.listarPorBloco(bloco);
		} catch (Exception eListarBloco) {
			throw eListarBloco;
		}
	}
	
	/**
	 * @param Apartamento
	 * @return Apartamento
	 * @throws Exception 
	 */
	public Apartamento buscar(Apartamento pesquisar) throws Exception {
		try {
			return aptDAO.buscar(pesquisar);
		} catch (Exception eBuscar) {
			throw eBuscar;
		}
	}
	

	/**
	 * @param Apartamento novo
	 * @return Apartamento || null
	 * @throws Exception 
	 */
	public Apartamento atualizar(Apartamento novo) throws Exception{
		try {
			return aptDAO.atualizar(novo);
		} catch (Exception eAtualizar) {
			throw eAtualizar;
		}
	}

	/**
	 * @param Apartamento
	 * @return boolean
	 * @throws Exception 
	 */
	public void deletar(Apartamento apartamento) throws Exception {
		try {
			aptDAO.deletar(apartamento);
		} catch (Exception eDeletar) {
			throw eDeletar;
		}
	}

	@Override
	public List<Apartamento> listarBlocos(String bloco) throws Exception {
		try {
			return aptDAO.listarPorBloco(bloco);
		} catch (Exception eListarBloco) {
			throw eListarBloco;
		}
	}
	
	public List<Apartamento> listarBlocos() throws Exception {
		try {
			return aptDAO.listarBlocos();
		} catch (Exception eListarBloco) {
			throw eListarBloco;
		}
	}

	@Override
	public List<Apartamento> listarNumeros(Integer numero) throws Exception {
		try {
			return aptDAO.listarPorNumero(numero);
		} catch (Exception eListarNumero) {
			throw eListarNumero;
		}
	}
	
	public List<Apartamento> listarNumeros() throws Exception {
		try {
			return aptDAO.listarNumeros();
		} catch (Exception eListarNumero) {
			throw eListarNumero;
		}
	}

	
}
