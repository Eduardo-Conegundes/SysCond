package br.upe.Controllers.Interface;

import java.util.List;

import br.upe.Models.ServicoProduto;

public interface InterfaceServicoProdutoController {
	public ServicoProduto criar(ServicoProduto servicoProduto);
	public List<ServicoProduto> listar();
	public ServicoProduto buscar(int id);
	public List<ServicoProduto> listar(String cnpj);
	public ServicoProduto atualizar(ServicoProduto servicoProduto, int id);
	public void deletar(int id);

}
