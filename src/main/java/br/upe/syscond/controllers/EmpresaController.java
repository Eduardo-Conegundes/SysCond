package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.EmpresaDAO;
import br.upe.syscond.models.Empresa;
import br.upe.syscond.models.ServicoProduto;

public class EmpresaController implements InterfaceEmpresaController {
	//RESOLVER TUDO
	public Empresa criar(Empresa empresa){

		ServicoProdutoController controlador = new ServicoProdutoController();
		List<ServicoProduto> empServ = empresa.getServicoproduto();
		List<ServicoProduto> empServBD = controlador.listar(empresa.getCnpj());
		List<Empresa> empresas = this.listar();

		if(empresas.contains(empresa)) { //VERIFICANDO SE EMPRESA J� EXISTE
			System.out.println("Empresa j� cadastrada!!! ");
			return null;
		}else { //CASO N�O EXISTA...
			if(empServBD.size() == 0) { 
				if(empServ.size() == 0) {
					return null;
				}else {
					for (int i = 0; i < empServ.size(); i++) {
						controlador.criar(empServ.get(i));

					}
				}
			}
		}

		try {
			Empresa p = EmpresaDAO.getInstance().salvar(empresa);
			return p;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao salvar Empresa!");
			return null;
		}
	}

	public List<Empresa> listar(){
		try {
			List<Empresa> l = EmpresaDAO.getInstance().listar();
			return l;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar Empresa(s)!");
			return null;
		}

	}

	public Empresa buscar(String cnpj){
		try {
			Empresa b = EmpresaDAO.getInstance().buscar(cnpj);
			return b;
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar Empresa!");
			return null;
		}
	}

	//atualiza qualquer campo da empresa, menos o cnpj
	public Empresa atualizar(Empresa empresa){
		Empresa empresa_encontrada = null;

		try {
			empresa_encontrada = EmpresaDAO.getInstance().buscar(empresa.getCnpj());
		} catch (Exception eBuscar) {
			System.err.println("Erro, n�o encontrada empresa com cnpj informado!");
			return null;
		}

		if (empresa_encontrada == null) {
			System.err.println("Erro, n�o encontrada empresa com cnpj informado!");
			return null;
		}
		
		try {
			Empresa atualizada = EmpresaDAO.getInstance().atualizar(empresa);
			return atualizada;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao atualizar Empresa!");
			return null;
		}

	}

	public void deletar(String cnpj){
		try {
			EmpresaDAO.getInstance().deletar(cnpj);
		} catch (Exception e) {
			System.err.println("Erro ao excluir Empresa!");
		}
	}
}
