package br.upe.Controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.upe.Controllers.Interface.InterfaceApartamentoController;
import br.upe.DAO.ApartamentoDAO;
import br.upe.DAO.Interface.InterfaceApartamento;
import br.upe.Models.Apartamento;

public class ApartamentoController implements InterfaceApartamentoController {

	public Apartamento criar(Apartamento apartamento){
		String bloco = apartamento.getBloco();
		int numero = apartamento.getNumero();
		
		//retorna a lista de apartamentos cadastrados
		List<Apartamento> ap = new ArrayList<Apartamento>();
		try {
			ap = this.listar();
		} catch (Exception eListar) {
			System.err.println("Erro ao listar apartamentos");
		}

		for (int i = 0; i < ap.size(); i++) {
			
            //procura se existe algum apartamento com o bloco e numero j� cadastrado
            if(ap.get(i).getBloco().compareTo(bloco) == 0 && ap.get(i).getNumero() == numero) {
                System.err.println("Erro ao salvar Apartamento " + ap.get(i).getNumero() +" "+ ap.get(i).getBloco()+ ", j� existe.");
                return null;
            }
        }
		
		try {
			Apartamento p = ApartamentoDAO.getInstance().salvar(apartamento);
			System.out.println("Salvo com sucesso: " + p.getNumero() + p.getBloco());
			return p;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao salvar Apartamento!");
			return null;
		}	
	}

	public List<Apartamento> listar(){
		try {
			List<Apartamento> l = ApartamentoDAO.getInstance().listar();
			System.out.println("Lido com sucesso! Resultados: " + l.size());
			return l;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar Apartamento(s)!");
			return null;
		}

	}
	
	public Apartamento buscar(String bloco, int numero) {
		List<Apartamento>lista_apartamentos = this.listar();
		for (Apartamento apartamento : lista_apartamentos) {
			if(apartamento.getBloco().compareTo(bloco)==0 && apartamento.getNumero() == numero) {
				return apartamento;
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
	
	public Apartamento buscar(int id){
		try {
			Apartamento b = ApartamentoDAO.getInstance().buscar(id);
			System.out.println("Apartamento achado com sucesso: " + b.getNumero() + b.getBloco());
			return b;
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar Apartamento!");
			return null;
		}
	}

	public Apartamento atualizar(int id, int vagas){
		Apartamento buscar = null;

		try {
			buscar = this.buscar(id);		
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar apartamento!");
			return null;
		}
		if (buscar == null) {
			System.err.println("Apartamento n�o encontrado.");
			return null;
		}
		buscar.setVagas(vagas);
		try {
			Apartamento a = ApartamentoDAO.getInstance().atualizar(buscar);
			System.out.println("Atualizado com sucesso! " + a.getBloco() + a.getNumero() + a.getVagas());
			return a;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao atualizar Apartamento!");
			return null;
		}
	}

	public void deletar(Apartamento apartamento) {
		int id = apartamento.getId();
		try {
			ApartamentoDAO.getInstance().deletar(id);
			System.out.println("Exclu�do com sucesso");
		} catch (Exception e) {
			System.err.println("Erro ao excluir Apartamento!");
		}
	}
}
