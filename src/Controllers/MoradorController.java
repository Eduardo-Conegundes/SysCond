package Controllers;

import java.util.List;

import DAO.ApartamentoDAO;
import DAO.MoradorDAO;
import DAO.PessoaDAO;
import Models.Apartamento;
import Models.Morador;
import Models.Pessoa;

public class MoradorController {

	public Morador criar(String cpf, int id_apartamento){

		try {
			Pessoa p = PessoaDAO.getInstance().buscar(cpf);
			Apartamento a = ApartamentoDAO.getInstance().buscar(id_apartamento);

			if(p != null && a != null) {
				Morador morador = new Morador(p, a);
				MoradorDAO.getInstance().salvar(morador);
				System.out.println("Salvo morador " + morador.getPessoa().getNome() +  " com sucesso: ");
				return morador;
			}else {
				System.out.println("Erro ao salvar, não foi possivel encontrar pessoa ou apartamento com esses dados");
				return null;
			}

		} catch (Exception e) {
			System.out.println("Erro ao salvar morador");
			e.printStackTrace();
			return null;
		}
	}

	public List<Morador> listar(){
		try {
			List<Morador> m = MoradorDAO.getInstance().listar();
			System.out.println("Lido com sucesso! Resultados: " + m.size());
			return m;
		} catch (Exception eListar) {
			System.out.println("Erro ao listar Morador(es)!");
			return null;
		}

	}

	public Morador buscar(String cpf){
		try {
			Morador m = MoradorDAO.getInstance().buscar(cpf);
			System.out.println("Encontrado morador com sucesso: " + m.getPessoa().getNome());
			return m;
		} catch (Exception eBuscar) {
			System.out.println("Erro ao buscar Morador!");
			return null;
		}
	}

	//atualizar morador somente mudar o apartamento
	public Morador atualizar(String cpf, int id_apartamento_novo){
		Morador m = null;
		Apartamento apt_novo = null;
		try {
			apt_novo = ApartamentoDAO.getInstance().buscar(id_apartamento_novo);
			System.out.println(apt_novo);
		} catch (Exception e) {
			System.out.println("Erro ao buscar apartamento novo");
			e.printStackTrace();
			return null;
		}
		try {
			m = MoradorDAO.getInstance().buscar(cpf);
		} catch (Exception e) {
			System.out.println("Erro ao buscar morador com cpf informado");
			e.printStackTrace();
			return null;
		}

		if(apt_novo == null || m == null) {
			System.out.println("Erro ao atualiza morador com cpf/id informado");
			return null;
		}else {

			try {
				Morador morador_atualizado = new Morador(m.getPessoa(), apt_novo);
				morador_atualizado = MoradorDAO.getInstance().atualizar(morador_atualizado);
				System.out.println("Morador atualizado");
				return morador_atualizado;
			} catch (Exception eBuscar) {
				System.out.println("Erro ao atualizar morador");
				return null;
			}
		}
	}

	public void deletar(String cpf){
		try {
			MoradorDAO.getInstance().deletar(cpf);
			System.out.println("Morador deletado com sucesso!");
		} catch (Exception e) {
			//e.printStackTrace(); //definir se vai mostrar o erro
			System.out.println("Erro ao deletar morador");
		}


	}

}
