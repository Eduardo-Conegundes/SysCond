package Controllers;

import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import DAO.LocacaoDAO;
import DAO.MoradorDAO;
import Models.Espaco;
import Models.Morador;

public class LocacaoController {
	//VALIDAR
	public Espaco criar(Espaco locacao) {
		Morador morador = locacao.getMorador(); 
		try {
			morador = MoradorDAO.getInstance().buscar(morador.getPessoa().getCpf());	
		} catch (Exception e) {
			System.err.println("Erro ao encontrar morador!");
		}
		if(morador == null) {
			System.out.println("Erro ao encontrar morador!");
			return null;
		}

		try {
			Espaco salva = LocacaoDAO.getInstance().salvar(locacao);
			System.out.println("Locação " + salva.getEspaco() + " salva com sucesso!");
			return salva;
		} catch (Exception e) {
			System.err.println("Erro ao Salvar locacao!");
		}
		return null;		
	}

	public Espaco buscar(int id){
		try {
			Espaco locacaoBuscar = LocacaoDAO.getInstance().buscar(id);
			System.out.println("Locacão Encontrada: " + locacaoBuscar);
			return locacaoBuscar;
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar locação!");
			return null;
		}
	}

	public List<Espaco> buscar(Date data){

		List<Espaco> todosEspacos = this.listar();
		List<Espaco> espacosDia = new ArrayList<Espaco>();

		for (int i = 0; i < todosEspacos.size(); i++) {
			if(todosEspacos.get(i).getData().compareTo(data)==0) {
				espacosDia.add(todosEspacos.get(i));
			}
		}
		return espacosDia;
	}

	public Espaco atualizar(int id, Espaco locacao){
		Morador morador = null;
		Espaco locacaoId = null;
		
		try {
			morador = new MoradorController().buscar(locacao.getMorador().getPessoa().getCpf());	
		} catch (Exception e) {
			System.err.println("Erro ao encontrar morador!");
		}
		
		if(morador == null) {
			System.out.println("Erro ao encontrar morador!");
			return null;
		} 
		
		try {
			locacaoId = this.buscar(id);
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar id!");
			return null;
		}

		if (locacaoId==null) {
			System.out.println("Locacao não encontrada pelo ID");
			return null;
		}		

		locacao.setId(id);

		try {
			Espaco locacaoAtualizada = LocacaoDAO.getInstance().atualizar(locacao);
			System.out.println("Locação atualizada com sucesso: " + locacaoAtualizada);
			return locacaoAtualizada;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao atualizar Locação!");
			return null;
		}
	}

	public void deletar(int id){
		try {
			LocacaoDAO.getInstance().deletar(id);
			System.out.println("Locação excluída com sucesso");
		} catch (Exception e) {
			System.err.println("Erro ao excluir Locação!");
		}
	}

	public List<Espaco> listar(){
		try {
			List<Espaco> loc = LocacaoDAO.getInstance().listar();
			System.out.println(" Locação listada com sucesso: " + loc.size());
			return loc;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar Locações)!");
			return null;
		}

	}
}
