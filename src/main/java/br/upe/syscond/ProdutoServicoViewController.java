package br.upe.syscond;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ProdutoServicoViewController implements Initializable{

    @FXML
    private Label lblNome;

    @FXML
    private TextField txfNomeProduto;

    @FXML
    private Label lblCpf;

    @FXML
    private TextField txfCategoria;

    @FXML
    private Label lblTel;

    @FXML
    private TextField txfTel;

    @FXML
    private Label lblEmpresa;

    @FXML
    private ChoiceBox<?> chcEmpresa;

    @FXML
    private TableView<?> TableProdutoServicoView;

    @FXML
    private TableColumn<?, ?> TableProdServ;

    @FXML
    private TableColumn<?, ?> TableEmpresa;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnExcluir;

    @FXML
    void editarMorador(MouseEvent event) {

    }

    @FXML
    void excluirMorador(MouseEvent event) {

    }

    @FXML
    void salvarMorador(MouseEvent event) {

    }

    @FXML
    void switchMain(MouseEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
