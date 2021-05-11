package br.upe.syscond;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.upe.syscond.controllers.ApartamentoController;
import br.upe.syscond.controllers.InterfaceApartamentoController;
import br.upe.syscond.controllers.InterfaceVeiculoController;
import br.upe.syscond.controllers.VeiculoController;
import br.upe.syscond.models.Apartamento;
import br.upe.syscond.models.Veiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class VeiculoViewController implements Initializable {

	static InterfaceVeiculoController controlaVeiculo = new VeiculoController();
	static InterfaceApartamentoController controlaAp = new ApartamentoController();
	private ObservableList<Veiculo> select;

	@FXML
	private Label lblPlaca;

	@FXML
	private TextField txfPlaca;

	@FXML
	private Label lblApartamento;

	@FXML
	private Label lblNumeroAp;

	@FXML
	private Label lblBlocoAp;

	@FXML
	private ChoiceBox<Apartamento> chcAp;

	@FXML
	private TableView<Veiculo> tableVeiculo;

	@FXML
	private TableColumn<Veiculo, Integer> idTableVeiculo;

	@FXML
	private TableColumn<Veiculo, String> placaTableVeiculo;

	@FXML
	private TableColumn<Apartamento, Apartamento> colunaAp;

	@FXML
	private TableColumn<Apartamento, String> colunaApBloco;

	@FXML
	private TableColumn<Apartamento, Integer> colunaApNumero;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnEditar;

	@FXML
	private Button btnExcluir;
	
	/**
	 * 
	 * @param--> recebe como paramentro event do tipo MouseEvent, para que seja efetuado a seleção do Veiculo que deseja-se editar ao ser cliclar..
	 */
	@FXML
	void editarVeiculo(MouseEvent event) {
		this.select = tableVeiculo.getSelectionModel().getSelectedItems();
		this.txfPlaca.setText(select.get(0).getPlaca());
	}

	/**
	 * 
	 * @param--> recebe como paramentro event do tipo MouseEvent, para que seja efetuado a seleção do Veiculo que deseja-se excluir ao ser cliclar..
	 */
	@FXML
	void excluirVeiculo(MouseEvent event) {
		this.select = tableVeiculo.getSelectionModel().getSelectedItems();
		deletar(this.select.get(0));
		limpaTela();
		atualizaTabela();
	}
    
    /**
     * 
     * @param--> recebe como paramentro event do tipo MouseEvent, para que seja efetuado a etapas de salvar, limpar e atualizar a tela da interface ao clicar no botao salvar.
     */
	
	@FXML
	void salvarVeiculo(MouseEvent event) {
		if(this.select == null) {
			salvar(0);
		}else {
			salvar(this.select.get(0).getId());
		}
	}
	
	/**
	 * 
	 * @param --> recebe como paramentro event do tipo MouseEvent, para que seja efetuado a chamada da MainView ao cliclar para operar qualquer função do crude..
	 */
	@FXML
	void switchMain(MouseEvent event) {
		try {
			App.setRoot("MainView");
		} catch (IOException e) {
			Alerts.alertaErro("Erro");
			e.printStackTrace();
		}
	}
	
	/**
	 * inicializar o controlador VeiculoViewController  depois que seu elemento raiz foi completamente processado.
	 */
	public void initialize(URL location, ResourceBundle resources) {
		limpaTela();
		placaTableVeiculo.setCellValueFactory(new PropertyValueFactory<>("placa"));
		colunaAp.setCellValueFactory(new PropertyValueFactory<>("ApartamentoString"));
		atualizaTabela();
	}
	
	/**
	 * 
	 * @param metodo que recebe como parametro veiculo do tipo veiculo, para que seja efetuado a exclusão do mesmo
	 */
	private void deletar(Veiculo veiculo) {
		try {
			controlaVeiculo.deletar(veiculo);
			Alerts.alertaDeletar();
		} catch (Exception e) {
			Alerts.alertaErro("Erro");
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que limpa os campos apos serem salvados ou atualizados.
	 */
	private void limpaTela() {
		this.txfPlaca.setText("");
	}

	private void atualizaTabela() {
		try {
			this.tableVeiculo.setItems(FXCollections.observableArrayList(controlaVeiculo.listar()));
			this.chcAp.setItems(FXCollections.observableArrayList(controlaAp.listar()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que recebe os valores digitados na interface para salvar ou atualizar um Morador.
	 */
	void salvar(int id) {
	//	Integer id = this.select.get(0).getId();
		String placa = this.txfPlaca.getText();
		Veiculo veiculo = new Veiculo(placa, this.chcAp.getSelectionModel().getSelectedItem());
		if(!(id == 0)) {
			veiculo.setId(id);
			try {
				controlaVeiculo.atualizar(veiculo);
				Alerts.alertaSucesso("Atualizado com sucesso!");
			} catch (Exception e) {
				Alerts.alertaErro("Erro");
				e.printStackTrace();
			}
		}else {
			try {
				controlaVeiculo.criar(veiculo);
				Alerts.alertaSucesso("Criado com sucesso!");
			} catch (Exception e) {
				Alerts.alertaErro("Erro");
				e.printStackTrace();
			}
		}
		limpaTela();
		atualizaTabela();
	}
}
