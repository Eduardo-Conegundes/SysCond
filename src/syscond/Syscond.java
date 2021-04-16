package syscond;

import java.util.ArrayList;
import java.util.Calendar;

import Controllers.*;
import Models.*;

public class Syscond {

	public static void main(String[] args) {
		Pessoa p;
		PessoaController pessoaController = new PessoaController();
//		pessoaController.criar("Flavio", "299.299.299-20", "81993939393", "flavio@email.com.br");
//		p = pessoaController.atualizar("Flávio", "299.299.299-20", "81993939290", "flavio@upe.br");
//		pessoaController.deletarPorId("299.299.299-20");
//		pessoaController.listar();
		
		Apartamento ap = new Apartamento("B",203,1);
		ApartamentoController apartamentoController = new ApartamentoController();
		ap.setId(1); //???
//		apartamentoController.criar(ap);
//		apartamentoController.criar("A",404,1);
//		apartamentoController.criar("B",504,1);
//		apartamentoController.criar("B",504,1);
//		ap = apartamentoController.atualizar(ap);
//		apartamentoController.deletar(ap);
//		ArrayList<Apartamento> listarAps = (ArrayList<Apartamento>) apartamentoController.listar();
		
		
		Veiculo vei1;
		VeiculoController veiculoController = new VeiculoController();
//		veiculoController.criar("PCS6969", 1);
//		veiculoController.criar("PAU6969", 2);
//		vei1 = veiculoController.atualizar("PCS6969", 3);
		
		Morador mor1;
		MoradorController moradorController = new MoradorController();
//		moradorController.criar("299.299.299-20", 2);
//		moradorController.atualizar("299.299.299-20", 2);
//		moradorController.deletar("299.299.299-20");
		
		Empresa emp1;
		EmpresaController empresaController = new EmpresaController();
//		empresaController.criar("123456789-10", "UPE", "Educação", "81-37215060");
//		empresaController.criar("123456789-20", "UFPE", "Educação", "81-37215065");
//		empresaController.atualizar("123456789-10", "FACULDADE", "Educação", "81-37215060");
//		empresaController.deletar("123456789-10");
		
		Funcionario fun1;
		FuncionarioController funcionarioController = new FuncionarioController();
//		funcionarioController.criar("299.299.299-20", "interno", "jardineiro", 0);
//		funcionarioController.atualizar("299.299.299-20", "interno", "copeiro", 0);
//		funcionarioController.deletar("299.299.299-20");
		
		ServicoProduto serpro1;
		ServicoProdutoController servCont = new ServicoProdutoController();
//		servCont.criar("Jardinagem", 0, "123456789-20", "teste");
//		servCont.atualizar(1, "teste", 0, "123456789-21", "test");
//		servCont.deletar(1);
		
		Usuario user1;
		UsuarioController userCont = new UsuarioController();
//		userCont.criar("augustotrabalhador@upe.br", "fazdetudo", "cornoPleno");
//		userCont.atualizar(2, "augustotrabalhador@upe.br", "fazdetudo", "cornoMaster");
//		userCont.deletar(2);
		
		Locacao loc1;
		LocacaoController locCont = new LocacaoController();
//		locCont.criar(null, "299.299.299-20", "Jabuti", (float)500.00);
//		locCont.atualizar(1, null, "299.299.299-20", "NAJA", (float)10000.00);
//		locCont.deletar(3);
//		locCont.listar();
		
		Visitante vst1;
		VisitanteController vCont = new VisitanteController();
//		vCont.criar("299.299.299-20", 1);
//		vCont.buscar("299.299.299-20");
//		vCont.deletar("299.299.299-20");
//		vCont.listar();
//		vCont.atualizar("299.299.299-20", 2);^
		
//		Contas cont1;
//		ContasController c1 = new ContasController();
		
//		Calendar dataEmissao = Calendar.getInstance();
//		dataEmissao.set(Calendar.YEAR, 2019);
//		dataEmissao.set(Calendar.MONTH, Calendar.AUGUST);
//		dataEmissao.set(Calendar.DAY_OF_MONTH, 30);
//		
//		Calendar dataVencimento = Calendar.getInstance();
//	    dataVencimento.set(Calendar.YEAR, 2025);
//		dataVencimento.set(Calendar.MONTH, Calendar.DECEMBER);
//		dataVencimento.set(Calendar.DAY_OF_MONTH, 31);

//		cont1 = c1.criar("aviao", "Sivonaldo Aeronautica", "Condominio", (float) 100000.0, dataEmissao, dataVencimento, false);
//		cont1 = c1.criar("FLAVIO", "NAO PEGUE NO MEU PEITO", "UPE", (float) 500000.0, dataEmissao, dataVencimento, false);
		
//		cont1 = c1.buscar(1);

//		cont1 = c1.atualizar(2, "Carrinho de Golf", "Sivonaldo Aeronautica", "Condominio", (float) 100000.0, dataEmissao, dataVencimento, false);
		
//		c1.deletar(1);
		
		ArrayList<Contas> contas = new ArrayList<Contas>();
//	
		ContabilController a1 = new ContabilController();
		a1.criar(new Contabil(contas, (float)100.0)); //FALTA AJUSTAR CONTROLLER (VERIFICAR SE CONTA EXISTE NO BANCO PARA SALVAR) 
//		a1.buscar(1);
//		a1.atualizar(1, contas);
//		a1.deletar(1);
		
//		Contas Contas = new Contas(identificador, pagador, beneficiario, valor, dataEmissao, dataVencimento, AReceber);
		
	}
}
