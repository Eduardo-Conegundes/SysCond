package br.upe.syscond.controllers;

import java.util.ArrayList;
import java.util.List;

import br.upe.syscond.models.Apartamento;

public interface InterfaceApartamentoController {
	public Apartamento criar(Apartamento apartamento);
	public List<Apartamento> listar();
	public List<Apartamento> listar(String bloco);
	public Apartamento buscar(Apartamento apartamento);
	public Apartamento atualizar(Apartamento novo);
	public boolean deletar(Apartamento apartamento);
	public ArrayList<String> listarNumeros();
	public ArrayList<String> listarBlocos();
	public ArrayList<String> listaNumeros(String bloco);
	public Apartamento buscar(String bloco, int numero);

}
