package br.upe.syscond;


import java.io.IOException;
import br.upe.syscond.controllers.ApartamentoController;
import br.upe.syscond.controllers.InterfaceApartamentoController;
import br.upe.syscond.controllers.InterfaceMoradorController;
import br.upe.syscond.controllers.InterfacePessoaController;
import br.upe.syscond.controllers.MoradorController;
import br.upe.syscond.controllers.PessoaController;
import br.upe.syscond.models.Apartamento;
import br.upe.syscond.models.Funcionario;
import br.upe.syscond.models.Morador;
import br.upe.syscond.models.Pessoa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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


public class MoradorViewController implements Initializable{
	static InterfaceMoradorController controlaMorador = new MoradorController();
	static InterfacePessoaController controlaPessoa = new PessoaController();
	static InterfaceApartamentoController controlaAp = new ApartamentoController();
	ObservableList<String> blocosAp = FXCollections.observableArrayList(controlaAp.listarBlocos());
	private ObservableList<Morador> select;


	String opcBloco;
	String opcNumero;

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
	    private TableColumn<Morador, String> pessoaTableMorador;

	    @FXML
	    private TableColumn<Morador, String> ApartamentoTableMorador;

	    @FXML
	    private Button btnSalvar;

	    @FXML
	    private Button btnCancelar;

	    @FXML
	    private Button btnEditar;

	    @FXML
	    private Button btnExcluir;
	
	@FXML
	void salvarMorador(MouseEvent event) {
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
	void editarMorador(MouseEvent event) {
//		this.pessoaAtualiza = select.get(0).getPessoa();
		this.select = tableMorador.getSelectionModel().getSelectedItems();
		this.txfId.setText(Integer.toString(select.get(0).getId()));
		this.txfNome.setText(select.get(0).getPessoa().getNome());
		this.txfCPF.setText(select.get(0).getPessoa().getCpf());
		this.txfEmail.setText(select.get(0).getPessoa().getEmail());
		this.txfTel.setText(select.get(0).getPessoa().getTelefone());
		
	}

	@FXML
	void excluirMorador(MouseEvent event) {
		this.select = tableMorador.getSelectionModel().getSelectedItems();
		deletar(this.select.get(0));
		limpaTela();
		atualizaTabela();
	}

	
	void salvar() {
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
			App.setRoot("MainView");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void initialize(URL location, ResourceBundle resources) {
		idTableMorador.setCellValueFactory(new PropertyValueFactory<>("id"));
		pessoaTableMorador.setCellValueFactory(new PropertyValueFactory<>("PessoaString"));
		ApartamentoTableMorador.setCellValueFactory(new PropertyValueFactory<>("ApartamentoString"));
		atualizaTabela();

	}
	
	private void deletar(Morador morador) {
		controlaMorador.deletar(morador);
	}
	
	private void limpaTela() {
		this.txfCPF.setText("");
		this.txfEmail.setText("");
		this.txfId.setText("");
		this.txfNome.setText("");
	}
	
	private void atualizaTabela() {
		ObservableList<Morador> list = FXCollections.observableArrayList(controlaMorador.listar());
		tableMorador.setItems(list);
	}

}