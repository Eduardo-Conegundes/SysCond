/**
 * Sample Skeleton for 'ContabilView.fxml' Controller Class
 */

package br.upe.syscond;

import java.net.URL;
import java.util.ResourceBundle;
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

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="lblId"
    private Label lblId; // Value injected by FXMLLoader

    @FXML // fx:id="txfIdentificador"
    private TextField txfIdentificador; // Value injected by FXMLLoader

    @FXML // fx:id="txfId"
    private TextField txfId; // Value injected by FXMLLoader

    @FXML // fx:id="txfPagador"
    private TextField txfPagador; // Value injected by FXMLLoader

    @FXML // fx:id="lblBeneficiario"
    private Label lblBeneficiario; // Value injected by FXMLLoader

    @FXML // fx:id="txfBeneficiario"
    private TextField txfBeneficiario; // Value injected by FXMLLoader

    @FXML // fx:id="lblPagador"
    private Label lblPagador; // Value injected by FXMLLoader

    @FXML // fx:id="lblIdentificador"
    private Label lblIdentificador; // Value injected by FXMLLoader

    @FXML // fx:id="tableApartamento"
    private TableView<?> tableApartamento; // Value injected by FXMLLoader

    @FXML // fx:id="idTableContas"
    private TableColumn<?, ?> idTableContas; // Value injected by FXMLLoader

    @FXML // fx:id="TableIdentificador"
    private TableColumn<?, ?> TableIdentificador; // Value injected by FXMLLoader

    @FXML // fx:id="TablePagador"
    private TableColumn<?, ?> TablePagador; // Value injected by FXMLLoader

    @FXML // fx:id="TableBeneficiario"
    private TableColumn<?, ?> TableBeneficiario; // Value injected by FXMLLoader

    @FXML // fx:id="TableValor"
    private TableColumn<?, ?> TableValor; // Value injected by FXMLLoader

    @FXML // fx:id="TableAReceber"
    private TableColumn<?, ?> TableAReceber; // Value injected by FXMLLoader

    @FXML // fx:id="TableDataEmissao"
    private TableColumn<?, ?> TableDataEmissao; // Value injected by FXMLLoader

    @FXML // fx:id="TableDataVencimento"
    private TableColumn<?, ?> TableDataVencimento; // Value injected by FXMLLoader

    @FXML // fx:id="btnSalvar"
    private Button btnSalvar; // Value injected by FXMLLoader

    @FXML // fx:id="btnCancelar"
    private Button btnCancelar; // Value injected by FXMLLoader

    @FXML // fx:id="btnEditar"
    private Button btnEditar; // Value injected by FXMLLoader

    @FXML // fx:id="txtValor"
    private TextField txtValor; // Value injected by FXMLLoader

    @FXML // fx:id="lblValor"
    private Label lblValor; // Value injected by FXMLLoader

    @FXML // fx:id="txtReceber"
    private RadioButton txtReceber; // Value injected by FXMLLoader

    @FXML // fx:id="txtPagar"
    private RadioButton txtPagar; // Value injected by FXMLLoader

    @FXML // fx:id="textlblDataEmissao"
    private DatePicker textlblDataEmissao; // Value injected by FXMLLoader

    @FXML // fx:id="texttxtDataVencimento"
    private DatePicker texttxtDataVencimento; // Value injected by FXMLLoader

    @FXML // fx:id="lblDataEmissao"
    private Label lblDataEmissao; // Value injected by FXMLLoader

    @FXML // fx:id="txtDataVencimento"
    private Label txtDataVencimento; // Value injected by FXMLLoader

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

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert lblId != null : "fx:id=\"lblId\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert txfIdentificador != null : "fx:id=\"txfIdentificador\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert txfId != null : "fx:id=\"txfId\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert txfPagador != null : "fx:id=\"txfPagador\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert lblBeneficiario != null : "fx:id=\"lblBeneficiario\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert txfBeneficiario != null : "fx:id=\"txfBeneficiario\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert lblPagador != null : "fx:id=\"lblPagador\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert lblIdentificador != null : "fx:id=\"lblIdentificador\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert tableApartamento != null : "fx:id=\"tableApartamento\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert idTableContas != null : "fx:id=\"idTableContas\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert TableIdentificador != null : "fx:id=\"TableIdentificador\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert TablePagador != null : "fx:id=\"TablePagador\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert TableBeneficiario != null : "fx:id=\"TableBeneficiario\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert TableValor != null : "fx:id=\"TableValor\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert TableAReceber != null : "fx:id=\"TableAReceber\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert TableDataEmissao != null : "fx:id=\"TableDataEmissao\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert TableDataVencimento != null : "fx:id=\"TableDataVencimento\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert btnSalvar != null : "fx:id=\"btnSalvar\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert btnCancelar != null : "fx:id=\"btnCancelar\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert btnEditar != null : "fx:id=\"btnEditar\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert txtValor != null : "fx:id=\"txtValor\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert lblValor != null : "fx:id=\"lblValor\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert txtReceber != null : "fx:id=\"txtReceber\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert txtPagar != null : "fx:id=\"txtPagar\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert textlblDataEmissao != null : "fx:id=\"textlblDataEmissao\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert texttxtDataVencimento != null : "fx:id=\"texttxtDataVencimento\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert lblDataEmissao != null : "fx:id=\"lblDataEmissao\" was not injected: check your FXML file 'ContabilView.fxml'.";
        assert txtDataVencimento != null : "fx:id=\"txtDataVencimento\" was not injected: check your FXML file 'ContabilView.fxml'.";

    }
}
