package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.dao.FuncionarioDAO;
import br.upe.syscond.dao.InterfaceFuncionario;
import br.upe.syscond.models.Funcionario;

public class FuncionarioController implements InterfaceFuncionarioController {
	static InterfaceFuncionario funcionarioDAO = FuncionarioDAO.getInstance();
	/**
	 * @param Funcionario
	 * @return Funcionario || null
	 * @throws Exception 
	 */
	public Funcionario criar(Funcionario funcionario) throws Exception{
		try {	 
			return funcionarioDAO.salvar(funcionario);
		} catch (Exception eSalvar) {
			throw eSalvar;
		}

	}
	/**
	 * @return Funcionario[] || null
	 * @throws Exception 
	 */
	public List<Funcionario> listar() throws Exception{
		try {
			return funcionarioDAO.listar();
		} catch (Exception eListar) {
			throw eListar;
		}
	}
	/**
	 * @param Funcionario
	 * @return Funcionario || null
	 * @throws Exception 
	 */
	public Funcionario buscar(Funcionario funcionario) throws Exception {
		try {
			return funcionarioDAO.buscar(funcionario);
		} catch (Exception eBuscar) {
			throw eBuscar;
		}
	}
	/**
	 * @param Funcionario
	 * @return Funcionario || null
	 * @throws Exception 
	 */
	public Funcionario atualizar(Funcionario funcionario) throws Exception{
		try{
			return funcionarioDAO.atualizar(funcionario);
		}catch (Exception eAtualizar) {
			throw eAtualizar;
		}
		
	}
	/**
	 * @param Funcionario
	 * @return boolean
	 * @throws Exception 
	 */
	public void deletar(Funcionario funcionario) throws Exception{
		try {
			funcionarioDAO.deletar(funcionario);
		} catch (Exception eDeletar) {
			throw eDeletar;
		}
	}
}
