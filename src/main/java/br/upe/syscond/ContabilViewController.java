package br.upe.syscond;

import java.net.URL;
import java.util.ResourceBundle;

import br.upe.syscond.controllers.ContabilController;
import br.upe.syscond.controllers.InterfaceContabilController;
import br.upe.syscond.models.Contas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ContabilViewController implements Initializable{
	static InterfaceContabilController controlaContas;
	private ObservableList<Contas> select;
	boolean statusConta;

    @FXML
    private TextField txfIdentificador;

    @FXML
    private TextField txfPagador;

    @FXML
    private Label lblBeneficiario;

    @FXML
    private TextField txfBeneficiario;

    @FXML
    private Label lblPagador;

    @FXML
    private Label lblIdentificador;

    @FXML
    private TableView<Contas> tableContabil;

    @FXML
    private TableColumn<Contas, String> Contabilidentificador;

    @FXML
    private TableColumn<Contas, String> ContabilPagador;

    @FXML
    private TableColumn<Contas, String> ConabilBeneficiario;

    @FXML
    private TableColumn<Contas, Float> ContabilValor;

    @FXML
    private TableColumn<Contas, String> ContabilTipo;

    @FXML
    private TableColumn<Contas, String> ContabilDataEmitir;

    @FXML
    private TableColumn<Contas, String> ContabilDataVence;

    @FXML
    private TableColumn<Contas, String> ContabilStatus;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnEditar;

    @FXML
    private TextField txtValor;

    @FXML
    private Label lblValor;

    @FXML
    private RadioButton txtReceber;

    @FXML
    private RadioButton txtPagar;

    @FXML
    private DatePicker textlblDataEmissao;

    @FXML
    private DatePicker texttxtDataVencimento;

    @FXML
    private Label lblDataEmissao;

    @FXML
    private Label txtDataVencimento;
    
    @FXML
    private CheckBox StatusPaga;
    
    @FXML
    private Label lblSelecioneTipo;

    @FXML
    private Label lblSelecioneSePaga;
  
    @FXML
    void EditarConta(MouseEvent event) {
    	this.select = tableContabil.getSelectionModel().getSelectedItems();
    	this.txfIdentificador.setText(select.get(0).getIdentificador());
    	this.txfBeneficiario.setText(select.get(0).getBeneficiario());
    	this.txfPagador.setText(select.get(0).getPagador());
    	this.txfBeneficiario.setText(select.get(0).getBeneficiario());
    	this.txtValor.setText(Float.toString(select.get(0).getValor()));
    	this.textlblDataEmissao.setValue(select.get(0).getDataEmissao());
    	this.texttxtDataVencimento.setValue(select.get(0).getDataVencimento());
    	
    	if(this.select.get(0).getStatusPaga()) {
    		this.StatusPaga.isArmed();
    	}else {
    		this.StatusPaga.isDisable();
    	}
    	
    }
    
    /**
	 * caso o usuario confirme o alerta, a opcão escolhida será deletada
	 */
    @FXML
    void ExcluirConta(MouseEvent event) {
    	this.select = tableContabil.getSelectionModel().getSelectedItems();
    	try {
    		if(Alerts.alertaDeletar()) {
    			controlaContas.deletar(select.get(0));
    			Alerts.alertaSucesso("Conta excluida com Sucesso!");
    			limpaTela();
    	    	atualizaTabela();
    		}
		} catch (Exception e) {
			Alerts.alertaErro(e.getMessage());
		}
    }

    @FXML
    void salvarConta(MouseEvent event) {
    	if(this.select!=null) {
    		salvar(this.select.get(0).getId());
    	}else {
    		salvar(0);
    	}
    	limpaTela();
    	atualizaTabela();
    }

    @FXML
    void switchMain(MouseEvent event) {
    	try {
			App.setRoot("MainView");
		} catch (Exception e) {
			Alerts.alertaErro(e.getMessage());
		}
    }
    
    /**
	 * metodo que inicia ao chamar a tela
	 */
	public void initialize(URL location, ResourceBundle resources) {
		try {
			controlaContas = ContabilController.getInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.Contabilidentificador.setCellValueFactory(new PropertyValueFactory<>("Identificador"));
		this.ContabilPagador.setCellValueFactory(new PropertyValueFactory<>("Pagador"));
		this.ConabilBeneficiario.setCellValueFactory(new PropertyValueFactory<>("Beneficiario"));
		this.ContabilValor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
		this.ContabilTipo.setCellValueFactory(new PropertyValueFactory<>("AReceberString"));
		this.ContabilDataEmitir.setCellValueFactory(new PropertyValueFactory<>("DataEmissao"));
		this.ContabilDataVence.setCellValueFactory(new PropertyValueFactory<>("DataVencimento"));
		this.ContabilStatus.setCellValueFactory(new PropertyValueFactory<>("StatusPagaString"));
		atualizaTabela();
	}
	
	/**
	 * limpa todos os campos da tela
	 */
	private void limpaTela() {
		this.txfIdentificador.setText(null);
		this.txfPagador.setText(null);
		this.txfBeneficiario.setText(null);
		this.txtValor.setText(null);
		this.textlblDataEmissao.setValue(null);
		this.texttxtDataVencimento.setValue(null);
		this.StatusPaga.isDisable();
	}
	
	/**
	 * busca da base e seta os valores na tabela
	 */
	private void atualizaTabela() {
		try {
			this.tableContabil.setItems(FXCollections.observableArrayList(controlaContas.listar()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void salvar(int id) {
		if(id==0) {
			try {
				controlaContas.criar(this.pegarDados());
				Alerts.alertaSucesso("Salvo com Sucesso!");
			} catch (Exception e) {
				Alerts.alertaErro(e.getMessage());
			}
		}else {
			Contas contas = this.pegarDados();
			contas.setId(id);
			try {
				controlaContas.atualizar(contas);
				Alerts.alertaSucesso("Atualizado com Sucesso!");
			} catch (Exception e) {
				Alerts.alertaErro(e.getMessage());
			}
		}
	}
	
	@FXML
    void verificaStatus(MouseEvent event) {
		
		this.txtPagar.setOnAction(e -> {
			if(this.txtPagar.isSelected()) {
				this.txtReceber.setDisable(true);
				statusConta = this.txtPagar.isSelected();
			}
		});
		
		this.txtReceber.setOnAction(e -> {
			if(this.txtReceber.isSelected()) {
				this.txtPagar.setDisable(true);
				statusConta = this.txtReceber.isSelected();
			}
		});
	}
	
	private Contas pegarDados() {
		return new Contas(this.txfIdentificador.getText(), this.txfPagador.getText(), this.txfBeneficiario.getText(), Float.parseFloat(this.txtValor.getText()),this.textlblDataEmissao.getValue(), this.texttxtDataVencimento.getValue(),this.statusConta, this.StatusPaga.isArmed());
	}

}
