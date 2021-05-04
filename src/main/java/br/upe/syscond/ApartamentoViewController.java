package br.upe.syscond;

import br.upe.syscond.controllers.ApartamentoController;
import br.upe.syscond.controllers.InterfaceApartamentoController;
import br.upe.syscond.models.Apartamento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ApartamentoViewController {

    @FXML
    private Label lblId;

    @FXML
    private Label lblBloco;

    @FXML
    private Label lblNumero;

    @FXML
    private Label lblVagas;

    @FXML
    private TextField txfVagas;

    @FXML
    private TextField txfBloco;

    @FXML
    private TextField txfNumero;

    @FXML
    private TextField txfId;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnCancelar;

    @FXML
    void salvarApartamento(ActionEvent event) {
    	String bloco = this.txfBloco.getText();
    	int numero = Integer.parseInt(this.txfNumero.getText());
    	int vagas = Integer.parseInt(this.txfVagas.getText());
    	
    	InterfaceApartamentoController controlerApt = new ApartamentoController();
    	
    	try {
			int id = controlerApt.criar(new Apartamento(bloco, numero, vagas)).getId();
			this.txfId.setText(Integer.toString(id));
			App.setRoot("MainView");
		} catch (Exception e) {
			
		}
    	
    	
    }
    
    @FXML
    void switchMain(ActionEvent event) {
    	try {
			App.setRoot("MainView");
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

}

