package br.upe.syscond;

import java.io.IOException;

import br.upe.syscond.controllers.ApartamentoController;
import br.upe.syscond.controllers.InterfaceApartamentoController;
import br.upe.syscond.controllers.InterfaceMoradorController;
import br.upe.syscond.controllers.InterfacePessoaController;
import br.upe.syscond.controllers.MoradorController;
import br.upe.syscond.controllers.PessoaController;
import br.upe.syscond.models.Apartamento;
import br.upe.syscond.models.Morador;
import br.upe.syscond.models.Pessoa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MoradorViewController {
	static InterfaceMoradorController controlaMorador = new MoradorController();
	static InterfacePessoaController controlaPessoa = new PessoaController();
	static InterfaceApartamentoController controlaAp = new ApartamentoController();
	ObservableList<String> blocosAp = FXCollections.observableArrayList(controlaAp.listarBlocos());
	String opcBloco;
	String opcNumero;
	

    @FXML
    private Label lblId;

    @FXML
    private Label lblCPF;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblTel;

    @FXML
    private TextField txfTel;

    @FXML
    private TextField txfCPF;

    @FXML
    private TextField txfNome;

    @FXML
    private TextField txfId;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Label lblEmail;

    @FXML
    private TextField txfEmail;

    @FXML
    private Label lblApartamento;

    @FXML
    private ChoiceBox<String> chcNumeroAp;
    
    @FXML
    public void chamaBloco(MouseEvent event) {
    	this.chcBlocoAp.setItems(blocosAp);
    	
    	this.opcBloco = (String) this.chcBlocoAp.getValue();
    	chcBlocoAp.setOnAction((Event)->{
    		this.opcBloco = chcBlocoAp.getSelectionModel().getSelectedItem();
    	});
    	
    	
    }
    
    @FXML
    public void chamaNumero(MouseEvent event) {
    	
    	ObservableList<String> numerosAp = FXCollections.observableArrayList(controlaAp.listaNumeros(opcBloco));
		
    	this.chcNumeroAp.setItems(numerosAp);
    	
    	this.opcNumero = (String) this.chcBlocoAp.getValue();
    	chcNumeroAp.setOnAction((Event)->{
    		this.opcNumero = chcNumeroAp.getSelectionModel().getSelectedItem();
    	});
    	
    	
    	System.out.println(numerosAp);
    	
    }

	@FXML
    private ChoiceBox<String> chcBlocoAp;
	
    @FXML
    private Label lblNumeroAp;

    @FXML
    private Label lblBlocoAp;

    @FXML
    void salvarMorador(ActionEvent event) {
    	String cpf = this.txfCPF.getText();
    	String nome = this.txfNome.getText();
    	String email = this.txfEmail.getText();
    	String telefone = this.txfTel.getText();
    	String bloco = this.opcBloco;
    	String numero = this.opcNumero;

    	try {
    		System.out.println(nome + cpf + telefone + email + bloco + numero);
    		Apartamento apt = controlaAp.buscar(bloco, Integer.parseInt(numero));

    		Pessoa pessoa = new Pessoa(nome, cpf, telefone, email);
    		controlaPessoa.criar(pessoa);
    		controlaMorador.criar(new Morador(pessoa, apt));
    		//this.txfId.setText(Integer.toString(getId()));
    		
    		App.setRoot("MainView");
    		
    	}catch (Exception ex) {

    	}
    	
    	
    }

    @FXML
    void switchMain(ActionEvent event) {
    	try {
			App.setRoot("MainView");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
