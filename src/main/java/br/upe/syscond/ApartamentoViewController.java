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
		blocoTableApartamento.setCellValueFactory(new PropertyValueFactory<>("bloco"));
		numeroTableApartamento.setCellValueFactory(new PropertyValueFactory<>("numero"));
		vagasTableApartamento.setCellValueFactory(new PropertyValueFactory<>("vagas"));
		atualizaTabela();
		this.select = null;
	}
	/**
	 * 
	 * @param--> recebe como paramentro event do tipo MouseEvent, para que seja efetuado a sele��o do Apartamento que deseja-se editar ao ser cliclar..
	 */
	@FXML
	void EditarApartamento(MouseEvent event) {
		this.select = tableApartamento.getSelectionModel().getSelectedItems();
		this.txfBloco.setText(select.get(0).getBloco());
		this.txfNumero.setText(Integer.toString(select.get(0).getNumero()));
		this.txfVagas.setText(Integer.toString(select.get(0).getVagas()));
	}
	/**
	 * 
	 * @param--> recebe como paramentro event do tipo MouseEvent, para que seja efetuado a sele��o do Apartamento que deseja-se excluir ao ser cliclar..
	 */
	@FXML
	void ExcluirApartamento(MouseEvent event) {
		this.select = tableApartamento.getSelectionModel().getSelectedItems();
		try {
			if(Alerts.alertaDeletar()) {
				controlaAp.deletar(this.select.get(0));
				Alerts.alertaSucesso("Deletado com Sucesso!");
			}
		} catch (Exception e) {
			Alerts.alertaErro("Erro ao Deletar");
		}
		limpaTela();
		atualizaTabela();
	}

	/**
	 * Metodo que recebe os valores digitados na interface para salvar ou atualizar um Apartamento.
	 */
	
	void salvar(int id) {
		String bloco = this.txfBloco.getText();
		int numero = Integer.parseInt(this.txfNumero.getText());
		int vagas = Integer.parseInt(this.txfVagas.getText());
		
		Apartamento ap = new Apartamento(bloco, numero, vagas);
		
			if(!(id == 0)) {
				ap.setId(id);
				try {
					controlaAp.atualizar(ap);
					Alerts.alertaSucesso("Atualizado com Sucesso!");
					
				} catch (Exception e) {
					e.printStackTrace();
					Alerts.alertaErro("Erro ao Atualizar...");	
				}
			}else {
				try {
					controlaAp.criar(ap);
					Alerts.alertaSucesso("Salvo com Sucesso!");
				} catch (Exception e) {
					Alerts.alertaErro("Erro ao salvar...");
				}
			}
			atualizaTabela();
			limpaTela();
	}
	
	/**
	 * 
	 * @param --> recebe como paramentro event do tipo MouseEvent, para que seja efetuado a chamada da MainView ao cliclar para operar qualquer fun��o do crude..
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
	 * Metodo que limpa os campos apos serem salvados ou atualizados.
	 */
	private void limpaTela() {
		this.txfBloco.setText(null);
		this.txfNumero.setText(null);
		this.txfVagas.setText(null);
	}
	
	/**
	 * Metodo que atualiza o a tabela de Usuario na interface.
	 */
	private void atualizaTabela() {
		try {
			tableApartamento.setItems(FXCollections.observableArrayList(controlaAp.listar()));			
		} catch (Exception e) {
			Alerts.alertaErro("Erro ao listar tabela");
			e.printStackTrace();
		}
	}
	
	@FXML
	void salvarApartamento(MouseEvent event) {
		if(this.select == null) {
			salvar(0);
		}else {
			salvar(this.select.get(0).getId());
		}
	}

}

