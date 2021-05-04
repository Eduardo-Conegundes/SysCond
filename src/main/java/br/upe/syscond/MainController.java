package br.upe.syscond;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class MainController {

    @FXML
    private MenuItem miApartamentoCriar;

    @FXML
    private MenuItem miEmpresaCriar;

    @FXML
    private MenuItem miFinanceiroCriar;

    @FXML
    private MenuItem miLocacaoCriar;

    @FXML
    private MenuItem miAlmoxarifadoCriar;

    @FXML
    private MenuItem miFuncionarioCriar;

    @FXML
    private MenuItem miMoradorCriar;

    @FXML
    private MenuItem miServicoProdutoCriar;

    @FXML
    private MenuItem miUsuarioCriar;

    @FXML
    private MenuItem miVeiculoCriar;

    @FXML
    private MenuItem miVisitanteCriar;

    @FXML
    private MenuItem miApartamentoAlterar;

    @FXML
    private MenuItem miEmpresaAlterar;

    @FXML
    private MenuItem miFinanceiroAlterar;

    @FXML
    private MenuItem miLocacaoAlterar;

    @FXML
    private MenuItem miAlmoxarifadoAlterar;

    @FXML
    private MenuItem miFuncionarioAlterar;

    @FXML
    private MenuItem miMoradorAlterar;

    @FXML
    private MenuItem miServicoProdutoAlterar;

    @FXML
    private MenuItem miUsuarioAlterar;

    @FXML
    private MenuItem miVeiculoAlterar;

    @FXML
    private MenuItem miVisitanteAlterar;

    @FXML
    private MenuItem miApartamentoVisualizar;

    @FXML
    private MenuItem miEmpresaVisualizar;

    @FXML
    private MenuItem miFinanceiroVisualizar;

    @FXML
    private MenuItem miLocacaoVisualizar;

    @FXML
    private MenuItem miAlmoxarifadoVisualizar;

    @FXML
    private MenuItem miFuncionarioVisualizar;

    @FXML
    private MenuItem miMoradorVisualizar;

    @FXML
    private MenuItem miServicoProdutoVisualizar;

    @FXML
    private MenuItem miUsuarioVisualizar;

    @FXML
    private MenuItem miVeiculoVisualizar;

    @FXML
    private MenuItem miVisitanteVisualizar;

    @FXML
    void switchTelaApartamento(ActionEvent event) {
    	try {
			App.setRoot("ApartamentoView");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void switchTelaMorador(ActionEvent event) {
    	try {
			App.setRoot("MoradorView");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    @FXML
    void switchTelaVisitante(ActionEvent event) {
    	try {
			App.setRoot("VisitanteView");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

}
