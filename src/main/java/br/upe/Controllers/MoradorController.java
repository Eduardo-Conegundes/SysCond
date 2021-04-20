package br.upe.Controllers;

import java.util.List;

import br.upe.Controllers.Interface.InterfaceMoradorController;
import br.upe.DAO.ApartamentoDAO;
import br.upe.DAO.MoradorDAO;
import br.upe.DAO.PessoaDAO;
import br.upe.Models.Apartamento;
import br.upe.Models.Morador;
import br.upe.Models.Pessoa;

public class MoradorController implements InterfaceMoradorController{

	public Morador criar(String cpf, int id_apartamento){
		try {
			Pessoa p = PessoaDAO.getInstance().buscar(cpf);
			Apartamento a = ApartamentoDAO.getInstance().buscar(id_apartamento);

			if(p != null && a != null) {
				Morador morador = new Morador(p, a);
				MoradorDAO.getInstance().salvar(morador);
				System.out.println("Salvo morador " + morador.getPessoa().getNome() +  " com sucesso!!! ");
				return morador;
			}else {
				System.err.println("Erro ao salvar, n�o foi possivel encontrar pessoa ou apartamento com esses dados!!!");
				return null;
			}

		} catch (Exception eCriar) {
			System.err.println("Erro ao salvar morador");
			return null;
		}
	}

	public List<Morador> listar(){
		try {
			List<Morador> m = MoradorDAO.getInstance().listar();
			System.out.println("Lido com sucesso! Resultados: " + m.size());
			return m;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar Morador(es)!");
			return null;
		}
	}

	public Morador buscar(String cpf){
		try {
			Morador m = MoradorDAO.getInstance().buscar(cpf);
			System.out.println("Encontrado morador com sucesso: " + m.getPessoa().getNome());
			return m;
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar Morador!");
			return null;
		}
	}

	public Morador atualizar(String cpf, int id_apartamento_novo){
		Morador m = null;
		Apartamento apt_novo = null;
		try {
			apt_novo = ApartamentoDAO.getInstance().buscar(id_apartamento_novo);
			System.out.println(apt_novo);
		} catch (Exception e) {
			System.err.println("Erro ao buscar apartamento novo");
			e.printStackTrace();
			return null;
		}
		
		try {
			m = MoradorDAO.getInstance().buscar(cpf);
		} catch (Exception e) {
			System.err.println("Erro ao buscar morador com cpf informado");
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
				System.err.println("Erro ao atualizar morador");
				return null;
			}
		}
	}

	public void deletar(String cpf){
		try {
			MoradorDAO.getInstance().deletar(cpf);
			System.out.println("Morador deletado com sucesso!");
		} catch (Exception eDeletar) {
			System.err.println("Erro ao deletar morador");
		}
	}

}