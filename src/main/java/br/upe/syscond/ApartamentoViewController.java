package br.upe.syscond;

import java.net.URL;
import java.util.ResourceBundle;

import br.upe.syscond.controllers.ApartamentoController;
import br.upe.syscond.controllers.InterfaceApartamentoController;
import br.upe.syscond.models.Apartamento;
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

public class ApartamentoViewController implements Initializable {
	static InterfaceApartamentoController controlaAp = new ApartamentoController();
	
	private ObservableList<Apartamento> select;

	@FXML
	private Label lblId;

	@FXML
	private Label txfId;

	@FXML
	private TextField txfBloco;

	@FXML
	private TextField txfNumero;

	@FXML
	private Label lblTel;

	@FXML
	private TextField txfVagas;

	@FXML
	private Label lblNumeroAp;

	@FXML
	private Label lblBlocoAp;

	@FXML
	private TableView<Apartamento> tableApartamento;

	@FXML
	private TableColumn<Apartamento, Integer> idTableApartamento;

	@FXML
	private TableColumn<Apartamento, String> blocoTableApartamento;

	@FXML
	private TableColumn<Apartamento, Integer> numeroTableApartamento;

	@FXML
	private TableColumn<Apartamento, Integer> vagasTableApartamento;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnEditar;
	
	/**
	 * inicializar o controlador ApartamentoViewController depois que seu elemento raiz foi completamente processado.
	 */
	public void initialize(URL location, ResourceBundle resources) {
		
		idTableApartamento.setCellValueFactory(new PropertyValueFactory<>("id"));
		blocoTableApartamento.setCellValueFactory(new PropertyValueFactory<>("bloco"));
		numeroTableApartamento.setCellValueFactory(new PropertyValueFactory<>("numero"));
		vagasTableApartamento.setCellValueFactory(new PropertyValueFactory<>("vagas"));
		
		try {
			tableApartamento.setItems(FXCollections.observableArrayList(controlaAp.listar()));
		} catch (Exception e) {
			Alerts.alertaErro("Erro ao listar na tabela");
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param--> recebe como paramentro event do tipo MouseEvent, para que seja efetuado a seleção do Apartamento que deseja-se editar ao ser cliclar..
	 */
	@FXML
	void EditarApartamento(MouseEvent event) {
		this.select = tableApartamento.getSelectionModel().getSelectedItems();
		setDados();
	}
	/**
	 * 
	 * @param--> recebe como paramentro event do tipo MouseEvent, para que seja efetuado a seleção do Apartamento que deseja-se excluir ao ser cliclar..
	 */
	@FXML
	void ExcluirApartamento(MouseEvent event) {
		this.select = tableApartamento.getSelectionModel().getSelectedItems();
		try {
			if(Alerts.alertaDeletar()) {
				controlaAp.deletar(this.select.get(0));				
			}
		} catch (Exception e) {
			Alerts.alertaErro("Erro ao Deletar");
			e.printStackTrace();
		}
		limpaTela();
		initialize(null, null);
	}
	
	/**
	 * Metodo que recebe os valores digitados na interface para salvar ou atualizar um Apartamento.
	 */
	@FXML
	void salvarApartamento(MouseEvent event) {
		String id = this.txfId.getText();
		String bloco = this.txfBloco.getText();
		int numero = Integer.parseInt(this.txfNumero.getText());
		int vagas = Integer.parseInt(this.txfVagas.getText());
		
		Apartamento ap = new Apartamento(bloco, numero, vagas);
		
			if(!id.equals("")) {
				try {
					ap.setId(Integer.parseInt(id));
					controlaAp.atualizar(ap);
					Alerts.alertaSucesso("Atualizado com Sucesso!");
				} catch (Exception e) {
					Alerts.alertaErro("Erro ao Atualizar...");
					e.printStackTrace();
				}
			}else {
				try {
					controlaAp.criar(ap);
					Alerts.alertaSucesso("Salvo com Sucesso!");
				} catch (Exception e) {
					Alerts.alertaErro("Erro ao salvar...");
					e.printStackTrace();
				}
			}
			limpaTela();
			initialize(null,null);
	}
	
	/**
	 * 
	 * @param --> recebe como paramentro event do tipo MouseEvent, para que seja efetuado a chamada da MainView ao cliclar para operar qualquer função do crude..
	 */
	@FXML
	void switchMain(MouseEvent event) {
		try {
			App.setRoot("MainView");
		} catch (Exception e) {
			Alerts.alertaErro("Erro ao ir ao Menu principal!");
		}
	}
	
	/**
	 * Metodo de setar os dados de apartamento na interface
	 */
	private void setDados() {
		this.txfId.setText(Integer.toString(select.get(0).getId()));
		this.txfBloco.setText(select.get(0).getBloco());
		this.txfNumero.setText(Integer.toString(select.get(0).getNumero()));
		this.txfVagas.setText(Integer.toString(select.get(0).getVagas()));
	}
	
	/**
	 * Metodo que limpa os campos apos serem salvados ou atualizados.
	 */
	private void limpaTela() {
		this.txfId.setText("");
		this.txfBloco.setText(null);
		this.txfNumero.setText(null);
		this.txfVagas.setText(null);
	}

}

