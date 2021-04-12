package Controllers;

import java.util.List;

import DAO.EmpresaDAO;
import Models.Empresa;

public class EmpresaController {
	
	public Empresa criar(String cnpj, String nome, String tipo, String telefone){
		
		Empresa Empresa = new Empresa(cnpj, nome, tipo, telefone);

		try {
			Empresa p = EmpresaDAO.getInstance().salvar(Empresa);
			System.out.println("Salvo " + p.getNome() + " com sucesso");
			return p;
		} catch (Exception eSalvar) {
			System.out.println("Erro ao salvar Empresa!");
			return null;
		}
	}

	public List<Empresa> listar(){
		try {
			List<Empresa> l = EmpresaDAO.getInstance().listar();
			System.out.println("Listar com sucesso: " + l.size());
			return l;
		} catch (Exception eListar) {
			System.out.println("Erro ao listar Empresa(s)!");
			return null;
		}

	}

	public Empresa buscar(String cnpj){
		try {
			Empresa b = EmpresaDAO.getInstance().buscar(cnpj);
			System.out.println("Achado com sucesso: " + b.getNome());
			return b;
		} catch (Exception eBuscar) {
			System.out.println("Erro ao buscar Empresa!");
			return null;
		}
	}
	
	//atualiza qualquer campo da empresa, menos o cnpj
	public Empresa atualizar(String cnpj, String nome, String tipo, String telefone){
		Empresa empresa_encontrada = null;
		
		try {
			empresa_encontrada = EmpresaDAO.getInstance().buscar(cnpj);
		} catch (Exception eBuscar) {
			System.out.println("Erro, não encontrada empresa com cnpj informado!");
			return null;
		}
		
		if (empresa_encontrada==null) {
			System.out.println("Erro, não encontrada empresa com cnpj informado!");
			return null;
		}else {
			Empresa empresa = new Empresa(cnpj, nome, tipo, telefone);
			try {
				Empresa atualizada = EmpresaDAO.getInstance().atualizar(empresa);
				System.out.println("Empresa atualizada com sucesso: " + atualizada.getNome());
				return atualizada;
			} catch (Exception eSalvar) {
				System.out.println("Erro ao atualizar Empresa!");
				return null;
			}
		}
	}

	public void deletar(String cnpj){
		try {
			EmpresaDAO.getInstance().deletar(cnpj);
			System.out.println("Excluído com sucesso");
		} catch (Exception e) {
			System.out.println("Erro ao excluir Empresa!");
		}
	}
}
