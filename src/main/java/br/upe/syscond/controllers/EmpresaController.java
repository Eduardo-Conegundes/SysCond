package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.EmpresaDAO;
import br.upe.syscond.dao.InterfaceEmpresa;
import br.upe.syscond.models.Empresa;

public class EmpresaController implements InterfaceEmpresaController {

	private static InterfaceEmpresa empresaDAO = EmpresaDAO.getInstance();

	/**
	 * @param Empresa
	 * @return Empresa
	 * @throws Exception 
	 */
	public Empresa criar(Empresa empresa) throws Exception{
		return empresaDAO.salvar(empresa);
	}

	/**
	 * @return Empresa[]
	 * @throws Exception 
	 */
	public List<Empresa> listar() throws Exception{
		return empresaDAO.listar();
	}

	/**
	 * @param Empresa
	 * @return Empresa
	 * @throws Exception 
	 */
	public Empresa buscar(Empresa buscar) throws Exception{
		return empresaDAO.buscar(buscar);
	}

	/**
	 * @param Empresa empresaAntiga
	 * @param Empresa nova
	 * @return Empresa
	 * @throws Exception 
	 */
	public Empresa atualizar(Empresa nova) throws Exception{
		return empresaDAO.atualizar(nova);
	}
	/**
	 * @param Empresa
	 * @return boolean
	 * @throws Exception 
	 */
	public void deletar(Empresa empresa) throws Exception{
		empresaDAO.deletar(empresa);
	}
}
