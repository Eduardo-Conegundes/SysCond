package br.upe.Controllers;

import java.util.List;

import br.upe.Controllers.Interface.InterfacePessoaController;
import br.upe.DAO.PessoaDAO;
import br.upe.Models.Pessoa;

public class PessoaController implements InterfacePessoaController {
	
	/*private static boolean isCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0
        // (48 eh a posicao de '0' na tabela ASCII)
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
        }*/
	
	public Pessoa criar(Pessoa pessoa){
		List<Pessoa> pessoas = this.listar();
		
		if(pessoas.contains(pessoa)) {
			System.out.println("Pessoa j� cadastrada!!! ");
			return null;
		}
		try {
			Pessoa p = PessoaDAO.getInstance().salvar(pessoa);
			System.out.println("Salvo " + p.getNome() + " com sucesso");
			return p;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao salvar pessoa!");
			return null;
		}
	}

	public List<Pessoa> listar(){
		try {
			List<Pessoa> l = PessoaDAO.getInstance().listar();
			System.out.println("Listar com sucesso: " + l.size());
			return l;
		} catch (Exception eListar) {
			System.err.println("Erro ao listar pessoa(s)!");
			return null;
		}

	}

	public Pessoa buscar(String cpf){
		try {
			Pessoa b = PessoaDAO.getInstance().buscar(cpf);
			System.out.println("Achado com sucesso: " + b);
			return b;
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar pessoa!");
			return null;
		}
	}

	public Pessoa atualizar(Pessoa pessoa){
		
		Pessoa b = null;
		
		try {
			b = this.buscar(pessoa.getCpf());
		} catch (Exception eBuscar) {
			System.err.println("Erro ao buscar cpf!");
			return null;
		}
		
		if (b == null) {
			System.out.println("Pessoa n�o encontrada pelo CPF");
			return null;
		}		
		
		try {
			Pessoa a = PessoaDAO.getInstance().atualizar(pessoa);
			System.out.println("Atualizado com sucesso: " + a);
			return a;
		} catch (Exception eSalvar) {
			System.err.println("Erro ao atualizar pessoa!");
			return null;
		}
	}

	public void deletarPorId(String cpf){
		try {
			PessoaDAO.getInstance().deletar(cpf);
			System.out.println("Exclu�do com sucesso");
		} catch (Exception e) {
			System.err.println("Erro ao excluir pessoa!");
		}
	}
}
