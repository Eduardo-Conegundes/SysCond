package Controllers;

import java.util.List;

import DAO.ContabilDAO;
import Models.Contabil;
import Models.Contas;

public class ContabilController {

	public Contabil criar(Contabil contabil){
		ContasController controlador = new ContasController();
		List<Contas> contas = contabil.getContas();
		List<Contas> contBank = controlador.listar();
		Contabil p = null;
		


		if(contBank.size() == 0) {
			System.out.println("Não há nenhuma conta cadastrada no banco de dados!!! "); //caso não exista contas no BD
			if(contas.size() == 0) {
				System.out.println("Não há nenhuma conta para cadastrar!!! ");
				return null;
			}else {
				for(int i = 0; i < contas.size(); i++) {
					controlador.criar(contas.get(i));
				}
			}

		}else {
			for (int i = 0; i < contBank.size(); i++) {

				//procura se existe algum apartamento com o bloco e numero já cadastrado
				if(!(contBank.contains(contas.get(i)))) {
					controlador.criar(contas.get(i));
				} else {
					System.out.println("Conta já existe!!! ");
				}

			}
			try {
				p = ContabilDAO.getInstance().salvar(contabil);
				System.out.println("Salvo com sucesso!!!" );
				return p;
			} catch (Exception eSalvar) {
				System.out.println("Erro ao salvar Contabil!");
				return null;
			}	
		}
		return p;
	}

	public List<Contabil> listar(){
		try {
			List<Contabil> l = ContabilDAO.getInstance().listar();
			System.out.println("Lido com sucesso! Resultados: " + l.size());
			return l;
		} catch (Exception eListar) {
			eListar.printStackTrace();
			System.out.println("Erro ao listar Contabil(s)!");
			return null;
		}

	}

	public Contabil buscar(int id){
		try {
			Contabil b = ContabilDAO.getInstance().buscar(id);
			System.out.println("Contabil achado com sucesso: " + b.getId());
			return b;
		} catch (Exception eBuscar) {
			System.out.println("Erro ao buscar Contabil!");
			return null;
		}
	}

	public Contabil atualizar(int id,List<Contas> contas){
		Contabil b = null;
		try {
			b = ContabilDAO.getInstance().buscar(id);
		} catch (Exception eBuscar) {
			System.out.println("Erro ao buscar Contabil!");
			return null;
		}

		if (b==null) {
			System.out.println("Contabil não encontrado.");
			return null;
		}

		Contabil Contabil2 = new Contabil(contas, b.getSaldo());
		Contabil2.setId(id);
		try {
			Contabil a = ContabilDAO.getInstance().atualizar(Contabil2);
			System.out.println("Atualizado com sucesso!" + a.getId());
			return a;
		} catch (Exception eAtualizar) {
			System.out.println("Erro ao atualizar Contabil!");
			return null;
		}
	}

	public void deletar(int id){
		try {
			ContabilDAO.getInstance().deletar(id);
			System.out.println("Excluído com sucesso");
		} catch (Exception eDeletar) {
			System.out.println("Erro ao excluir Contabil!");
		}
	}
}
