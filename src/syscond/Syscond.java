package syscond;

import Controllers.*;
import Models.Apartamento;
import Models.Morador;
import Models.Pessoa;
import Models.Veiculo;

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
		
	}
}
