package br.upe.syscond;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import br.upe.syscond.controllers.EspacoController;
import br.upe.syscond.controllers.InterfaceLocacaoController;
import br.upe.syscond.controllers.InterfaceMoradorController;
import br.upe.syscond.controllers.MoradorController;
import br.upe.syscond.models.Espaco;
import br.upe.syscond.models.Morador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class LocacaoViewController implements Initializable{

	private static InterfaceLocacaoController controlaLoc = new EspacoController();
	private static InterfaceMoradorController controlaMorador = new MoradorController();
	private ObservableList<Espaco> select;
	
	@FXML
	private Label lblMorador;

	@FXML
	private Label lblDataIni;

	@FXML
	private Label lblHora;

	@FXML
	private TextField horafim;

	@FXML
	private Label lblValor;

	@FXML
	private TextField txfValor;

	@FXML
	private TableView<Espaco> tableLocacao;

	@FXML
	private TableColumn<Espaco, String> Morador;

	@FXML
	private TableColumn<Espaco, Date> DataInicial;

	@FXML
	private TableColumn<Espaco, Date> DataFinal;

	@FXML
	private TableColumn<Espaco, Date> Hora;

	@FXML
	private TableColumn<Espaco, String> Espaco;

	@FXML
	private TableColumn<Espaco, Float> Valor;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnEditar;

	@FXML
	private Button btnExcluir;

	@FXML
	private ChoiceBox<Morador> cbMorador;

	@FXML
	private DatePicker data;

	@FXML
	private TextField txfEspaco;

	@FXML
	private Label lblEspaco;

	@FXML
	private TextField horainicio;

	@FXML
	void EditarLocacao(MouseEvent event) {
		this.select = tableLocacao.getSelectionModel().getSelectedItems();
		this.horafim.setText(select.get(0).getHorarioFim().toString());
		this.horainicio.setText(select.get(0).getHorarioInicio().toString());
		this.txfEspaco.setText(select.get(0).getEspaco());
		this.data.setValue(select.get(0).getData().toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate());
		this.cbMorador.setValue(this.select.get(0).getMorador());
		this.txfValor.setText((this.select.get(0).getValor() + ""));
	}

	@FXML
	void ExcluirLocacao(MouseEvent event) {
		this.select = tableLocacao.getSelectionModel().getSelectedItems();
		try {
			if(Alerts.alertaDeletar()) {
				controlaLoc.deletar(this.select.get(0));
				Alerts.alertaSucesso("Deletado com Sucesso!");				
				limpaTela();
			}
		} catch (Exception e) {
			Alerts.alertaErro(e.getMessage());
		}
		atualizaTabela();
	}

	@FXML
	void salvarLocacao(MouseEvent event) {
		if(this.select!=null) {
    		salvar(this.select.get(0).getId());
    	}else {
    		salvar(0);
    	}
    	limpaTela();
    	atualizaTabela();
	}

	private void limpaTela() {
		this.horafim.setText(null);
		this.horainicio.setText(null);
		this.txfEspaco.setText(null);
		this.data.setValue(null);
		this.cbMorador.setValue(null);
		this.txfValor.setText(null);
	}

	private void salvar(int id) {
		if(id==0) {
			try {
				controlaLoc.criar(this.pegarDados());
				Alerts.alertaSucesso("Salvo com Sucesso!");
			} catch (Exception e) {
				Alerts.alertaErro(e.getMessage());
			}
		}else {
			Espaco espaco = this.pegarDados();
			espaco.setId(id);
			try {
				controlaLoc.atualizar(espaco);
				Alerts.alertaSucesso("Atualizado com Sucesso!");
			} catch (Exception e) {
				Alerts.alertaErro(e.getMessage());
			}
		}
	}
		
	private Espaco pegarDados() {
		try {
			SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
			Date horaini;
			horaini = formatoHora.parse(this.horainicio.getText());
			Date horafim = formatoHora.parse(this.horafim.getText());
			Date data = java.sql.Date.valueOf(this.data.getValue());
			return new Espaco(data, horaini, horafim, this.cbMorador.getValue(), this.txfEspaco.getText(), Float.parseFloat(this.txfValor.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@FXML
	void switchMain(MouseEvent event) {
		try {
			App.setRoot("MainView");
		} catch (IOException e) {
			Alerts.alertaErro("Erro");
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Morador.setCellValueFactory(new PropertyValueFactory<>("MoradorToString"));
		DataInicial.setCellValueFactory(new PropertyValueFactory<>("HorarioInicio"));
		DataFinal.setCellValueFactory(new PropertyValueFactory<>("HorarioFim"));
		Hora.setCellValueFactory(new PropertyValueFactory<>("Data"));
		Espaço.setCellValueFactory(new PropertyValueFactory<>("Espaco"));
		Valor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
	
		atualizaTabela();
	}

	private void atualizaTabela() {
		try {
			this.tableLocacao.setItems(FXCollections.observableArrayList(controlaLoc.listar()));
			this.cbMorador.setItems(FXCollections.observableArrayList(controlaMorador.listar()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
