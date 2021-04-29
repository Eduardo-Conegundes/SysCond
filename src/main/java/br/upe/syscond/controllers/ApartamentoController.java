package br.upe.syscond.controllers;

import java.util.ArrayList;
import java.util.List;

import br.upe.syscond.dao.ApartamentoDAO;
import br.upe.syscond.models.Apartamento;

public class ApartamentoController implements InterfaceApartamentoController {

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

	public List<Apartamento> listar(){
		try {
			List<Apartamento> list = ApartamentoDAO.getInstance().listar();
			return list;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar Apartamento(s)!");
			return null;
		}

	}

	public Apartamento buscar(Apartamento pesquisar) {
		List<Apartamento>lista_apartamentos = this.listar();
		for (int i=0; i <= lista_apartamentos.size(); i++) {
			if(lista_apartamentos.get(i).equals(pesquisar)) {
				return lista_apartamentos.get(i);
			}
		}
		return null;
	}

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

	public Apartamento atualizar(Apartamento antigo, Apartamento novo){
		Apartamento busca = null;
		try {
			busca = this.buscar(antigo);		
		} catch (Exception eBuscar) {
			System.err.println("Erro no sistema ao buscar apartamento!");
			return null;
		}
		if(busca != null) {
			try {
				novo.setId(busca.getId());
				Apartamento atualizado = ApartamentoDAO.getInstance().atualizar(novo);
				return atualizado;
			} catch (Exception eSalvar) {
				System.err.println("Erro ao atualizar Apartamento!");
				return null;
			}
		}else {
			System.out.println("apartamento não encontrado");
			return null;
		}
	}

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
