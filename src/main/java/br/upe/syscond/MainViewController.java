package br.upe.syscond;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MainViewController {

    @FXML
    private Button VisitanteMain;

    @FXML
    private Button sairMain;

    @FXML
    private Button MoradorMain;

    @FXML
    private Button ApartamentoMain;

    @FXML
    private Button VeiculoMain1;

    @FXML
    private Button UsuarioMain11;

    @FXML
    private Button FuncionarioMain;
    /**
     * 
     * @param event
     */
    @FXML
    void switchTelaEmpresa(MouseEvent event) {
    	try {
			App.setRoot("EmpresaView");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void switchTelaApartamento(MouseEvent event) {
    	try {
			App.setRoot("ApartamentoView");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /**
     * 
     * @param event
     */
    @FXML
    void switchTelaMorador(MouseEvent event) {
    	try {
			App.setRoot("MoradorView");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    /**
     * 
     * @param event
     */
    @FXML
    void switchTelaVisitante(MouseEvent event) {
    	try {
			App.setRoot("VisitanteView");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    /**
     * 
     * @param event
     */
    @FXML
    void switchTelaVeiculo(MouseEvent event) {
    	try {
			App.setRoot("VeiculoView");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    /**
     * 
     * @param event
     */
    @FXML
    void switchTelaUsuario(MouseEvent event) {
    	try {
			App.setRoot("UsuarioView");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    /**
     * 
     * @param event
     */
    @FXML
    void switchTelaFuncionario(MouseEvent event) {
    	try {
			App.setRoot("FuncionarioView");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    /**
     * 
     * @param event
     */
    @FXML
    void switchTelaLogin(MouseEvent event) {
    	try {
			App.setRoot("LoginView");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void switchTelaContabil(MouseEvent event) {
    	try {
    		App.setRoot("ContabilView");
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

}
