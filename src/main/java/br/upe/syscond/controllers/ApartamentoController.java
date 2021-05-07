package br.upe.syscond.controllers;

import java.util.ArrayList;
import java.util.List;

import br.upe.syscond.dao.ApartamentoDAO;
import br.upe.syscond.models.Apartamento;

public class ApartamentoController implements InterfaceApartamentoController {
	/**
	 * @param Apartamento
	 * @return null || Apartamento
	 */
	public Apartamento criar(Apartamento apartamento){
		List<Apartamento> ap = new ArrayList<Apartamento>();
		ap = this.listar();
		for (int i = 0; i < ap.size(); i++) {
			if(ap.get(i).equals(apartamento)) {
				System.err.println("Erro ao salvar Apartamento, já existe.");
				return null;
			}
		}
		try {
			Apartamento salvo = ApartamentoDAO.getInstance().salvar(apartamento);
			return salvo;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao salvar Apartamento!");
			return null;
		}	
	}
	/**
	 * @return Apartamento[]
	 */
	public List<Apartamento> listar(){
		try {
			List<Apartamento> list = ApartamentoDAO.getInstance().listar();
			return list;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar Apartamento(s)!");
			return null;
		}

	}
	/**
	 * @param Apartamento
	 * @return Apartamento
	 */
	public Apartamento buscar(Apartamento pesquisar) {
		List<Apartamento>lista_apartamentos = this.listar();
		for (int i=0; i <= lista_apartamentos.size(); i++) {
			if(lista_apartamentos.get(i).equals(pesquisar)) {
				return lista_apartamentos.get(i);
			}
		}
		return null;
	}
	/**
	 * @param String
	 * @param int
	 * @return null || Apartamento
	 */
	public Apartamento buscar(String bloco, int numero) {
		List<Apartamento>lista_apartamentos = this.listar();
		for (int i=0; i <= lista_apartamentos.size(); i++) {
			if(lista_apartamentos.get(i).getBloco().compareTo(bloco) == 0 && lista_apartamentos.get(i).getNumero() == numero) {
				return lista_apartamentos.get(i);
			}
		}

		return null;

	}
	/**
	 * @param String
	 * @return Apartamento[]
	 */
	public List<Apartamento> listar(String bloco) {
		List<Apartamento>lista_apartamentos = this.listar();
		List<Apartamento>lista_por_bloco = new ArrayList<Apartamento>();

		for (int i = 0; i < lista_apartamentos.size(); i++) {
			if(lista_apartamentos.get(i).getBloco().compareTo(bloco)==0) {
				lista_por_bloco.add(lista_apartamentos.get(i));
			}
		}
		return lista_por_bloco;
	}
	/**
	 * @param String
	 * @return String[]
	 */
	public ArrayList<String> listaNumeros(String bloco){
		List<Apartamento>lista_apartamentos = this.listar();
		ArrayList<String>lista_por_bloco = new ArrayList<String>();

		for (int i = 0; i < lista_apartamentos.size(); i++) {
			if(lista_apartamentos.get(i).getBloco().compareTo(bloco)==0) {
				lista_por_bloco.add(Integer.toString(lista_apartamentos.get(i).getNumero()));
			}

		}
		return lista_por_bloco;
	}
	/**
	 * @return String[]
	 */
	public ArrayList<String> listarNumeros() {
		List<Apartamento>lista_apartamentos = this.listar();
		ArrayList<String> lista_por_numero = new ArrayList<String>();


		for (int i = 0; i < lista_apartamentos.size(); i++) {

			lista_por_numero.add(Integer.toString(lista_apartamentos.get(i).getNumero()));

		}

		return lista_por_numero;
	}
	/**
	 * @return String[]
	 */
	public ArrayList<String> listarBlocos() {
		List<Apartamento>lista_apartamentos = this.listar();
		ArrayList<String> lista_de_blocos = new ArrayList<String>();


		for (int i = 0; i < lista_apartamentos.size(); i++) {

			lista_de_blocos.add(lista_apartamentos.get(i).getBloco());

		}

		return lista_de_blocos;
	}


	/**
	 * @param Apartamento novo
	 * @return Apartamento || null
	 */
	public Apartamento atualizar(Apartamento novo){
		try {
			return ApartamentoDAO.getInstance().atualizar(novo);
		} catch (Exception eSalvar) {
			System.err.println("Erro ao atualizar Apartamento!");
			return null;
		}
	}

	/**
	 * @param Apartamento
	 * @return boolean
	 */
	public boolean deletar(Apartamento apartamento) {
		int id = apartamento.getId();
		try {
			ApartamentoDAO.getInstance().deletar(id);
			return true;
		} catch (Exception e) {
			System.err.println("Erro ao excluir Apartamento!");
			return false;
		}
	}
}
