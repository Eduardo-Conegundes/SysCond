package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.ApartamentoDAO;
import br.upe.syscond.dao.MoradorDAO;
import br.upe.syscond.models.Apartamento;
import br.upe.syscond.models.Morador;
import br.upe.syscond.models.Pessoa;

public class MoradorController implements InterfaceMoradorController{

	public Morador criar(Morador morador){
		Pessoa pessoa = morador.getPessoa();
		Apartamento apartamento = morador.getApartamento();
		
		InterfacePessoaController pController = new PessoaController();
		InterfaceApartamentoController aptController = new ApartamentoController();
		
		try {
			Pessoa pessoaBanco = pController.buscar(pessoa.getCpf());
			Apartamento apartamentoBanco = aptController.buscar(apartamento);
			
			if(pessoaBanco != null && apartamentoBanco != null) {
				Morador salvo = MoradorDAO.getInstance().salvar(morador);
				return salvo;
			}else {
				System.err.println("Erro ao salvar, não foi possivel encontrar pessoa ou apartamento com esses dados!!!");
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
			return m;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar Morador(es)!");
			return null;
		}
	}

	public Morador buscar(String cpf){
		try {
			Morador m = MoradorDAO.getInstance().buscar(cpf);
			return m;
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar Morador!");
			return null;
		}
	}

	public Morador atualizar(Morador morador){
	//	String cpf, int id_apartamento_novo
		Morador m = null;
		Apartamento apt_novo = null;
		try {
			apt_novo = ApartamentoDAO.getInstance().buscar(morador.getApartamento().getId());
		} catch (Exception e) {
			System.err.println("Erro ao buscar apartamento novo");
			e.printStackTrace();
			return null;
		}
		
		try {
			m = MoradorDAO.getInstance().buscar(morador.getPessoa().getCpf());
		} catch (Exception e) {
			System.err.println("Erro ao buscar morador com cpf informado");
			e.printStackTrace();
			return null;
		}

		if(apt_novo == null || m == null) {
			return null;
		}else {
			try {
				Morador morador_atualizado = new Morador(m.getPessoa(), apt_novo);
				System.out.println("Morador atualizado");
				return morador_atualizado;
			} catch (Exception eBuscar) {
				System.err.println("Erro ao atualizar morador");
				return null;
			}
		}
	}

	public boolean deletar(Morador morador){
		String cpf = morador.getPessoa().getCpf();
		try {
			MoradorDAO.getInstance().deletar(cpf);
			return true;
		} catch (Exception eDeletar) {
			System.err.println("Erro ao deletar morador");
			return true;
		}
	}

}
