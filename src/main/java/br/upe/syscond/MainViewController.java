package br.upe.syscond;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MainViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="VisitanteMain"
    private Button VisitanteMain; // Value injected by FXMLLoader

    @FXML // fx:id="sairMain"
    private Button sairMain; // Value injected by FXMLLoader

    @FXML // fx:id="MoradorMain"
    private Button MoradorMain; // Value injected by FXMLLoader

    @FXML // fx:id="ApartamentoMain"
    private Button ApartamentoMain; // Value injected by FXMLLoader

    @FXML // fx:id="VeiculoMain1"
    private Button VeiculoMain1; // Value injected by FXMLLoader

    @FXML // fx:id="UsuarioMain11"
    private Button UsuarioMain11; // Value injected by FXMLLoader

    @FXML // fx:id="FuncionarioMain"
    private Button FuncionarioMain; // Value injected by FXMLLoader


    @FXML
    void switchTelaApartamento(MouseEvent event) {
    	try {
			App.setRoot("ApartamentoView");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void switchTelaMorador(MouseEvent event) {
    	try {
			App.setRoot("MoradorView");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    @FXML
    void switchTelaVisitante(MouseEvent event) {
    	try {
			App.setRoot("VisitanteView");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    @FXML
    void switchTelaVeiculo(MouseEvent event) {
    	try {
			App.setRoot("VeiculoView");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    @FXML
    void switchTelaUsuario(MouseEvent event) {
    	try {
			App.setRoot("UsuarioView");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    @FXML
    void switchTelaFuncionario(MouseEvent event) {
    	try {
			App.setRoot("FuncionarioView");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    @FXML
    void switchTelaLogin(MouseEvent event) {
    	try {
			App.setRoot("LoginView");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
