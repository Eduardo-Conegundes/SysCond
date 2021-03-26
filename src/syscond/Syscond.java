/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syscond;

import java.util.List;

import DAO.ApartamentoDAO;
import DAO.EmpresaDAO;
import DAO.EspacoDAO;
import DAO.EstoqueDAO;
import DAO.FuncionarioDAO;
import DAO.FuncionarioExternoDAO;
import DAO.LocacaoDAO;
import DAO.MoradorDAO;
import DAO.PessoaDAO;
import DAO.ServicoProdutoDAO;
import DAO.UsuarioDAO;
import DAO.VeiculoDAO;
import DAO.VisitanteDAO;
import Models.Apartamento;
import Models.Veiculo;
import Models.Empresa;
import Models.Espaco;
import Models.Estoque;
import Models.Funcionario;
import Models.FuncionarioExterno;
import Models.Locacao;
import Models.Morador;
import Models.Pessoa;
import Models.ServicoProduto;
import Models.Usuario;
import Models.Visitante;

import java.sql.Date;
import java.util.ArrayList;

public class Syscond {

	public static void main(String[] args) {

		//######## SALVAR PESSOA ########
		Pessoa p = new Pessoa("LUCASo", "43521", "234", "FLM@gmail.com");
		//PessoaDAO.getInstance().salvar(p); //metodo de salvar

		//############### SALVAR APARTAMENTO  #############
		Apartamento j = new Apartamento("R", 2, 1);
		//ApartamentoDAO.getInstance().salvar(j);

		//############### SALVAR VEICULO  #############            erro em locacao/fazer fluxo de estoque/implementar interfaces 
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

		//######## SALVAR SERVIÃ‡OPRODUTO ########
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
		//falta data
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
