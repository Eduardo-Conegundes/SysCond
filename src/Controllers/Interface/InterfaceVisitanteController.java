package Controllers.Interface;

import java.util.List;

import Models.Visitante;

public interface InterfaceVisitanteController {
	public Visitante criar(String cpf, int id);
	public Visitante buscar(String cpf);
	public Visitante atualizar(String cpf, int id);
	public void deletar(String cpf);
	public List<Visitante> listar();
	
}
