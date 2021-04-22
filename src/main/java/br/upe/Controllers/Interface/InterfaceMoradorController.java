package br.upe.Controllers.Interface;

import java.util.List;

import br.upe.Models.Morador;

public interface InterfaceMoradorController {
	public Morador criar(Morador morador);
	public List<Morador> listar();
	public Morador buscar(String cpf);
	public Morador atualizar(String cpf, int id_apartamento_novo);
	public void deletar(String cpf);

}
