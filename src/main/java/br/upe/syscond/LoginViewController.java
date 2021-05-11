package br.upe.syscond;

import java.io.IOException;

import br.upe.syscond.controllers.InterfaceUsuarioController;
import br.upe.syscond.controllers.UsuarioController;
import br.upe.syscond.models.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class LoginViewController {
	static InterfaceUsuarioController userCont = new UsuarioController();
	
    @FXML
    private ImageView imglogin;

    @FXML
    private TextField txfUser;

    @FXML
    private PasswordField txfSenha;

    @FXML
    private Button btnEntrar;

    @FXML
    private Label lblErroLogin;

    @FXML
    private Label lblTituloChamada;

    @FXML
    private Button btnCadastrarUsuario;

    @FXML
    void switchNovoUsuario(ActionEvent event) {
    	try {
			App.setRoot("CadastroUsuarioView");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    private void switchToMain() throws IOException {
    	String login = this.txfUser.getText();
    	String senha = this.txfSenha.getText();
    	try {
			userCont.buscar(new Usuario(login, senha));
			this.lblErroLogin.setText("");
			App.setRoot("MainView");		
		} catch (Exception e){
			e.printStackTrace();
			this.lblErroLogin.setText("Login e/ou Senha inválida");
		}
    	
    }
    
}
