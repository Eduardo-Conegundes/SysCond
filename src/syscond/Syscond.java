package syscond;

import Controllers.*;
import Models.*;

public class Syscond {

	public static void main(String[] args) {
		
		Usuario user = new Usuario("joaoneto@live.com","123456",
				"Estagiário de Trader");
		
		UsuarioController userCont = new UsuarioController();
		
//		userCont.criar(user);
//		userCont.atualizar(2, user);
//		userCont.deletar(2);
		
	}
}
