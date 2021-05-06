package br.upe.syscond;

import br.upe.syscond.controllers.ApartamentoController;
import br.upe.syscond.controllers.InterfaceApartamentoController;
import br.upe.syscond.models.Apartamento;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ApartamentoViewController {
	
	@FXML
    private Label lblId;

    @FXML
    private TextField txfId;

    @FXML
    private TextField txfBloco;

    @FXML
    private TextField txfNumero;

    @FXML
    private Label lblTel;

    @FXML
    private TextField txfVagas;

    @FXML
    private Label lblNumeroAp;

    @FXML
    private Label lblBlocoAp;

    @FXML
    private TableView<Apartamento> tableApartamento;

    @FXML
    private TableColumn<Apartamento, Integer> idTableApartamento;

    @FXML
    private TableColumn<Apartamento, String> blocoTableApartamento;

    @FXML
    private TableColumn<Apartamento, Integer> numeroTableApartamento;

    @FXML
    private TableColumn<Apartamento, Integer> vagasTableApartamento;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnEditar;

    @FXML
    void EditarApartamento(MouseEvent event) {

    }

    @FXML
    void ExcluirApartamento(MouseEvent event) {

    }

    @FXML
    void salvarApartamento(MouseEvent event) {
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
    void switchMain(MouseEvent event) {
    	try {
			App.setRoot("MainView");
		} catch (Exception e) {
			// TODO: handle exception
		}

    }
	
    public void initialize(URL location, ResourceBundle resources) {
    	
    	idTableApartamento.setCellValueFactory(new PropertyValueFactory<>("id"));
		blocoTableApartamento.setCellValueFactory(new PropertyValueFactory<>("bloco"));
		numeroTableApartamento.setCellValueFactory(new PropertyValueFactory<>("numero"));
		vagasTableApartamento.setCellValueFactory(new PropertyValueFactory<>("vagas"));

		
	}

}

