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
	 * botão salvar
	 * quando o usuario aperta, e chamado metodo salvar
	 * @param event
	 */
	@FXML
	void salvarMorador(MouseEvent event) {
		if(this.select == null) {
			salvar(0);
		}else {
			salvar(this.select.get(0).getId());
		}
	}
	/**
	 * botão editar
	 * coloca todos os dados da opcao selecionada na tela
	 * @param event
	 */
	@FXML
	void editarMorador(MouseEvent event) {
		this.select = tableMorador.getSelectionModel().getSelectedItems();
		this.txfNome.setText(select.get(0).getPessoa().getNome());
		this.txfCPF.setText(select.get(0).getPessoa().getCpf());
		this.txfEmail.setText(select.get(0).getPessoa().getEmail());
		this.txfTel.setText(select.get(0).getPessoa().getTelefone());
		this.chcAp.setValue(this.select.get(0).getApartamento());
		
	}
	/**
	 * metodo ao clicar no botao deletar
	 * @param event
	 */
	@FXML
	void excluirMorador(MouseEvent event) {
		this.select = tableMorador.getSelectionModel().getSelectedItems();
		deletar();
		limpaTela();
		atualizaTabela();
	}

	/**
	 * metodo chamado ao apertar o botão salvar
	 * @param id
	 */
	void salvar(int id) {
		Morador morador = new Morador(
				new Pessoa(this.txfNome.getText(), 
						this.txfCPF.getText(), 
						this.txfTel.getText(), 
						this.txfEmail.getText()), 
				this.chcAp.getSelectionModel().getSelectedItem()
				);
		
		//caso atualizar
		if(!(id == 0)) {
			morador.setId(id);
			try {
				controlaMorador.atualizar(morador);
				Alerts.alertaSucesso("Atualizado com Sucesso!");
				limpaTela();
				initialize(null, null);
			} catch (Exception e) {
				e.printStackTrace();
				Alerts.alertaErro(e.getMessage());
			}
		}else {
			try {
				controlaMorador.criar(morador);
				Alerts.alertaSucesso("Salvo com Sucesso!");
				limpaTela();
				initialize(null, null);
			} catch (Exception e) {
				Alerts.alertaErro(e.getMessage());
			}	
		}
	}
	
	/**
	 * encaminha o usuario a tela principal
	 * @param event
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
	 * metodo que inicia ao chamar a tela
	 */
	public void initialize(URL location, ResourceBundle resources) {
		this.pessoaTableMorador.setCellValueFactory(new PropertyValueFactory<>("PessoaString"));
		this.ApartamentoTableMorador.setCellValueFactory(new PropertyValueFactory<>("ApartamentoString"));
		atualizaTabela();
		this.select = null;
	}
	
	/**
	 * caso o usuario confirme o alerta, a opcão escolhida será deletada
	 */
	private void deletar() {
		try {
			if(Alerts.alertaDeletar()) {
				controlaMorador.deletar(this.select.get(0));
				Alerts.alertaSucesso("Deletado com Sucesso!");				
			}
		} catch (Exception e) {
			Alerts.alertaErro(e.getMessage());
		}
	}
	
	/**
	 * limpa todos os textfild da tela
	 */
	private void limpaTela() {
		this.txfCPF.setText(null);
		this.txfEmail.setText(null);
		this.txfNome.setText(null);
		this.txfTel.setText(null);
	}
	
	/**
	 * busca da base e seta os valores na tabela
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