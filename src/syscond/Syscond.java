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
		
		EstoqueDAO estoque = EstoqueDAO.getInstance();
		FuncionarioDAO funcionario = FuncionarioDAO.getInstance();
		FuncionarioExternoDAO funcionarioExterno = FuncionarioExternoDAO.getInstance();
		LocacaoDAO locacao = LocacaoDAO.getInstance();
		MoradorDAO morador = MoradorDAO.getInstance();
		PessoaDAO pessoa = PessoaDAO.getInstance();
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
		
	}
}
