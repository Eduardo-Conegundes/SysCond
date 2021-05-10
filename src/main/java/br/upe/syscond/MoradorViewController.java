package br.upe.syscond;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.upe.syscond.controllers.ApartamentoController;
import br.upe.syscond.controllers.InterfaceApartamentoController;
import br.upe.syscond.controllers.InterfaceMoradorController;
import br.upe.syscond.controllers.MoradorController;
import br.upe.syscond.models.Apartamento;
import br.upe.syscond.models.Morador;
import br.upe.syscond.models.Pessoa;
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


public class MoradorViewController implements Initializable{

	static InterfaceMoradorController controlaMorador = new MoradorController();
	static InterfaceApartamentoController controlaApartamento = new ApartamentoController();

	private ObservableList<Morador> select;

	@FXML
	private Label lblId;

	@FXML
	private Label txfId;

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
	private ChoiceBox<Apartamento> chcAp;

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
    
    /**
     * 
     * @param--> recebe como paramentro event do tipo MouseEvent, para que seja efetuado a etapas de salvar, limpar e atualizar a tela da interface ao clicar no botao salvar.
     */
	@FXML
	void salvarMorador(MouseEvent event) {
		salvar();
		limpaTela();
		atualizaTabela();
	}
	
	/**
	 * 
	 * @param--> recebe como paramentro event do tipo MouseEvent, para que seja efetuado a sele��o do Morador que deseja-se editar ao ser cliclar..
	 */
	@FXML
	void editarMorador(MouseEvent event) {
		this.select = tableMorador.getSelectionModel().getSelectedItems();
		this.txfId.setText(Integer.toString(select.get(0).getId()));
		this.txfNome.setText(select.get(0).getPessoa().getNome());
		this.txfCPF.setText(select.get(0).getPessoa().getCpf());
		this.txfEmail.setText(select.get(0).getPessoa().getEmail());
		this.txfTel.setText(select.get(0).getPessoa().getTelefone());
	}
	
	/**
	 * 
	 * @param--> recebe como paramentro event do tipo MouseEvent, para que seja efetuado a sele��o do Morador que deseja-se excluir ao ser cliclar..
	 */
	@FXML
	void excluirMorador(MouseEvent event) {
		this.select = tableMorador.getSelectionModel().getSelectedItems();
		deletar();
		limpaTela();
		atualizaTabela();
	}
	
	/**
	 * Metodo que recebe os valores digitados na interface para salvar ou atualizar um Morador.
	 */
	void salvar() {
		Morador morador = new Morador(
				new Pessoa(this.txfNome.getText(), 
						this.txfCPF.getText(), 
						this.txfTel.getText(), 
						this.txfEmail.getText()), 
				this.chcAp.getSelectionModel().getSelectedItem()
				);

		String id = this.txfId.getText();

		//caso atualizar
		if(!id.equals("")) {
			morador.setId(Integer.parseInt(id));
			try {
				controlaMorador.atualizar(morador);
				Alerts.alertaSucesso("Atualizado com Sucesso!");
			} catch (Exception e) {
				e.printStackTrace();
				Alerts.alertaErro(e.getMessage());
			}
		}else {
			try {
				controlaMorador.criar(morador);
				Alerts.alertaSucesso("Salvo com Sucesso!");
			} catch (Exception e) {
				Alerts.alertaErro(e.getMessage());
			}			
		}
		limpaTela();
		atualizaTabela();

	}
	
	/**
	 * 
	 * @param --> recebe como paramentro event do tipo MouseEvent, para que seja efetuado a chamada da MainView ao cliclar para operar qualquer fun��o do crude..
	 */
	@FXML
	void switchMain(MouseEvent event) {
		try {
			App.setRoot("MainView");
		} catch (IOException e) {
			Alerts.alertaErro(e.getMessage());
		}

	}
	
	/**
	 * inicializar o controlador MoradorViewController  depois que seu elemento raiz foi completamente processado.
	 */
	public void initialize(URL location, ResourceBundle resources) {
		limpaTela();
		this.idTableMorador.setCellValueFactory(new PropertyValueFactory<>("id"));
		this.pessoaTableMorador.setCellValueFactory(new PropertyValueFactory<>("PessoaString"));
		this.ApartamentoTableMorador.setCellValueFactory(new PropertyValueFactory<>("ApartamentoString"));
		atualizaTabela();
	}
	
	
	/**
	 * Metodo que deletar o morador.
	 */
	private void deletar() {
		try {
			controlaMorador.deletar(this.select.get(0));
			Alerts.alertaSucesso("Deletado com Sucesso!");
		} catch (Exception e) {
			Alerts.alertaErro(e.getMessage());
		}
	}
	
	/**
	 * Metodo que limpa os campos apos serem salvados ou atualizados.
	 */
	private void limpaTela() {
		this.txfCPF.setText(null);
		this.txfEmail.setText(null);
		this.txfId.setText("");
		this.txfNome.setText(null);
		this.txfTel.setText(null);
		this.chcAp.setItems(FXCollections.observableArrayList());
	}
	
	/**
	 * Metodo que atualiza o a tabela de Morador na interface.
	 */
	private void atualizaTabela() {
		try {
			this.tableMorador.setItems(FXCollections.observableArrayList(controlaMorador.listar()));
			this.chcAp.setItems(FXCollections.observableArrayList(controlaApartamento.listar()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}