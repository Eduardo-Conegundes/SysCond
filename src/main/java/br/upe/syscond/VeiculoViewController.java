package br.upe.syscond;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import br.upe.syscond.controllers.ApartamentoController;
import br.upe.syscond.controllers.InterfaceApartamentoController;
import br.upe.syscond.controllers.InterfaceVeiculoController;
import br.upe.syscond.controllers.VeiculoController;
import br.upe.syscond.models.Apartamento;
import br.upe.syscond.models.Veiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class VeiculoViewController {


	static InterfaceVeiculoController controlaVeiculo = new VeiculoController();
	static InterfaceApartamentoController controlaAp = new ApartamentoController();
	ObservableList<String> blocosAp = FXCollections.observableArrayList(controlaAp.listarBlocos());

	String opcBloco;
	String opcNumero;



	@FXML
	private Label lblId;

	@FXML
	private TextField txfId;

	@FXML
	private Label lblPlaca;

	@FXML
	private TextField txfPlaca;

	@FXML
	private Label lblApartamento;

	@FXML
	private Label lblNumeroAp;

	@FXML
	private Label lblBlocoAp;

	@FXML
	private ChoiceBox<String> chcBlocoAp;

	@FXML
	private ChoiceBox<String> chcNumeroAp;

	@FXML
	private TableView<Veiculo> tableVeiculo;

	@FXML
	private TableColumn<Veiculo, Integer> idTableVeiculo;

	@FXML
	private TableColumn<Veiculo, String> placaTableVeiculo;

	@FXML
	private TableColumn<Apartamento, Apartamento> colunaAp;

	@FXML
	private TableColumn<Apartamento, String> colunaApBloco;

	@FXML
	private TableColumn<Apartamento, Integer> colunaApNumero;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnEditar;

	@FXML
	private Button btnExcluir;

	@FXML
	void ChamaNumero(MouseEvent event) {
		ObservableList<String> numerosAp = FXCollections.observableArrayList(controlaAp.listaNumeros(opcBloco));

		this.chcNumeroAp.setItems(numerosAp);

		this.opcNumero = (String) this.chcBlocoAp.getValue();
		chcNumeroAp.setOnAction((Event)->{
			this.opcNumero = chcNumeroAp.getSelectionModel().getSelectedItem();
		});


		System.out.println(numerosAp);

	}

	@FXML
	void chamaBloco(MouseEvent event) {
		this.chcBlocoAp.setItems(blocosAp);

		this.opcBloco = (String) this.chcBlocoAp.getValue();
		chcBlocoAp.setOnAction((Event)->{
			this.opcBloco = chcBlocoAp.getSelectionModel().getSelectedItem();
		});

	}

	@FXML
	void editarVeiculo(MouseEvent event) {

	}

	@FXML
	void excluirVeiculo(MouseEvent event) {

	}

	@FXML
	void salvarVeiculo(MouseEvent event) {
		String placa = this.txfPlaca.getText();
		String bloco = this.opcBloco;
		String numero = this.opcNumero;

		try {
			System.out.println(placa + bloco + numero);
			Apartamento apt = controlaAp.buscar(bloco, Integer.parseInt(numero));

			Veiculo veiculo = new Veiculo(placa, apt);
			controlaVeiculo.criar(veiculo);

			App.setRoot("MainView");
		}catch (Exception ex){

		}

	}

	@FXML
	void switchMain(MouseEvent event) {
		try {
			App.setRoot("MainView");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void initialize(URL location, ResourceBundle resources) {
		idTableVeiculo.setCellValueFactory(new PropertyValueFactory<>("id"));
		placaTableVeiculo.setCellValueFactory(new PropertyValueFactory<>("placa"));
		colunaApBloco.setCellValueFactory(new PropertyValueFactory<>("bloco"));
		colunaApNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
		colunaAp.setCellValueFactory(new PropertyValueFactory<>("apartamento"));	
	}

}
