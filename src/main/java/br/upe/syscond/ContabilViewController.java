package br.upe.syscond;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ContabilViewController {

    @FXML
    private Label lblId;

    @FXML
    private TextField txfIdentificador;

    @FXML
    private TextField txfId;

    @FXML
    private TextField txfPagador;

    @FXML
    private Label lblBeneficiario;

    @FXML
    private TextField txfBeneficiario;

    @FXML
    private Label lblPagador;

    @FXML
    private Label lblIdentificador;

    @FXML
    private TableView<?> tableApartamento;

    @FXML
    private TableColumn<?, ?> idTableContas;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnEditar;

    @FXML
    private TextField txtValor;

    @FXML
    private Label lblValor;

    @FXML
    private RadioButton txtReceber;

    @FXML
    private RadioButton txtPagar;

    @FXML
    private DatePicker textlblDataEmissao;

    @FXML
    private DatePicker texttxtDataVencimento;

    @FXML
    private Label lblDataEmissao;

    @FXML
    private Label txtDataVencimento;

    @FXML
    void EditarConta(MouseEvent event) {

    }

    @FXML
    void ExcluirConta(MouseEvent event) {

    }

    @FXML
    void salvarConta(MouseEvent event) {
    	
    }

    @FXML
    void switchMain(MouseEvent event) {
    	try {
			App.setRoot("MainView");
		} catch (Exception e) {
			Alerts.alertaErro(e.getMessage());
		}
    }

}
