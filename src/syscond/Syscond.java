package syscond;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import Controllers.*;
import Models.*;

public class Syscond {

	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa("Flavio", "299.299.299-20", "81993939393", "flavio@email.com.br");
		PessoaController pessoaController = new PessoaController();
//		pessoaController.criar(pessoa);
		
		Apartamento ap = new Apartamento("B",203,1);
		ApartamentoController apartamentoController = new ApartamentoController();
//		apartamentoController.criar(ap);
		
		Morador morador = new Morador(pessoa, ap);
		MoradorController moradorController = new MoradorController();
//		moradorController.criar("299.299.299-20", 1);
		
		java.util.Date data = null;
		java.util.Date horarioInicio = null;
		java.util.Date horarioFim = null;
		try {
			data = new SimpleDateFormat("yyyy-MM-dd").parse("2020-11-15");
			horarioInicio = new SimpleDateFormat("HH:mm:ss").parse("15:00:00");
			horarioFim = new SimpleDateFormat("HH:mm:ss").parse("16:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Espaco espaco = new Espaco(data, horarioInicio, horarioFim, morador, "Salão de Jogos", 0);
		LocacaoController loCont = new LocacaoController();
		loCont.criar(espaco);
	}
}
