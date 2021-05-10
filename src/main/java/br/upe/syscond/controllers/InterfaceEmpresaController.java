package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.models.Empresa;

public interface InterfaceEmpresaController {
	public Empresa criar(Empresa empresa) throws Exception;
	public List<Empresa> listar() throws Exception;
	public Empresa buscar(Empresa empresa) throws Exception;
	public Empresa atualizar(Empresa nova) throws Exception;
	public void deletar(Empresa empresa) throws Exception;

}
