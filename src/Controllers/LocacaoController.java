package Controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import Controllers.Interface.InterfaceLocacaoController;
import DAO.LocacaoDAO;
import Models.Espaco;
import Models.Morador;

public class LocacaoController implements InterfaceLocacaoController {

	public Espaco criar(Espaco locacao) {
		Morador morador = locacao.getMorador(); 
		Morador moradorBd = null;
		java.util.Date data = locacao.getData();
		java.util.Date horarioInicio = locacao.getHorarioInicio();
		java.util.Date horarioFim = locacao.getHorarioFim();
		String espacoNome = locacao.getEspaco();
		List<Espaco> espacos = this.listar();
		
		try {
			moradorBd = new MoradorController().buscar(morador.getPessoa().getCpf());	
		} catch (Exception e) {
			System.err.println("Sistema - Erro ao buscar morador no banco de dados!");
		}
		
		if(moradorBd == null) {
			System.out.println("Erro ao buscar CPF de morador!");
			return null;
		}
		
		for(Espaco espaco : espacos) {
			if(((espacoNome.compareTo(espaco.getEspaco()) == 0) &&
					(data.compareTo(espaco.getData()) == 0) &&
					horarioInicio.before(espaco.getHorarioFim()) &&
							horarioFim.after(espaco.getHorarioInicio()))){
				System.out.println("Espa�o j� alugado!");
				return null;
			}
		}
		
		try {
			Espaco salva = LocacaoDAO.getInstance().salvar(locacao);
			System.out.println("Loca��o " + salva.getEspaco() + " salva com sucesso!");
			return salva;
		} catch (Exception e) {
			System.err.println("Erro ao Salvar locacao!");
			return null;		
		}

	}

	public Espaco buscar(int id){
		try {
			Espaco locacaoBuscar = LocacaoDAO.getInstance().buscar(id);
			System.out.println("Locac�o Encontrada: " + locacaoBuscar.getEspaco());
			return locacaoBuscar;
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar loca��o!");
			return null;
		}
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
			System.out.println("Locacao n�o encontrada pelo ID");
			return null;
		}		

		locacao.setId(id);

		try {
			Espaco locacaoAtualizada = LocacaoDAO.getInstance().atualizar(locacao);
			System.out.println("Loca��o atualizada com sucesso: " + locacaoAtualizada);
			return locacaoAtualizada;
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

	public List<Espaco> listar(){
		try {
			List<Espaco> locacoes = LocacaoDAO.getInstance().listar();
			System.out.println(" Loca��o listada com sucesso: " + locacoes.size());
			return locacoes;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar Loca��es)!");
			return null;
		}

	}
	
	public List<Espaco> listar(Date data){

		List<Espaco> todosEspacos = this.listar();
		List<Espaco> espacosDia = new ArrayList<Espaco>();

		for (int i = 0; i < todosEspacos.size(); i++) {
			if(todosEspacos.get(i).getData().compareTo(data)==0) {
				espacosDia.add(todosEspacos.get(i));
			}
		}
		
		return espacosDia;
	}

}
