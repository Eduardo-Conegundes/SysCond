package br.upe.syscond;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.upe.syscond.controllers.ApartamentoController;
import br.upe.syscond.controllers.InterfaceApartamentoController;
import br.upe.syscond.controllers.InterfaceVisitanteController;
import br.upe.syscond.controllers.VisitanteController;
import br.upe.syscond.models.Apartamento;
import br.upe.syscond.models.Pessoa;
import br.upe.syscond.models.Visitante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class VisitanteViewController implements Initializable {
	static InterfaceVisitanteController controlaVisitante = new VisitanteController();
	static InterfaceApartamentoController controlaApartamento = new ApartamentoController();

    @FXML
    private Label lblCPF;

    @FXML
    private TextField txfNome;

    @FXML
    private Label lblNome;

    @FXML
    private TextField txfCPF;

    @FXML
    private Label lblTel;

    @FXML
    private TextField txfTel;

    @FXML
    private Label lblEmail;

    @FXML
    private TextField txfEmail;

    @FXML
    private Label lblApartamento;

    @FXML
    private Label lblNumeroAp;

    @FXML
    private Label lblBlocoAp;

    @FXML
    private ChoiceBox<Apartamento> chcAp;

    @FXML
    private TableView<Visitante> tableVisitante;

    @FXML
    private TableColumn<Visitante, Integer> idTableVisita;

    @FXML
    private TableColumn<Visitante, String> pessoaTableVisita;

    @FXML
    private TableColumn<Visitante, String> colunaAp;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnCancelar;
    
    @FXML
    private Button btnEditar;

    @FXML
    private TableColumn<Apartamento, Integer> colunaApNumero;
	private ObservableList<Visitante> select;

	@FXML
	void salvarVisitante(MouseEvent event) {
		salvar();
		limpaTela();
		atualizaTabela();
	}

	@FXML
	void editarVisitante(MouseEvent event) {
		this.select = tableVisitante.getSelectionModel().getSelectedItems();
		this.txfNome.setText(select.get(0).getPessoa().getNome());
		this.txfCPF.setText(select.get(0).getPessoa().getCpf());
		this.txfEmail.setText(select.get(0).getPessoa().getEmail());
		this.txfTel.setText(select.get(0).getPessoa().getTelefone());
		
	}

	void salvar() {
		Visitante visitante = new Visitante(
				new Pessoa(this.txfNome.getText(), 
						this.txfCPF.getText(), 
						this.txfTel.getText(), 
						this.txfEmail.getText()), 
				this.chcAp.getSelectionModel().getSelectedItem()
				);

		try {
			controlaVisitante.criar(visitante);
			Alerts.alertaSucesso("Salvo com Sucesso!");
		} catch (Exception e) {
			Alerts.alertaErro(e.getMessage());
		}			

		limpaTela();
		atualizaTabela();

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
		limpaTela();
		pessoaTableVisita.setCellValueFactory(new PropertyValueFactory<>("PessoaString"));
		colunaAp.setCellValueFactory(new PropertyValueFactory<>("ApartamentoString"));
		atualizaTabela();

	}
	
	private void limpaTela() {
		this.txfCPF.setText(null);
		this.txfEmail.setText(null);
		this.txfNome.setText(null);
		this.txfTel.setText(null);
		this.chcAp.setItems(FXCollections.observableArrayList());
	}
	
	private void atualizaTabela() {
		try {
			this.tableVisitante.setItems(FXCollections.observableArrayList(controlaVisitante.listar()));
			this.chcAp.setItems(FXCollections.observableArrayList(controlaApartamento.listar()));
		} catch (Exception e) {
			e.printStackTrace();
		

		}
	}
}
