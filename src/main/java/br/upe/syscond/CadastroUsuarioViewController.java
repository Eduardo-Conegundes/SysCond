package br.upe.syscond;

import br.upe.syscond.controllers.InterfaceUsuarioController;
import br.upe.syscond.controllers.UsuarioController;
import br.upe.syscond.models.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CadastroUsuarioViewController {
	
	static InterfaceUsuarioController controlaUsuario = new UsuarioController();
	
    @FXML
    private Label lblTitulo;

    @FXML
    private Label lblLogin;

    @FXML
    private Label lblSenha;

    @FXML
    private TextField txtLogin;

    @FXML
    private Label lblConfirmarSenha;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private PasswordField txtConfirmarSenha;

    @FXML
    private Button idBtnCriar;

    @FXML
    void CadastrarUsuario(MouseEvent event) {
		if (txtSenha.getText().compareTo(txtConfirmarSenha.getText()) == 0) {
			try {
				controlaUsuario.criar(new Usuario(this.txtLogin.getText(), this.txtSenha.getText()));
				Alerts.alertaSucesso("Usuário cadastrado com sucesso!");
				App.setRoot("LoginView");
			} catch (Exception e) {
				e.printStackTrace();
				Alerts.alertaErro("Erro ao salvar usuário.");
			}
		} else {
			Alerts.alertaErro("Senhas diferentes. Digite novamente");
			txtSenha.clear();
			txtConfirmarSenha.clear();
		}
    }
}
