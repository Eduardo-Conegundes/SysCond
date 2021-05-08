package br.upe.syscond;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.upe.syscond.controllers.InterfaceUsuarioController;
import br.upe.syscond.controllers.UsuarioController;
import br.upe.syscond.models.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class UsuarioViewController implements Initializable{

	static InterfaceUsuarioController controlaUsuario = new UsuarioController();
	private ObservableList<Usuario> select; 

	@FXML
	private Label lblId;

	@FXML
	private Label lblsenha;

	@FXML
	private TextField txfSenha;

	@FXML
	private Label lblNivel;

	@FXML
	private Label txfId;

	@FXML
	private TextField txfNivel;

	@FXML
	private Label lblEmail;

	@FXML
	private TextField txfEmail;

	@FXML
	private TableView<Usuario> tableUsuario;

	@FXML
	private TableColumn<Usuario, Integer> idTableUsuario;

	@FXML
	private TableColumn<Usuario, String> emailTableUsuario;

	@FXML
	private TableColumn<Usuario, String> senhaTableUsuario;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnEditar;

	@FXML
	private Button btnExcluir;

	@FXML
	void EditarUsuario(MouseEvent event) {
		this.select = tableUsuario.getSelectionModel().getSelectedItems();
		this.txfEmail.setText(select.get(0).getEmail());
		this.txfSenha.setText(select.get(0).getSenha());
		this.txfId.setText(Integer.toString(select.get(0).getId()));
	}

	@FXML
	void ExcluirUsuario(MouseEvent event) {
		this.select = tableUsuario.getSelectionModel().getSelectedItems();
		try {
			if(Alerts.alertaDeletar()) {
				controlaUsuario.deletar(this.select.get(0));				
			}
		} catch (Exception e) {
			Alerts.alertaErro("Erro ao deletar");
			e.printStackTrace();
		}
		limpaTela();
		atualizaTabela();
	}

	@FXML
	void salvarUsuario(MouseEvent event) {
		this.select = null;
		salvar();
		limpaTela();
		atualizaTabela();
	}

	@FXML
	void switchMain(MouseEvent event) {
		try {
			App.setRoot("MainView");
		} catch (IOException e) {
			Alerts.alertaErro("Erro ao voltar pagina principal");
			e.printStackTrace();
		}

	}

	public void initialize(URL location, ResourceBundle resources) {	
		idTableUsuario.setCellValueFactory(new PropertyValueFactory<>("id"));
		emailTableUsuario.setCellValueFactory(new PropertyValueFactory<>("email"));
		senhaTableUsuario.setCellValueFactory(new PropertyValueFactory<>("senha"));
		atualizaTabela();
	}

	private void atualizaTabela() {
		try {
			tableUsuario.setItems(FXCollections.observableArrayList(controlaUsuario.listar()));			
		} catch (Exception e) {
			Alerts.alertaErro("Erro ao listar tabela");
			e.printStackTrace();
		}
	}

	private void limpaTela() {
		this.txfEmail.setText("");
		this.txfSenha.setText("");
		this.txfId.setText("");
	}

	private void salvar() {
		String email = this.txfEmail.getText();
		String senha = this.txfSenha.getText();
		String id = this.txfId.getText();

		Usuario usuario = new Usuario(email, senha);

		if(!id.equals("")) {
			usuario.setId(Integer.parseInt(id));
			try {
				controlaUsuario.atualizar(usuario);
				Alerts.alertaSucesso("Atualizado com sucesso!");
			} catch (Exception e) {
				Alerts.alertaErro("Erro ao atualizar");
				e.printStackTrace();
			}
		}else {
			try {
				controlaUsuario.criar(usuario);
				Alerts.alertaSucesso("Salvo com sucesso!");
			} catch (Exception e) {
				Alerts.alertaErro("Erro ao salvar");
			}
		}
	}
}
