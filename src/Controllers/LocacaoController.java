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
			System.out.println("Loca��o " + l.getEspaco() + " salva com sucesso!");
			return salva;
		} catch (Exception e) {
			System.err.println("Erro ao Salvar locacao!");
		}
		return null;		
	}
	
	public Locacao buscar(int id){
		try {
			Locacao loc = LocacaoDAO.getInstance().buscar(id);
			System.out.println("Locac�o Encontrada: " + loc);
			return loc;
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar loca��o!");
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
			System.out.println("Locacao n�o encontrada pelo ID");
			return null;
		}		
		
		locacao2.setId(l.getId());
		
		try {
			Locacao loca = LocacaoDAO.getInstance().atualizar(locacao2);
			System.out.println("Loca��o atualizada com sucesso: " + loca);
			return loca;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao atualizar Loca��o!");
			return null;
		}
	}
	

	public void deletar(int id){
		try {
			LocacaoDAO.getInstance().deletar(id);
			System.out.println("Loca��o exclu�da com sucesso");
		} catch (Exception e) {
			System.err.println("Erro ao excluir Loca��o!");
		}
	}
	
	public List<Locacao> listar(){
		try {
			List<Locacao> loc = LocacaoDAO.getInstance().listar();
			System.out.println(" Loca��o listada com sucesso: " + loc.size());
			return loc;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar Loca��es)!");
			return null;
		}

	}
}
