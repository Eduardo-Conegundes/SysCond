package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.ApartamentoDAO;
import br.upe.syscond.dao.MoradorDAO;
import br.upe.syscond.models.Apartamento;
import br.upe.syscond.models.Morador;
import br.upe.syscond.models.Pessoa;

public class MoradorController implements InterfaceMoradorController{

	public Morador criar(Morador morador){

		if(this.buscar(morador)!=null) {
			return null;
		}

		try {
			Morador salvo = MoradorDAO.getInstance().salvar(morador);
			return salvo;
		} catch (Exception eCriar) {
			System.err.println("Erro ao salvar morador");
			return null;
		}
	}

	public List<Morador> listar(){
		try {
			List<Morador> m = MoradorDAO.getInstance().listar();
			return m;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar Morador(es)!");
			return null;
		}
	}

	public Morador buscar(Morador morador){
		List<Morador> lista = this.listar();
		for (Morador morador2 : lista) {
			if(morador2.equals(morador)) {
				return morador2;
			}
		}
		return null;
	}

	public Morador atualizar(Morador antigo, Morador novo){
		try {
			novo.setId(this.buscar(antigo).getId());
			return MoradorDAO.getInstance().atualizar(novo);
		} catch (Exception e) {
			return null;
		}
	}

	public boolean deletar(Morador morador){
		int id = this.buscar(morador).getId();
		try {
			MoradorDAO.getInstance().deletar(id);
			return true;
		} catch (Exception eDeletar) {
			System.err.println("Erro ao deletar morador");
			return false;
		}
	}

}
