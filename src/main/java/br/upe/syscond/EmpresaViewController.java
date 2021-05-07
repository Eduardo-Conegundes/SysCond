/**
 * Sample Skeleton for 'Empresa.fxml' Controller Class
 */

package br.upe.syscond;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EmpresaViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="lblId"
    private Label lblId; // Value injected by FXMLLoader

    @FXML // fx:id="txfId"
    private TextField txfId; // Value injected by FXMLLoader

    @FXML // fx:id="txfCnpj"
    private TextField txfCnpj; // Value injected by FXMLLoader

    @FXML // fx:id="txfNome"
    private TextField txfNome; // Value injected by FXMLLoader

    @FXML // fx:id="lblTel"
    private Label lblTel; // Value injected by FXMLLoader

    @FXML // fx:id="txfTelefone"
    private TextField txfTelefone; // Value injected by FXMLLoader

    @FXML // fx:id="lblNome"
    private Label lblNome; // Value injected by FXMLLoader

    @FXML // fx:id="lblCnpj"
    private Label lblCnpj; // Value injected by FXMLLoader

    @FXML // fx:id="tableApartamento"
    private TableView<?> tableApartamento; // Value injected by FXMLLoader

    @FXML // fx:id="idTableEmpresa"
    private TableColumn<?, ?> idTableEmpresa; // Value injected by FXMLLoader

    @FXML // fx:id="TableCnpj"
    private TableColumn<?, ?> TableCnpj; // Value injected by FXMLLoader

    @FXML // fx:id="TableNome"
    private TableColumn<?, ?> TableNome; // Value injected by FXMLLoader

    @FXML // fx:id="Tabletelefone"
    private TableColumn<?, ?> Tabletelefone; // Value injected by FXMLLoader

    @FXML // fx:id="btnSalvar"
    private Button btnSalvar; // Value injected by FXMLLoader

    @FXML // fx:id="btnCancelar"
    private Button btnCancelar; // Value injected by FXMLLoader

    @FXML // fx:id="btnEditar"
    private Button btnEditar; // Value injected by FXMLLoader

    @FXML // fx:id="btnListaProdServ"
    private Button btnListaProdServ; // Value injected by FXMLLoader

    @FXML
    void EditarEmpresa(MouseEvent event) {

    }

    @FXML
    void ExcluirEmpresa(MouseEvent event) {

    }

    @FXML
    void MostrarProdServ(MouseEvent event) {

    }

    @FXML
    void salvarEmpresa(MouseEvent event) {

    }

    @FXML
    void switchMain(MouseEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert lblId != null : "fx:id=\"lblId\" was not injected: check your FXML file 'Empresa.fxml'.";
        assert txfId != null : "fx:id=\"txfId\" was not injected: check your FXML file 'Empresa.fxml'.";
        assert txfCnpj != null : "fx:id=\"txfCnpj\" was not injected: check your FXML file 'Empresa.fxml'.";
        assert txfNome != null : "fx:id=\"txfNome\" was not injected: check your FXML file 'Empresa.fxml'.";
        assert lblTel != null : "fx:id=\"lblTel\" was not injected: check your FXML file 'Empresa.fxml'.";
        assert txfTelefone != null : "fx:id=\"txfTelefone\" was not injected: check your FXML file 'Empresa.fxml'.";
        assert lblNome != null : "fx:id=\"lblNome\" was not injected: check your FXML file 'Empresa.fxml'.";
        assert lblCnpj != null : "fx:id=\"lblCnpj\" was not injected: check your FXML file 'Empresa.fxml'.";
        assert tableApartamento != null : "fx:id=\"tableApartamento\" was not injected: check your FXML file 'Empresa.fxml'.";
        assert idTableEmpresa != null : "fx:id=\"idTableEmpresa\" was not injected: check your FXML file 'Empresa.fxml'.";
        assert TableCnpj != null : "fx:id=\"TableCnpj\" was not injected: check your FXML file 'Empresa.fxml'.";
        assert TableNome != null : "fx:id=\"TableNome\" was not injected: check your FXML file 'Empresa.fxml'.";
        assert Tabletelefone != null : "fx:id=\"Tabletelefone\" was not injected: check your FXML file 'Empresa.fxml'.";
        assert btnSalvar != null : "fx:id=\"btnSalvar\" was not injected: check your FXML file 'Empresa.fxml'.";
        assert btnCancelar != null : "fx:id=\"btnCancelar\" was not injected: check your FXML file 'Empresa.fxml'.";
        assert btnEditar != null : "fx:id=\"btnEditar\" was not injected: check your FXML file 'Empresa.fxml'.";
        assert btnListaProdServ != null : "fx:id=\"btnListaProdServ\" was not injected: check your FXML file 'Empresa.fxml'.";

    }
}
