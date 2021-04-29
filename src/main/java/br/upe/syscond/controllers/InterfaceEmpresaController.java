package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.models.Empresa;

public interface InterfaceEmpresaController {
	public Empresa criar(Empresa empresa);
	public List<Empresa> listar();
	public Empresa buscar(String cnpj);
	public Empresa atualizar(Empresa empresa);
	public boolean deletar(Empresa empresa);

}
