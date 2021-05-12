package br.upe.syscond;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.upe.syscond.controllers.ApartamentoController;
import br.upe.syscond.controllers.FluxoAlmoxarifadoController;
import br.upe.syscond.controllers.InterfaceApartamentoController;
import br.upe.syscond.controllers.InterfaceFluxoAlmoxarifadoController;
import br.upe.syscond.models.FluxoAlmoxarifado;
import br.upe.syscond.models.Morador;
import br.upe.syscond.models.Pessoa;
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
import javafx.scene.text.Text;

public class AlmoxarifadoViewController implements Initializable {
	static InterfaceFluxoAlmoxarifadoController controlaFluxo;
	private ObservableList<FluxoAlmoxarifado> select;
	
    @FXML
    private Label lblProduto;

    @FXML
    private TextField txfProduto;

    @FXML
    private Label lblQtd;

    @FXML
    private TextField txtQtd;

    @FXML
    private TableView<FluxoAlmoxarifado> tableAlmoxarifado;

    @FXML
    private TableColumn<FluxoAlmoxarifado, String> produtoTableFluxo;
    
    @FXML
    private TableColumn<FluxoAlmoxarifado, Integer> quantidadeTableFluxo;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnExcluir;

    @FXML
    private Text lblTituloChamada;

    /**
	 * Metodo que limpa os campos apos serem salvados ou atualizados.
	 */
	private void limpaTela() {
		this.txfProduto.setText(null);
		this.txtQtd.setText(null);
	}
	
	void salvar(int id) {
		FluxoAlmoxarifado fluxo = new FluxoAlmoxarifado(
				Integer.parseInt( this.txtQtd.getText()),
				this.txfProduto.getText()); 
		if(!(id == 0)) {
			fluxo.setId(id);
			try {
				controlaFluxo.atualizar(fluxo);
				Alerts.alertaSucesso("Atualizado com Sucesso!");
				limpaTela();
				initialize(null, null);
			} catch (Exception e) {
				e.printStackTrace();
				Alerts.alertaErro(e.getMessage());
			}
		}else {
			try {
				controlaFluxo.criar(fluxo);
				Alerts.alertaSucesso("Salvo com Sucesso!");
				limpaTela();
				initialize(null, null);
			} catch (Exception e) {
				Alerts.alertaErro(e.getMessage());
			}	
		}
	}
	
    private void deletar() {
		try {
			if(Alerts.alertaDeletar()) {
				controlaFluxo.deletar(this.select.get(0));
				Alerts.alertaSucesso("Deletado com Sucesso!");				
			}
		} catch (Exception e) {
			Alerts.alertaErro(e.getMessage());
		}
	}

	/**
	 * Metodo que atualiza o a tabela de Usuario na interface.
	 */
	private void atualizaTabela() {
		try {
			tableAlmoxarifado.setItems(FXCollections.observableArrayList(controlaFluxo.listar()));			
		} catch (Exception e) {
			Alerts.alertaErro("Erro ao listar tabela");
			e.printStackTrace();
		}
	}
	
    @FXML
    void editarFluxoAlmoxarifado(MouseEvent event) {
		this.select = tableAlmoxarifado.getSelectionModel().getSelectedItems();
    	this.txfProduto.setText(select.get(0).getNomeDoProduto());
		this.txtQtd.setText(select.get(0).getQtd() + "");
    }

    @FXML
    void excluirFluxoAlmoxarifado(MouseEvent event) {
    	this.select = tableAlmoxarifado.getSelectionModel().getSelectedItems();
		deletar();
		limpaTela();
		atualizaTabela();
    }
    
    @FXML
    void salvarFluxoAlmoxarifado(MouseEvent event) {
    	if(this.select == null) {
			salvar(0);
		}else {
			salvar(this.select.get(0).getId());
		}
    }

    @FXML
	void switchMain(MouseEvent event) {
    	try {
			App.setRoot("MainView");
		} catch (IOException e) {
			Alerts.alertaErro(e.getMessage());
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			controlaFluxo = FluxoAlmoxarifadoController.getInstance();
			
			this.produtoTableFluxo.setCellValueFactory(new PropertyValueFactory<>("ProdutoString"));
			this.quantidadeTableFluxo.setCellValueFactory(new PropertyValueFactory<>("QtdString"));
			atualizaTabela();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
