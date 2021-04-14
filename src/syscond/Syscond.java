package syscond;

import Controllers.*;
import Models.*;

public class Syscond {

	public static void main(String[] args) {
//		Pessoa p;
		PessoaController pessoaController = new PessoaController();
//		pessoaController.criar("Flavio", "299.299.299-20", "81993939393", "flavio@email.com.br");
//		p = pessoaController.atualizar("Flávio", "299.299.299-20", "81993939290", "flavio@upe.br");
//		pessoaController.deletarPorId("299.299.299-20");
		
		Apartamento ap;
		ApartamentoController apartamentoController = new ApartamentoController();
//		apartamentoController.criar("A",202,1);
//		apartamentoController.criar("A",404,1);
//		ap = apartamentoController.atualizar(1, "B", 202, 1);
//		apartamentoController.deletarPorId(1);
		
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
		userCont.criar("augustotrabalhador@upe.br", "fazdetudo", "cornoPleno");
		
		
	}
}
