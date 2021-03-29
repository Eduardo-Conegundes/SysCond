package syscond;

import java.util.List;

import DAO.*;
import DAO.Interface.*;
import Models.*;

import java.util.ArrayList;
import java.util.Calendar;

public class Syscond {

	public static void main(String[] args) {

		// O que falta= fazer fluxo de estoque(Augusto?)

		//CRIA INSTANCIAS
		
		LocacaoDAO locacao = LocacaoDAO.getInstance();
		MoradorDAO morador = MoradorDAO.getInstance();
		ServicoProdutoDAO servProd = ServicoProdutoDAO.getInstance();
		UsuarioDAO usuario = UsuarioDAO.getInstance();
		VeiculoDAO veiculo = VeiculoDAO.getInstance();
		VisitanteDAO visitante = VisitanteDAO.getInstance();

		//############### APARTAMENTO  #############
		InterfaceApartamento apartamento = ApartamentoDAO.getInstance();
		Apartamento ap1 = new Apartamento("A", 01, 02);
		Apartamento ap2 = new Apartamento("B", 01, 03);
		Apartamento ap3 = new Apartamento("A", 01, 03);

		//apartamento.salvar(ap1);//salva apartamento
		//apartamento.salvar(ap2);//salva apartamento
		//apartamento.atualizar(ap3);//precisa revisar como vai ser a atualização
		//apartamento.deletar("A", 01);//deleta apartamento
		//List<Apartamento> listap = apartamento.listar();
		//for (Apartamento a : listap) {
		//	System.out.println(a.getBloco());
		//}

		//############ CONTAS ####################
		InterfaceContas contas = ContasDAO.getInstance();//instancia contas

		Calendar data = Calendar.getInstance();
		data.set(2021,3,27);

		Contas conta1 = new Contas("a pagar", "Água", "Usuario", "Compesa", (float)89.90, data);
		Contas conta2 = new Contas("a pagar","Energia", "Pessoa", "Celpe", (float)85.50, data);
		Contas conta3 = new Contas("a pagar","Internet", "Morador", "GVT", (float)55.50, data);

		//Contas contaAtualizar = contas.listarId(1);
		//contaAtualizar.setBeneficiario("jbvslvd");
		//contas.salvar(conta1);
		//contas.salvar(conta2);
		//contas.salvar(conta3);
		//contas.atualizar(contaAtualizar);
		//contas.deletar(3);//remove a conta do id fornecido
		//		List<Contas> listaConta = contas.listar();
		//		for (Contas a : listaConta) {
		//			System.out.println(a.getValor());
		//		}
		//######## EMPRESA ##############'
		InterfaceEmpresa empresa = EmpresaDAO.getInstance();//instancia contas

		Empresa empresa1 = new Empresa("12345","Vivo","prestador de servico", "8137225544");
		Empresa empresa2 = new Empresa("12346","GVT","prestador de servico", "1234567890");

		//Empresa empresaAtt = empresa.listarId("12345");
		//empresaAtt.setTipo("servi");

		//empresa.salvar(empresa1);
		//empresa.salvar(empresa2);
		//empresa.atualizar(empresaAtt);
		//empresa.deletar("12345");//remove a empresa com id fornecido
		//		List<Empresa> listaEmpresa = empresa.listar();
		//		for (Empresa a : listaEmpresa) {
		//			System.out.println(a.getNome());
		//		}
		
		
		//######### CONTABIL ##############
		InterfaceContabil contabilidade = ContabilDAO.getInstance();//instancia contabil
		//List<Contas> arraycontas = new ArrayList();
		//arraycontas.add(conta1);
		//arraycontas.add(conta2);
		//arraycontas.add(conta3);
		
		//Contabil contab = new Contabil(arraycontas, (float)1000.00);

		//contabilidade.salvar(contab);
		//contabilidade.atualizar(contab);// FALTA TESTAR
		//contabilidade.deletar(8);//remove a empresa com id fornecido
//		List<Contabil> listaContabil = contabilidade.listar();
//		for (Contabil a : listaContabil) {
//			System.out.println(a.getSaldo());
//		}
		
		//######## ESPAÇO ###############
		EspacoDAO espaco = EspacoDAO.getInstance();
		Espaco esp1 = new Espaco("Salao", 65);
		Espaco esp2 = new Espaco("cinema", 32);
		
		//espaco.salvar(esp1);
		espaco.salvar(esp2);
		//espaco.atualizar(esp1);// FALTA TESTAR
		//espaco.deletar(0);//remove a empresa com id fornecido
		List<Espaco> listaEspaco = espaco.listar();
		for (Espaco a : listaEspaco) {
			System.out.println(a.getNome());
		}		
		
		//######## PESSOA ###############
		PessoaDAO pessoa = PessoaDAO.getInstance();
		Pessoa pessoa1 = new Pessoa("Joao", "099.999.999-00", "81991919191", "joao@email.com.br");
		Pessoa pessoa2 = new Pessoa("Luiz", "699.699.699-60", "81992929292", "luiz@email.com.br");
		Pessoa pessoa3 = new Pessoa("Flavio", "299.299.299-20", "81993939393", "flavio@email.com.br");
		Pessoa pessoa4 = new Pessoa("Andre", "399.399.399-30", "81994949494", "andre@email.com.br");
		Pessoa pessoa5 = new Pessoa("Augusto", "499.499.499-40", "81995959595", "augusto@email.com.br");
		
		//pessoa.salvar(pessoa1);
		pessoa.salvar(pessoa2);
		//pessoa.atualizar(pessoa1);
		//pessoa.deletarPorId("699.699.699-60");
		List<Pessoa> listaPessoas = pessoa.listar();
		for (Pessoa a : listaPessoas) {
			System.out.println(a.getNome());
		}
		
		
		//######## FUNCIONARIO ###############
		FuncionarioDAO funcionario = FuncionarioDAO.getInstance();
		Funcionario funcionario1 = new Funcionario(pessoa1, "porteiro", (float) 1045.00);
		Funcionario funcionario2 = new Funcionario(pessoa2, "vigilante", (float) 1245.00);
		Funcionario funcionario3 = new Funcionario(pessoa5, "auxiliar de estoque", (float) 1245.00);
		
		//funcionario.salvar(funcionario1);
		//funcionario.salvar(funcionario2);
		//funcionario.atualizar(funcionario1);
		//funcionario.deletar("099.999.999-00");
		List<Funcionario> listaFuncionario = funcionario.listar();
		for (Funcionario a : listaFuncionario) {
			System.out.println(a.getPessoa().getNome());
		}
		
		//######## FUNCIONARIO EXTERNO ###############
		FuncionarioExternoDAO funcionarioExterno = FuncionarioExternoDAO.getInstance();
		FuncionarioExterno funcionarioExt1 = new FuncionarioExterno(pessoa3, empresa1);
		FuncionarioExterno funcionarioExt2 = new FuncionarioExterno(pessoa4, empresa2);
				
		//funcionarioExterno.salvar(funcionarioExt1);
		funcionarioExterno.salvar(funcionarioExt1);
		funcionarioExterno.salvar(funcionarioExt2);
		//funcionarioExterno.atualizar(funcionarioExt1);
		//funcionarioExterno.deletar("299.299.299-20");
		List<FuncionarioExterno> listaFuncExt = funcionarioExterno.listar();
		for (FuncionarioExterno a : listaFuncExt) {
			System.out.println(a.getPessoa().getNome());
		}
		
		//######## ESTOQUE ###############
		EstoqueDAO estoque = EstoqueDAO.getInstance();
		Estoque estoque1 = new Estoque(funcionario3);
		
		//estoque.salvar(estoque1);
		estoque.atualizar(estoque1);
		//estoque.deletar(estoque1);
		List<Estoque> listaEstoque = estoque.listar();
		for (Estoque a : listaEstoque) {
			System.out.println(a.getPessoa().getPessoa().getNome());
		}
		
		
	}
}
