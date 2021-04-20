package br.upe.Controllers.Interface;

import java.util.List;

import br.upe.Models.Empresa;

public interface InterfaceEmpresaController {
	public Empresa criar(Empresa empresa);
	public List<Empresa> listar();
	public Empresa buscar(String cnpj);
	public Empresa atualizar(Empresa empresa);
	public void deletar(String cnpj);

}