package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.EmpresaDAO;
import br.upe.syscond.models.Empresa;

public class EmpresaController implements InterfaceEmpresaController {
	/**
	 * @param Empresa
	 * @return Empresa
	 */
	public Empresa criar(Empresa empresa){
		
		List<Empresa> empresas = this.listar();

		for (int i = 0; i < empresas.size(); i++) {
			if(empresas.get(i).equals(empresa)) {
				return null;
			}
		}
		try {
			Empresa criada = EmpresaDAO.getInstance().salvar(empresa);
			return criada;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao salvar Empresa!");
			return null;
		}
	}
	/**
	 * @return Empresa[]
	 */
	public List<Empresa> listar(){
		try {
			List<Empresa> l = EmpresaDAO.getInstance().listar();
			return l;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar Empresa(s)!");
			return null;
		}

	}
	/**
	 * @param Empresa
	 * @return Empresa
	 */
	public Empresa buscar(Empresa buscar){
		List<Empresa> empresas = this.listar();
		for (int i = 0; i < empresas.size(); i++) {
			if(empresas.get(i).getCnpj().compareTo(buscar.getCnpj())==0) {
				return empresas.get(i);
			}
		}
		return null;
	}
	/**
	 * @param Empresa empresaAntiga
	 * @param Empresa nova
	 * @return Empresa
	 */
	public Empresa atualizar(Empresa empresaAntiga, Empresa nova){
		
		if(this.buscar(empresaAntiga)!=null) {
			try {
				nova.setId(empresaAntiga.getId());
				Empresa atualizada = EmpresaDAO.getInstance().atualizar(nova);
				return atualizada;
			} catch (Exception eSalvar) {
				System.err.println("Erro sistema ao atualizar Empresa!");
				return null;
			}
		}
		return null;

	}
	/**
	 * @param Empresa
	 * @return boolean
	 */
	public boolean deletar(Empresa empresa){
		try {
			EmpresaDAO.getInstance().deletar(empresa.getId());
			return true;		
		} catch (Exception e) {
			System.err.println("Erro ao excluir Empresa!");
			return false;
		}
	}
}
