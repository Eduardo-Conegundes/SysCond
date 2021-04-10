package Controllers;

import java.util.List;

import DAO.MoradorDAO;
import Models.Apartamento;
import Models.Morador;
import Models.Pessoa;
import Models.Veiculo;

public class MoradorController {
	void salvar(String nome, String cpf, String telefone, String email, String bloco, int numero, int vagas, String placa){
	    Pessoa pessoa1 = new Pessoa(nome, cpf, telefone, email);
	    Apartamento ap1 = new Apartamento(bloco, numero, vagas);
	    Veiculo vec1 = new Veiculo(placa,ap1);
	    Morador morador1 = new Morador(pessoa1,ap1);
	    MoradorDAO morador = MoradorDAO.getInstance();
	    morador.salvar(morador1);
	}
    List listar(){}
    Morador listarId(int id){}
    void atualizar(Morador m){}
    void deletar(Morador m){}
}
