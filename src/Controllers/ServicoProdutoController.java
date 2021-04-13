package Controllers;

import java.util.List;

import DAO.EmpresaDAO;
import DAO.ServicoProdutoDAO;
import Models.Empresa;
import Models.ServicoProduto;

public class ServicoProdutoController {
	public ServicoProduto criar(String nome, float valor, String cnpj, String categoria){
		Empresa empresa = null;
		try {
			empresa = EmpresaDAO.getInstance().buscar(cnpj);			
		} catch (Exception e) {
			System.out.println("Erro ao encontrar empresa!");
			return null;
		}

		if(empresa == null) {
			System.out.println("Erro ao encontrar empresa!");
		}else {
			ServicoProduto ServicoProduto = new ServicoProduto(nome, valor, empresa, categoria);
			try {
				ServicoProduto p = ServicoProdutoDAO.getInstance().salvar(ServicoProduto);
				System.out.println("Salvo " + ServicoProduto.getNome() + " com sucesso");
				return p;
			} catch (Exception eSalvar) {
				System.out.println("Erro ao salvar Servico/Produto!");
				return null;
			}
		}
		return null;
	}

	public List<ServicoProduto> listar(){
		try {
			List<ServicoProduto> l = ServicoProdutoDAO.getInstance().listar();
			System.out.println("Listar com sucesso: " + l.size());
			return l;
		} catch (Exception eListar) {
			System.out.println("Erro ao listar ServicoProduto(s)!");
			return null;
		}

	}

	public ServicoProduto buscar(int id){
		try {
			ServicoProduto b = ServicoProdutoDAO.getInstance().buscar(id);
			System.out.println("Achado com sucesso: " + b.getNome());
			return b;
		} catch (Exception eBuscar) {
			System.out.println("Erro ao buscar ServicoProduto!");
			return null;
		}
	}

	public ServicoProduto atualizar(int id, String nome, float valor, String cnpj, String categoria){
		
		ServicoProduto servicoProduto = null;
		try {
			servicoProduto = ServicoProdutoDAO.getInstance().buscar(id);			
		} catch (Exception e) {
			System.out.println("Erro ao buscar Servico/Produto");
			return null;
		}

		if (servicoProduto==null) {
			System.out.println("ServicoProduto não encontrado");
			return null;
		}		
		servicoProduto.setCategoria(categoria);
		servicoProduto.setNome(nome);
		servicoProduto.setValor(valor);
		
		try {
			Empresa empresa = EmpresaDAO.getInstance().buscar(cnpj);
			servicoProduto.setEmpresa(empresa);
		} catch (Exception e) {
			System.out.println("Erro ao encontrar empresa");
			return null;
		}
		
		try {
			ServicoProduto a = ServicoProdutoDAO.getInstance().atualizar(servicoProduto);
			System.out.println("Atualizado com sucesso: " + a.getNome());
			return a;
		} catch (Exception eSalvar) {
			System.out.println("Erro ao atualizar ServicoProduto!");
			return null;
		}
	}

	public void deletar(int id){
		try {
			ServicoProdutoDAO.getInstance().deletar(id);
			System.out.println("Excluído com sucesso");
		} catch (Exception e) {
			System.out.println("Erro ao excluir ServicoProduto!");
		}
	}
}
