package br.upe.syscond;

import java.io.IOException;

import br.upe.syscond.controllers.InterfaceUsuarioController;
import br.upe.syscond.controllers.UsuarioController;
import br.upe.syscond.models.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
	
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
    	InterfaceUsuarioController userCont = new UsuarioController();
    	
    	String login = this.txfUser.getText();
    	String senha = this.txfSenha.getText();
    	Usuario user = null;
    	
    	user = userCont.buscar(new Usuario(login, senha, null));

    	if(user!= null) {
    		App.setRoot("secondary");    		
    	}else {
    		this.lbl1.setText("Usuario e/ou senha invalida");
    	}
    	
    }
    
}
