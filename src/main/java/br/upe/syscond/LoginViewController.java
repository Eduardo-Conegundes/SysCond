package br.upe.syscond;

import java.io.IOException;

import br.upe.syscond.controllers.InterfaceUsuarioController;
import br.upe.syscond.controllers.UsuarioController;
import br.upe.syscond.models.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginViewController {
	static InterfaceUsuarioController userCont = new UsuarioController();
	
    @FXML
    private TextField txfUser;

    @FXML
    private TextField txfSenha;

    @FXML
    private Button btnEntrar;

    @FXML
    private Label lbl1;

    @FXML
    private void switchToMain() throws IOException {
    	String login = this.txfUser.getText();
    	String senha = this.txfSenha.getText();
    	try {
			userCont.buscar(new Usuario(login, senha));
			this.lbl1.setText("");
			App.setRoot("MainView");		
		} catch (Exception e) {
			e.printStackTrace();
			this.lbl1.setText("Login / Senha invalido");
		}
    	
    }
    
}
