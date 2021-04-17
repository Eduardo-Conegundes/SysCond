package Controllers;

import java.util.ArrayList;
import java.util.List;

import DAO.ApartamentoDAO;
import Models.Apartamento;

public class ApartamentoController {

	public Apartamento criar(Apartamento apartamento){
		String bloco = apartamento.getBloco();
		int numero = apartamento.getNumero();
		
		//retorna a lista de apartamentos cadastrados
		List<Apartamento> ap = new ArrayList<Apartamento>();
		try {
			ap = ApartamentoDAO.getInstance().listar();
		} catch (Exception e) {
		}

		for (int i = 0; i < ap.size(); i++) {
			
            //procura se existe algum apartamento com o bloco e numero já cadastrado
            if(ap.get(i).getBloco().compareTo(bloco) == 0 && ap.get(i).getNumero() == numero) {
                System.out.println("Erro ao salvar Apartamento " + ap.get(i).getNumero() +" "+ ap.get(i).getBloco()+ ", já existe.");
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

	public Apartamento atualizar(Apartamento apartamento){
		
		Apartamento buscar = null;
		try {
			buscar = this.buscar(apartamento.getId());
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar apartamento!");
			return null;
		}

		if (buscar == null) {
			System.out.println("Apartamento não encontrado.");
			return null;
		}		

		try {
			Apartamento a = ApartamentoDAO.getInstance().atualizar(apartamento);
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
			System.out.println("Excluído com sucesso");
		} catch (Exception e) {
			System.err.println("Erro ao excluir Apartamento!");
		}
	}
}
