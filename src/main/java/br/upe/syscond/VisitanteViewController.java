package br.upe.syscond;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.upe.syscond.controllers.ApartamentoController;
import br.upe.syscond.controllers.InterfaceApartamentoController;
import br.upe.syscond.controllers.InterfacePessoaController;
import br.upe.syscond.controllers.InterfaceVisitanteController;
import br.upe.syscond.controllers.PessoaController;
import br.upe.syscond.controllers.VisitanteController;
import br.upe.syscond.models.Apartamento;
import br.upe.syscond.models.Morador;
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
/*
public class VisitanteViewController implements Initializable {
	static InterfaceVisitanteController controlaVisitante = new VisitanteController();
	static InterfacePessoaController controlaPessoa = new PessoaController();
	static InterfaceApartamentoController controlaAp = new ApartamentoController();
	ObservableList<String> blocosAp = FXCollections.observableArrayList(controlaAp.listarBlocos());
	
	String opcBloco;
	String opcNumero;

    
	@FXML
    private Label lblId;

    @FXML
    private TextField txfId;

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
    private ChoiceBox<String> chcBlocoAp;

    @FXML
    private ChoiceBox<String> chcNumeroAp;

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
	void editarVisitante(MouseEvent event) {
//		this.pessoaAtualiza = select.get(0).getPessoa();
		this.select = tableVisitante.getSelectionModel().getSelectedItems();
		this.txfId.setText(Integer.toString(select.get(0).getId()));
		this.txfNome.setText(select.get(0).getPessoa().getNome());
		this.txfCPF.setText(select.get(0).getPessoa().getCpf());
		this.txfEmail.setText(select.get(0).getPessoa().getEmail());
		this.txfTel.setText(select.get(0).getPessoa().getTelefone());
		
	}

	void salvar() {
		String id = this.txfId.getText();
		String cpf = this.txfCPF.getText();
		String nome = this.txfNome.getText();
		String email = this.txfEmail.getText();
		String telefone = this.txfTel.getText();
		String bloco = this.opcBloco;
		String numero = this.opcNumero;
		
		Pessoa pessoa = new Pessoa(nome, cpf, telefone, email);
		Apartamento apt = controlaAp.buscar(bloco, Integer.parseInt(numero));
		Visitante visitante = new Visitante(pessoa, apt);
		visitante.setApartamento(apt);
		
		controlaPessoa.criar(pessoa);
		controlaVisitante.criar(visitante);			
		


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
		idTableVisita.setCellValueFactory(new PropertyValueFactory<>("id"));
		pessoaTableVisita.setCellValueFactory(new PropertyValueFactory<>("PessoaString"));
		colunaAp.setCellValueFactory(new PropertyValueFactory<>("ApartamentoString"));
		atualizaTabela();

	}
	
	private void limpaTela() {
		this.txfCPF.setText("");
		this.txfEmail.setText("");
		this.txfId.setText("");
		this.txfNome.setText("");
	}
	
	private void atualizaTabela() {
		ObservableList<Visitante> list = FXCollections.observableArrayList(controlaVisitante.listar());
		tableVisitante.setItems(list);
	}

}
*/