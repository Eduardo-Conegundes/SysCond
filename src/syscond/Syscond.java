package syscond;

import Controllers.*;
import Models.Apartamento;
import Models.Pessoa;

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
//		ap = apartamentoController.atualizar(1, "B", 202, 1);
//		apartamentoController.deletarPorId(1);
		
	}
}
