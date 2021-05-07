package br.upe.syscond;


import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import br.upe.syscond.controllers.InterfaceUsuarioController;
import br.upe.syscond.controllers.UsuarioController;
import br.upe.syscond.models.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
		alertaDeletar(this.select.get(0));
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
			alertaErro("Erro ao voltar pagina principal");
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
			alertaErro("Erro ao listar tabela");
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
				alertaSucesso("Atualizado com sucesso!");
			} catch (Exception e) {
				alertaErro("Erro ao atualizar");
				e.printStackTrace();
			}
		}else {
			try {
				controlaUsuario.criar(usuario);
				alertaSucesso("Salvo com sucesso!");
			} catch (Exception e) {
				alertaErro("Erro ao salvar");
			}
		}
	}

	private void alertaErro(String erro) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText(erro);
		alert.setContentText("Ooops, there was an error!");
		alert.showAndWait();
	}

	private void alertaDeletar(Usuario user) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText("Look, a Confirmation Dialog");
		alert.setContentText("Are you ok with this?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			try {
				controlaUsuario.deletar(user);
			} catch (Exception e) {
				alertaErro("Erro ao deletar");
				e.printStackTrace();
			}
		} else {
			return;
		}
	}
	
	private void alertaSucesso(String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(msg);
		alert.setContentText("I have a great message for you!");

		alert.showAndWait();
	}

}
