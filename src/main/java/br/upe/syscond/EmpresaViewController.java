package br.upe.syscond;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.upe.syscond.controllers.EmpresaController;
import br.upe.syscond.controllers.InterfaceEmpresaController;
import br.upe.syscond.models.Empresa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class EmpresaViewController implements Initializable{
	
	private static InterfaceEmpresaController controlaEmpresa = new EmpresaController();
	private ObservableList<Empresa> select;
	
    @FXML
    private TextField txfCnpj;

    @FXML
    private TextField txfNome;

    @FXML
    private TextField txfTelefone;
    
    @FXML
    private TextArea nomeProduto;
    
    @FXML
    private Label lblTel;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblCnpj;

    @FXML
    private TableView<Empresa> tableEmpresa;

    @FXML
    private TableColumn<Empresa, String> TableEmpresaCnpj;

    @FXML
    private TableColumn<Empresa, String> TableEmpresaNome;

    @FXML
    private TableColumn<Empresa, String> TableEmpresatelefone;

    @FXML
    private TableColumn<Empresa, String> TableEmpresaProduto;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnEditar;
    
    @FXML
    void EditarEmpresa(MouseEvent event) {
    	this.select = tableEmpresa.getSelectionModel().getSelectedItems();
    	this.txfCnpj.setText(select.get(0).getCnpj());
    	this.txfNome.setText(select.get(0).getNome());
    	this.txfTelefone.setText(select.get(0).getTelefone());
    	this.nomeProduto.setText(select.get(0).getServicoproduto());
    }

    @FXML
    void ExcluirEmpresa(MouseEvent event) {
    	this.select = tableEmpresa.getSelectionModel().getSelectedItems();
    	try {
    		if(Alerts.alertaDeletar()) {
    			controlaEmpresa.deletar(select.get(0));
    			Alerts.alertaSucesso("Empresa excluida com Sucesso!");
    			limpaTela();
    	    	atualizaTabela();
    		}
		} catch (Exception e) {
			Alerts.alertaErro("Erro ao Excluir empresa");
		}
    }

    @FXML
    void salvarEmpresa(MouseEvent event) {
    	if(this.select!=null) {
    		salvar(this.select.get(0).getId());
    	}else {
    		salvar(0);
    	}
    	limpaTela();
    	atualizaTabela();
    }

    private void limpaTela() {
    	this.txfCnpj.setText(null);
    	this.txfNome.setText(null);
    	this.txfTelefone.setText(null);
    	this.nomeProduto.setText(null);
    	this.select = null;
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
		this.TableEmpresaCnpj.setCellValueFactory(new PropertyValueFactory<>("Cnpj"));
		this.TableEmpresaNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		this.TableEmpresatelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		this.TableEmpresaProduto.setCellValueFactory(new PropertyValueFactory<>("Servicoproduto"));
		limpaTela();
		atualizaTabela();
	}
	
	private void atualizaTabela() {
		try {
			this.tableEmpresa.setItems(FXCollections.observableArrayList(controlaEmpresa.listar()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void salvar(int id) {
		
		if(id==0) {
			try {
				controlaEmpresa.criar(this.pegarDados());
				Alerts.alertaSucesso("Salvo com Sucesso!");
			} catch (Exception e) {
				Alerts.alertaErro(e.getMessage());
			}
		}else {
			Empresa empresa = this.pegarDados();
			empresa.setId(id);
			try {
				controlaEmpresa.atualizar(empresa);
				Alerts.alertaSucesso("Atualizado com Sucesso!");
			} catch (Exception e) {
				Alerts.alertaErro(e.getMessage());
			}
		}
	}
	
	private Empresa pegarDados() {
		return new Empresa(this.txfCnpj.getText(), this.nomeProduto.getText(), this.txfNome.getText(), this.txfTelefone.getText());
	}
}
