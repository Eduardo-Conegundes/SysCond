package Controllers;

import java.util.Calendar;
import java.util.List;
import DAO.LocacaoDAO;
import DAO.MoradorDAO;
import Models.Locacao;
import Models.Morador;

public class LocacaoController {
	public Locacao criar(Calendar data, String cpf, String espaco, float valor) {
		Morador morador = null; 
		try {
			morador = MoradorDAO.getInstance().buscar(cpf);	
		} catch (Exception e) {
			System.err.println("Erro ao encontrar morador!");
		}
		if(morador == null) {
			System.out.println("Erro ao encontrar morador!");
			return null;
		} 
		Locacao l = new Locacao(data, morador, espaco, valor);
		try {
			Locacao salva = LocacaoDAO.getInstance().salvar(l);
			System.out.println("Locação " + l.getEspaco() + " salva com sucesso!");
			return salva;
		} catch (Exception e) {
			System.err.println("Erro ao Salvar locacao!");
		}
		return null;		
	}
	
	public Locacao buscar(int id){
		try {
			Locacao loc = LocacaoDAO.getInstance().buscar(id);
			System.out.println("Locacão Encontrada: " + loc);
			return loc;
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar locação!");
			return null;
		}
	}
	
	public Locacao atualizar(int id, Calendar data, String cpf, String espaco, float valor){
		Morador morador = null;
		try {
			morador = MoradorDAO.getInstance().buscar(cpf);	
		} catch (Exception e) {
			System.err.println("Erro ao encontrar morador!");
		}
		if(morador == null) {
			System.out.println("Erro ao encontrar morador!");
			return null;
		} 
		Locacao locacao2 = new Locacao(data, morador, espaco, valor);
		Locacao l = null;
		try {
			l = LocacaoDAO.getInstance().buscar(id);
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar id!");
			return null;
		}
		
		if (l==null) {
			System.out.println("Locacao não encontrada pelo ID");
			return null;
		}		
		
		locacao2.setId(l.getId());
		
		try {
			Locacao loca = LocacaoDAO.getInstance().atualizar(locacao2);
			System.out.println("Locação atualizada com sucesso: " + loca);
			return loca;
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
	
	public List<Locacao> listar(){
		try {
			List<Locacao> loc = LocacaoDAO.getInstance().listar();
			System.out.println(" Locação listada com sucesso: " + loc.size());
			return loc;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar Locações)!");
			return null;
		}

	}
}
