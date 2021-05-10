package br.upe.syscond.controllers;

import java.util.List;
import br.upe.syscond.dao.EmpresaDAO;
import br.upe.syscond.dao.InterfaceEmpresa;
import br.upe.syscond.models.Empresa;

public class EmpresaController implements InterfaceEmpresaController {
	
	/**
	*@Variavel --> variavel statica global do tipo apartamento, que recebe um apartamentoDAO
	*/
	static InterfaceEmpresa empresaDAO = EmpresaDAO.getInstance();
	
	/**
	 * @param Empresa
	 * @return Empresa
	 */
	public Empresa criar(Empresa empresa)throws Exception{
		return empresaDAO.salvar(empresa);
	}
	/**
	 * @return Empresa[]
	 */
	public List<Empresa> listar()throws Exception{
		return empresaDAO.listar();
	}
	/**
	 * @param Empresa
	 * @return Empresa
	 */
	public Empresa buscar(Empresa buscar)throws Exception{
		return empresaDAO.buscar(buscar);
	}
	
	/**
	 * @param Empresa empresaAntiga
	 * @param Empresa nova
	 * @return Empresa
	 */
	public Empresa atualizar(Empresa empresaAntiga)throws Exception{		
		return empresaDAO.atualizar(empresaAntiga);
	}
	/**
	 * @param Empresa
	 * @return boolean
	 */
	public void deletar(Empresa empresa)throws Exception{
		 empresaDAO.deletar(empresa);
	
	}
}
