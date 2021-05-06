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
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;


public class MoradorViewController {
	static InterfaceMoradorController controlaMorador = new MoradorController();
	static InterfacePessoaController controlaPessoa = new PessoaController();
	static InterfaceApartamentoController controlaAp = new ApartamentoController();
	ObservableList<String> blocosAp = FXCollections.observableArrayList(controlaAp.listarBlocos());


	String opcBloco;
	String opcNumero;
<<<<<<< Updated upstream

	@FXML
	private Label lblId;

	@FXML
	private TextField txfId;

	@FXML
	private Label lblNome;

	@FXML
	private TextField txfNome;

	@FXML
	private Label lblCpf;

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
	private TableView<Morador> tableMorador;

	@FXML
	private TableColumn<Morador, Integer> idTableMorador;

	@FXML
	private TableColumn<Pessoa, Pessoa> pessoaTableMorador;

	@FXML
	private TableColumn<Pessoa, Integer> idTablePessoaMorador;

	@FXML
	private TableColumn<Pessoa, String> nomeTableMorador;

	@FXML
	private TableColumn<Pessoa, String> cpfTableMorador;

	@FXML
	private TableColumn<Pessoa, String> telTableMorador;

	@FXML
	private TableColumn<Pessoa, String> emailTableMorador;

	@FXML
	private TableColumn<Apartamento, Apartamento> colunaAp;

	@FXML
	private TableColumn<Apartamento, String> colunaApBloco;

	@FXML
	private TableColumn<Apartamento, String> colunaApNumero;

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
	void editarMorador(MouseEvent event) {

	}

	@FXML
	void excluirMorador(MouseEvent event) {

	}

	@FXML
	void salvarMorador(MouseEvent event) {
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

			App.setRoot("MainView");
		}catch (Exception ex){

		}

	}

	@FXML
	void switchMain(MouseEvent event) {
		try {
=======
	

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
    		
    		App.setRoot("MainView");
    		
    	}catch (Exception ex) {

    	}
    	
    	
    }

    @FXML
    void switchMain(ActionEvent event) {
    	try {
>>>>>>> Stashed changes
			App.setRoot("MainView");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void initialize(URL location, ResourceBundle resources) {
		idTableMorador.setCellValueFactory(new PropertyValueFactory<>("id"));
		idTablePessoaMorador.setCellValueFactory(new PropertyValueFactory<>("id"));
		nomeTableMorador.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cpfTableMorador.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		telTableMorador.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		emailTableMorador.setCellValueFactory(new PropertyValueFactory<>("email"));
		colunaApBloco.setCellValueFactory(new PropertyValueFactory<>("bloco"));
		colunaApNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
		pessoaTableMorador.setCellValueFactory(new PropertyValueFactory<>("morador"));
		colunaAp.setCellValueFactory(new PropertyValueFactory<>("apartamento"));
		//			tableVisitante.setItems(atualizaTabela());

	}









}
