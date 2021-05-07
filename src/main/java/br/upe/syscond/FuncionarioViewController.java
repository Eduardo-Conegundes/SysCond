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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class FuncionarioViewController implements Initializable{

	static InterfaceFuncionarioController controlaFuncionario = new FuncionarioController();
	static InterfacePessoaController controlaPessoa = new PessoaController();
	private String AtributointernoExterno;
	private ObservableList<Funcionario> select;

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
    private TableColumn<Funcionario, Integer> id;

    @FXML
    private TableColumn<Funcionario, String> pessoa;

    @FXML
    private TableColumn<Funcionario, String> internoExterno;

    @FXML
    private TableColumn<Funcionario, String> cargo;

    @FXML
    private TableColumn<Funcionario, Float> salario;

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
    private Label lblCargo;

    @FXML
    private TextField txfCargo;

    @FXML
    private Label lblSalario;

    @FXML
    private TextField txfSalario;

    @FXML
    private RadioButton checkInterno;

    @FXML
    private RadioButton checkExterno;

	@FXML
	void salvarFuncionario(MouseEvent event) {
		salvar();
		limpaTela();
		atualizaTabela();
	}

	@FXML
	void EditarFuncionario(MouseEvent event) {
		this.select = tableFuncionario.getSelectionModel().getSelectedItems();
		this.txfCargo.setText(select.get(0).getCargo());
		this.txfId.setText(Integer.toString(select.get(0).getId()));
		this.txfNome.setText(select.get(0).getPessoa().getNome());
		this.txfCPF.setText(select.get(0).getPessoa().getCpf());
		this.txfEmail.setText(select.get(0).getPessoa().getEmail());
		this.txfTel.setText(select.get(0).getPessoa().getTelefone());
		this.txfSalario.setText(Float.toString(select.get(0).getSalario()));
		
		
	}

	@FXML
	void ExcluirFuncionario(MouseEvent event) {
		this.select = tableFuncionario.getSelectionModel().getSelectedItems();
		deletar();
		limpaTela();
		atualizaTabela();

	}
	
	private void salvar() {
		String cpf = this.txfCPF.getText();
		String nome = this.txfNome.getText();
		String email = this.txfEmail.getText();
		String telefone = this.txfTel.getText(); 
		String cargo = this.txfCargo.getText();
		String id = this.txfId.getText();
		float salario = Float.parseFloat(this.txfSalario.getText());
		intExt();
		
		Pessoa pessoa = new Pessoa(nome, cpf, telefone, email);
		
		if(!id.equals("")) {
			pessoa.setId(select.get(0).getPessoa().getId());
			Pessoa newPessoa = controlaPessoa.atualizar(pessoa);
			Funcionario funcionario = new Funcionario(newPessoa, AtributointernoExterno, cargo, salario);
			funcionario.setId(Integer.parseInt(id));
			controlaFuncionario.atualizar(funcionario);
		} else {
			pessoa = controlaPessoa.criar(new Pessoa(nome, cpf, telefone, email));
			controlaFuncionario.criar(new Funcionario(pessoa, AtributointernoExterno, cargo, salario));
		}
	}
	
	@FXML
	void switchMain(MouseEvent event) {
		try {
			App.setRoot("MainView");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void initialize(URL location, ResourceBundle resources) {
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		pessoa.setCellValueFactory(new PropertyValueFactory<>("pessoaDetalhe"));
		internoExterno.setCellValueFactory(new PropertyValueFactory<>("interno_externo"));
		cargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
		salario.setCellValueFactory(new PropertyValueFactory<>("salario"));
		atualizaTabela();
	}

	private void atualizaTabela() {
		ObservableList<Funcionario> list = FXCollections.observableArrayList(controlaFuncionario.listar());
		tableFuncionario.setItems(list);
	}

	private void limpaTela() {
		this.txfCargo.setText("");
		this.txfId.setText("");
		this.txfNome.setText("");
		this.txfCPF.setText("");
		this.txfEmail.setText("");
		this.txfTel.setText("");
		this.txfSalario.setText("");
	}

	private void intExt() {
		if(checkInterno.selectedProperty().getValue() == true) {
			this.AtributointernoExterno = "Interno";
		}else{
			this.AtributointernoExterno = "Externo";
		}
	}
	
	private void deletar() {
		controlaFuncionario.deletar(select.get(0));
		controlaPessoa.deletar(select.get(0).getPessoa());
	}

}
