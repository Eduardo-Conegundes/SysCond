package Controllers;

import java.util.ArrayList;
import java.util.List;

import Controllers.Interface.InterfaceServicoProdutoController;
import DAO.EmpresaDAO;
import DAO.ServicoProdutoDAO;
import Models.Empresa;
import Models.ServicoProduto;

public class ServicoProdutoController implements InterfaceServicoProdutoController {
	public ServicoProduto criar(ServicoProduto servicoProduto){

		Empresa empresa = null;

		try {
			empresa = EmpresaDAO.getInstance().buscar(servicoProduto.getEmpresa().getCnpj());			
		} catch (Exception e) {
			System.err.println("Erro ao encontrar empresa!");
			return null;
		}

		if(empresa == null) {
			System.out.println("Erro ao encontrar empresa!");
			EmpresaController empCont = new EmpresaController();
			empCont.criar(servicoProduto.getEmpresa());

		}
		
		// verificar duplicidade de ServicoProduto
		try {
			ServicoProduto p = ServicoProdutoDAO.getInstance().salvar(servicoProduto);
			System.out.println("Salvo " + servicoProduto.getNome() + " com sucesso");
			return p;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao salvar Servico/Produto!");
			return null;
		}
	}

	public List<ServicoProduto> listar(){
		try {
			List<ServicoProduto> l = ServicoProdutoDAO.getInstance().listar();
			System.out.println("Listar com sucesso: " + l.size());
			return l;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar ServicoProduto(s)!");
			return null;
		}

	}

	public ServicoProduto buscar(int id){
		try {
			ServicoProduto b = ServicoProdutoDAO.getInstance().buscar(id);
			System.out.println("Achado com sucesso: " + b.getNome());
			return b;
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar Servico ou Produto!");
			return null;
		}
	}

	public List<ServicoProduto> listar(String cnpj) {

		List<ServicoProduto> l = null;
		List<ServicoProduto> servCnpj = new ArrayList<ServicoProduto>();

		try {
			l = ServicoProdutoDAO.getInstance().listar();	
		} catch (Exception eListar) {
			System.err.println("Erro ao listar Servico ou Produto(s)!");
			return null;
		}
		for (int i = 0; i < l.size() ; i++) {
			if(l.get(i).getEmpresa().getCnpj().compareTo(cnpj) == 0) {

				servCnpj.add(l.get(i));

			}

		}
		return servCnpj;

	}

	public ServicoProduto atualizar(ServicoProduto servicoProduto, int id){

		try {
			servicoProduto = ServicoProdutoDAO.getInstance().buscar(id);			
		} catch (Exception e) {
			System.err.println("Erro ao buscar Servico/Produto");
			return null;
		}

		if (servicoProduto==null) {
			System.err.println("ServicoProduto não encontrado");
			return null;
		}
		
		servicoProduto.setId(id);

		try {
			ServicoProduto a = ServicoProdutoDAO.getInstance().atualizar(servicoProduto);
			System.out.println("Atualizado com sucesso: " + a.getNome());
			return a;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao atualizar ServicoProduto!");
			return null;
		}
	}

	public void deletar(int id){
		try {
			ServicoProdutoDAO.getInstance().deletar(id);
			System.out.println("Excluído com sucesso");
		} catch (Exception eDeletar) {
			System.err.println("Erro ao excluir ServicoProduto!");
		}
	}
}
