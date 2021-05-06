package br.upe.syscond;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import br.upe.syscond.controllers.InterfaceUsuarioController;
import br.upe.syscond.controllers.UsuarioController;
import br.upe.syscond.models.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class UsuarioViewController {

	static InterfaceUsuarioController controlaUsuario = new UsuarioController();
	@FXML
	private Label lblId;

	@FXML
	private TextField txfId;

	@FXML
	private Label lblsenha;

	@FXML
	private TextField txfSenha;

	@FXML
	private Label lblNivel;

	@FXML
	private TextField txfNivel;

	@FXML
	private Label lblEmail;

	@FXML
	private TextField txfEmail;

	@FXML
	private TableView<Usuario> tableUsuario;

	@FXML
	private TableColumn<Usuario, Usuario> usuarioTableUsuario;

	@FXML
	private TableColumn<Usuario, Integer> idTableUsuario;

	@FXML
	private TableColumn<Usuario, String> emailTableUsuario;

	@FXML
	private TableColumn<Usuario, String> senhaTableUsuario;

	@FXML
	private TableColumn<Usuario, String> nivelTableUsuario;

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

	}

	@FXML
	void ExcluirUsuario(MouseEvent event) {

	}

	@FXML
	void salvarUsuario(MouseEvent event) {
		String email = this.txfEmail.getText();
		String senha = this.txfSenha.getText();
		String nivel = this.txfNivel.getText();


		try {
			System.out.println(email + senha + nivel);			
			Usuario usuario = new Usuario(email, senha, nivel);
			controlaUsuario.criar(usuario);		
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
		idTableUsuario.setCellValueFactory(new PropertyValueFactory<>("id"));
		emailTableUsuario.setCellValueFactory(new PropertyValueFactory<>("email"));
		senhaTableUsuario.setCellValueFactory(new PropertyValueFactory<>("senha"));
		nivelTableUsuario.setCellValueFactory(new PropertyValueFactory<>("nivel"));
		usuarioTableUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
	}
}
