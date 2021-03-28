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
		
		//######## SALVAR PESSOA ########
		Pessoa p = new Pessoa("LUCASo", "43521", "234", "FLM@gmail.com");
		//InterfacePessoa pessoa = new InterfacePessoa();

		//############### SALVAR APARTAMENTO  #############
		Apartamento j = new Apartamento("R", 2, 1);
		//ApartamentoDAO.getInstance().salvar(j);

		//############### SALVAR VEICULO  #############            
		Veiculo v = new Veiculo("YTG56", j);
		//VeiculoDAO.getInstance().salvar(v);

		//######## SALVAR FUNCIONARIO ########
		Funcionario F = new Funcionario(p, "conciege", (float) 3000.00);
		//FuncionarioDAO.getInstance().salvar(F);

		//######## SALVAR VISITANTE ########
		Visitante VI = new Visitante(p, j);
		//VisitanteDAO.getInstance().salvar(VI);

		//######## SALVAR USUARIO ########
		Usuario U = new Usuario(p, "COZINHEIRO");
		//UsuarioDAO.getInstance().salvar(U);

		//######## SALVAR SERVIÇO PRODUTO ########
		List<ServicoProduto> l = new ArrayList<ServicoProduto>();
		ServicoProduto sp = new ServicoProduto("jesus", (float) 3.50, "Refri");
		//ServicoProdutoDAO.getInstance().salvar(sp);

		ServicoProduto t = new ServicoProduto("coca", (float) 5.50, "Refri");
		//ServicoProdutoDAO.getInstance().salvar(t);
		l.add(sp);
		l.add(t);

		//######## SALVAR EMPRESA ########
		Empresa E = new Empresa("12345", l, "Empresa", "mercado", "8137228922");
		//EmpresaDAO.getInstance().salvar(E);

		//######## SALVAR FUNCIONARIO EXTERNO ########
		FuncionarioExterno FF = new FuncionarioExterno(p, E);
		//FuncionarioExternoDAO.getInstance().salvar(FF);

		//######## SALVAR ESPAÃ‡O ########
		Espaco Es = new Espaco("Salão", 56);
		//EspacoDAO.getInstance().salvar(Es);

		//######## SALVAR MORADOR ########
		Morador M = new Morador(p, j);
		//MoradorDAO.getInstance().salvar(M);

		//######## ESTOQUE ########
		Estoque ES = new Estoque(F);
		//EstoqueDAO.getInstance().salvar(ES);
		
		//######## FLUXO DE ESTOQUE ########
		/*criar classe e metodos e relacionamentos*/

		//######## SALVAR LOCAÇÃO ########
		Calendar data = Calendar.getInstance();
		data.set(2021,3,27);
		Locacao L = new Locacao(data, j, Es, (float)500.00);
		//LocacaoDAO.getInstance().salvar(L);


		//######## OUTRAS COISAS ########
		//    	Morador m = new Morador(p,j);
		//    	MoradorDAO.getInstance().salvar(m);
		//    	List<Morador> mor = MoradorDAO.getInstance().listar();
		//    	for(Morador a : mor){
		//    		System.out.print("nome: " + a.getPessoa().getNome() + " ");
		//    		System.out.println();
		//    	}
		// List<Pessoa> pes = PessoaDAO.getInstance().listar();
		//        for(Pessoa a : pes){
		//        	System.out.println(a.getNome());
		//        	System.out.println(a.getCpf());
		//        }
		//    	
		//        PessoaDAO.getInstance().atualizar(p);
		//    	  PessoaDAO.getInstance().deletar(p);
		//        PessoaDAO.getInstance().deletarPorId("321");
		//    	ApartamentoDAO.getInstance().atualizar(l);
		//    	List<Apartamento> ap = ApartamentoDAO.getInstance().listar();
		//    	List<Apartamento> ap = ApartamentoDAO.getInstance().listarPorBloco("b");
		//    	for(Apartamento a : ap){
		//    		System.out.print("numero do ap: " + a.getNumero() + " ");
		//    		System.out.print(" vagas: " + a.getVagas());
		//    		System.out.println();
		//    	}
		//
	}
}
