package br.upe.syscond.controllers;

import java.util.List;

import br.upe.syscond.models.Morador;

public interface InterfaceMoradorController {
	public Morador criar(Morador morador);
	public List<Morador> listar();
	public Morador buscar(Morador morador);
	public Morador atualizar(Morador novo);
	public boolean deletar(Morador morador);

}
