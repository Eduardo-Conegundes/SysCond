package br.upe.Controllers.Interface;

import java.util.List;

import br.upe.Models.Apartamento;
import br.upe.Models.Pessoa;
import br.upe.Models.Visitante;

public interface InterfaceVisitanteController {
	public Visitante criar(Pessoa pessoaVisitanteVerificar, Apartamento apartamentoVerificar);
	public Visitante buscar(String cpf);
	public List<Visitante> listar();
	
}
