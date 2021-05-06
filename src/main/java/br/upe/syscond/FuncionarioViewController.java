package br.upe.syscond;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import br.upe.syscond.controllers.FuncionarioController;
import br.upe.syscond.controllers.InterfaceFuncionarioController;
import br.upe.syscond.controllers.InterfacePessoaController;
import br.upe.syscond.controllers.PessoaController;
import br.upe.syscond.models.Funcionario;
import br.upe.syscond.models.Pessoa;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class FuncionarioViewController {

	static InterfaceFuncionarioController controlaFuncionario = new FuncionarioController();
	static InterfacePessoaController controlaPessoa = new PessoaController();

	@FXML
	private Label lblId;

	@FXML
	private TextField txfId;

	@FXML
	private Label lblNome;

	@FXML
	private TextField txfNome;

	@FXML
	private Label lblCPF;

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
	private TableView<Funcionario> tableFuncionario;

	@FXML
	private TableColumn<Funcionario, Integer> idTableFuncionario;

	@FXML
	private TableColumn<Pessoa, Pessoa> pessoaTableFuncionario;

	@FXML
	private TableColumn<Pessoa, Integer> idPessoa;

	@FXML
	private TableColumn<Pessoa, String> nomeTableFuncionario;

	@FXML
	private TableColumn<Pessoa, String> cpfTableFuncionario;

	@FXML
	private TableColumn<Pessoa, String> telTableFuncionario;

	@FXML
	private TableColumn<Pessoa, String> emailTableFuncionario;

	@FXML
	private TableColumn<Pessoa, String> InternoExternTableFuncionario;

	@FXML
	private TableColumn<Funcionario, String> cargoTableFuncionario;

	@FXML 
	private TableColumn<Funcionario, String> salarioTableFuncionario1;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnEditar;

	@FXML
	private Button btnExcluir;

	@FXML
	private Label lblInternoExterno;

	@FXML
	private TextField txfInternoExterno;

	@FXML
	private Label lblCargo;

	@FXML
	private TextField txfCargo;

	@FXML
	private Label lblSalario;

	@FXML
	private TextField txfSalario;

	@FXML
	void EditarFuncionario(MouseEvent event) {

	}

	@FXML
	void ExcluirFuncionario(MouseEvent event) {

	}

	@FXML
	void salvarFuncionario(MouseEvent event) {
		String cpf = this.txfCPF.getText();
		String nome = this.txfNome.getText();
		String email = this.txfEmail.getText();
		String telefone = this.txfTel.getText();
		String internoExterno = this.txfInternoExterno.getText();
		String cargo = this.txfCargo.getText();
		String salario = this.txfSalario.getText();

		try {

			System.out.println(nome + cpf + telefone + email + internoExterno + cargo +salario);

			Pessoa pessoa = new Pessoa(nome, cpf, telefone, email);
			controlaPessoa.criar(pessoa);
			controlaFuncionario.criar(new Funcionario(pessoa, internoExterno, cargo, Float.parseFloat(salario)));
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
		idTableFuncionario.setCellValueFactory(new PropertyValueFactory<>("id"));
		idPessoa.setCellValueFactory(new PropertyValueFactory<>("id"));
		nomeTableFuncionario.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cpfTableFuncionario.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		telTableFuncionario.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		emailTableFuncionario.setCellValueFactory(new PropertyValueFactory<>("email"));
		InternoExternTableFuncionario.setCellValueFactory(new PropertyValueFactory<>("InternoExterno"));
		cargoTableFuncionario.setCellValueFactory(new PropertyValueFactory<>("cargo"));
		pessoaTableFuncionario.setCellValueFactory(new PropertyValueFactory<>("funcionario"));
		salarioTableFuncionario1.setCellValueFactory(new PropertyValueFactory<>("salario"));

	}
}
