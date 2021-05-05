package br.upe.syscond;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
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
	static InterfacePessoaController controlaPessoa = new PessoaController();
	static InterfaceApartamentoController controlaAp = new ApartamentoController();
	ObservableList<String> blocosAp = FXCollections.observableArrayList(controlaAp.listarBlocos());
	ObservableList<String> pessoasVisitantes = FXCollections.observableArrayList();
	String opcBloco;
	String opcNumero;
//	
//	@FXML
//    private Label lblId;
//
//    @FXML
//    private Label lblCPF;
//
//    @FXML
//    private Label lblNome;
//
//    @FXML
//    private Label lblTel;
//
//    @FXML
//    private TextField txfTel;
//
//    @FXML
//    private TextField txfCPF;
//
//    @FXML
//    private TextField txfNome;
//
//    @FXML
//    private TextField txfId;
//
//    @FXML
//    private Label lblEmail;
//
//    @FXML
//    private TextField txfEmail;
//
//    @FXML
//    private Label lblApartamento;
//
//    @FXML
//    private Label lblNumeroAp;
//
//    @FXML
//    private Label lblBlocoAp;
//
//    @FXML
//    private ChoiceBox<String> chcBlocoAp;
//
//    @FXML
//    private ChoiceBox<String> chcNumeroAp;
//
//    @FXML
//    private Button btnCancelar;
//
//    @FXML
//    private Button btnSalvar;
//
//    @FXML
//    private Label lblNome1;
//
//    @FXML
//    private Label lblNome2;
//
//    @FXML
//    private TableView<Visitante> tableVisitante;
//
//    @FXML
//    private TableColumn<Visitante, Integer> idTableVisita;
//
//    @FXML
//    private TableColumn<Visitante, String> nomeTableVisita;
//
//    @FXML
//    private TableColumn<Visitante, String> cpfTableVisita;
//
//    @FXML
//    private TableColumn<Visitante, String> telTableVisita;
//
//    @FXML
//    private TableColumn<Visitante, String> emailTableVisita;
//
//    @FXML
//    private Button btnCancelar11;
//
//    @FXML
//    private Button btnEditar;
//
//    @FXML
//    private Label lblId1;
//
//    @FXML
//    private TextField txfId1;
//
//    @FXML
//    private Label lblId12;
//
//    @FXML
//    private TextField txfId11;
//
//    @FXML
//    private Label lblId13;
//
//    @FXML
//    private TextField txfId12;
//
//    @FXML
//    private Label lblId14;
//
//    @FXML
//    private TextField txfId13;
//
//    @FXML
//    private Label lblId11;
//
//    @FXML
//    private TextField txfId14;
//
//    @FXML
//    private Label lblApartamento1;
//
//    @FXML
//    private Label lblNumeroAp1;
//
//    @FXML
//    private Label lblBlocoAp1;
//
//    @FXML
//    private ChoiceBox<?> chcBlocoAp1;
//
//    @FXML
//    private ChoiceBox<?> chcNumeroAp1;
//
//    @FXML
//    private Button btnCancelar1;
//
//    @FXML
//    private Button btnSalvar1;
    
    
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
    private TableColumn<Visitante, String> nomeTableVisita;

    @FXML
    private TableColumn<Visitante, String> cpfTableVisita;

    @FXML
    private TableColumn<Visitante, String> telTableVisita;

    @FXML
    private TableColumn<Visitante, String> emailTableVisita;

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
		nomeTableVisita.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cpfTableVisita.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		telTableVisita.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		emailTableVisita.setCellValueFactory(new PropertyValueFactory<>("email"));
		atualizaTabela();
	}
	
	private void atualizaTabela() {
		List<Visitante> visitantes = controlaVisitante.listar();
		
		for (int i = 0; i < visitantes.size(); i++) {
			visitantes.get(i).getPessoa();
						
		}
		
		tableVisitante.getItems().setAll(controlaVisitante.listar());
	}

}
