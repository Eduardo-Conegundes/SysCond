package br.upe.syscond;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.upe.syscond.controllers.ApartamentoController;
import br.upe.syscond.controllers.InterfaceApartamentoController;
import br.upe.syscond.controllers.InterfacePessoaController;
import br.upe.syscond.controllers.InterfaceVisitanteController;
import br.upe.syscond.controllers.PessoaController;
import br.upe.syscond.controllers.VisitanteController;
import br.upe.syscond.models.Apartamento;
import br.upe.syscond.models.Pessoa;
import br.upe.syscond.models.Visitante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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
    private TableColumn<Pessoa, Pessoa> pessoaTableVisita;

    @FXML
    private TableColumn<Pessoa, Integer> idPessoa;

    @FXML
    private TableColumn<Pessoa, String> nomeTableVisita;

    @FXML
    private TableColumn<Pessoa, String> cpfTableVisita;

    @FXML
    private TableColumn<Pessoa, String> telTableVisita;

    @FXML
    private TableColumn<Pessoa, String> emailTableVisita;

    @FXML
    private TableColumn<Apartamento, Apartamento> colunaAp;

    @FXML
    private TableColumn<Apartamento, String> colunaApBloco;

    @FXML
    private TableColumn<Apartamento, Integer> colunaApNumero;

	@FXML
	void AlterarVisitante(MouseEvent event) {

	}

	@FXML
	void BuscaVisitante(MouseEvent event) {

	}

	@FXML
	public void ChamaNumero(MouseEvent event) {
		ObservableList<String> numerosAp = FXCollections.observableArrayList(controlaAp.listaNumeros(opcBloco));

		this.chcNumeroAp.setItems(numerosAp);

		this.opcNumero = (String) this.chcBlocoAp.getValue();
		chcNumeroAp.setOnAction((Event)->{
			this.opcNumero = chcNumeroAp.getSelectionModel().getSelectedItem();
		});


		System.out.println(numerosAp);


	}

	@FXML
	void DeletarVisitante(MouseEvent event) {

	}

	@FXML
	public void chamaBloco(MouseEvent event) {
		this.chcBlocoAp.setItems(blocosAp);

		this.opcBloco = (String) this.chcBlocoAp.getValue();
		chcBlocoAp.setOnAction((Event)->{
			this.opcBloco = chcBlocoAp.getSelectionModel().getSelectedItem();
		});


	}
	
	@FXML
    void switchEditar(MouseEvent event) {

    }

	@FXML
	void salvarVisitante(MouseEvent event) {
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
			controlaVisitante.criar(new Visitante(pessoa, apt));
			
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		idTableVisita.setCellValueFactory(new PropertyValueFactory<>("id"));
		idPessoa.setCellValueFactory(new PropertyValueFactory<>("id"));
		nomeTableVisita.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cpfTableVisita.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		telTableVisita.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		emailTableVisita.setCellValueFactory(new PropertyValueFactory<>("email"));
		colunaApBloco.setCellValueFactory(new PropertyValueFactory<>("bloco"));
		colunaApNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
		pessoaTableVisita.setCellValueFactory(new PropertyValueFactory<>("pessoa"));
		colunaAp.setCellValueFactory(new PropertyValueFactory<>("apartamento"));
		atualizaTabela();
		
	}
	
	private void atualizaTabela() {
		ObservableList<Visitante> visitantes = FXCollections.observableArrayList(controlaVisitante.listar());
		ObservableList<Pessoa> pessoas = FXCollections.observableArrayList();
		ObservableList<Apartamento> apartamentos = FXCollections.observableArrayList();

		for (int i = 0; i < visitantes.size(); i++) {
			pessoas.add(visitantes.get(i).getPessoa());
			apartamentos.add(visitantes.get(i).getApartamento());

		}

		tableVisitante.setItems(visitantes);
				
	}

}
