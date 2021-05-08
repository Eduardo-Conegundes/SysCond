////package br.upe.syscond;
////
////import java.net.URL;
////import java.util.Date;
////import java.util.ResourceBundle;
////
////import br.upe.syscond.controllers.EspacoController;
////import br.upe.syscond.controllers.InterfaceLocacaoController;
////import br.upe.syscond.models.Espaco;
////import javafx.collections.FXCollections;
////import javafx.collections.ObservableList;
////import javafx.fxml.FXML;
////import javafx.fxml.Initializable;
////import javafx.scene.control.Button;
////import javafx.scene.control.ChoiceBox;
////import javafx.scene.control.DatePicker;
////import javafx.scene.control.Label;
////import javafx.scene.control.TableColumn;
////import javafx.scene.control.TableView;
////import javafx.scene.control.TextField;
////import javafx.scene.control.cell.PropertyValueFactory;
////import javafx.scene.input.MouseEvent;
////
////public class LocacaoViewController {
////	
////	static InterfaceLocacaoController controlaLocacao = new EspacoController();
////
////    @FXML
////    private Label lblId;
////
////    @FXML
////    private TextField txfId;
////
////    @FXML
////    private Label lblMorador;
////
////    @FXML
////    private Label lblDataIni;
////
////    @FXML
////    private Label lblHora;
////
////    @FXML
////    private TextField txfHora;
////
////    @FXML
////    private Label lblValor;
////
////    @FXML
////    private TextField txfValor;
////
////    @FXML
////    private TableView<Espaco> tableLocacao;
////
////    @FXML
////    private TableColumn<Espaco, Integer> id;
////
////    @FXML
////    private TableColumn<Espaco, String> Morador;
////
////    @FXML
////    private TableColumn<Espaco, Date> DataInicial;
////
////    @FXML
////    private TableColumn<Espaco, Date> DataFinal;
////
////    @FXML
////    private TableColumn<Espaco, String> Hora;
////
////    @FXML
////    private TableColumn<Espaco, String> Espaco;
////
////    @FXML
////    private TableColumn<Espaco, Float> Valor;
////
////    @FXML
////    private Button btnSalvar;
////
////    @FXML
////    private Button btnCancelar;
////
////    @FXML
////    private Button btnEditar;
////
////    @FXML
////    private Button btnExcluir;
////
////    @FXML
////    private ChoiceBox<String> cbMorador;
////
////    @FXML
////    private DatePicker dateFim;
////
////    @FXML
////    private Label lblDataFim;
////
////    @FXML
////    private DatePicker dateIni;
////
////    @FXML
////    private TextField txfEspaco;
////
////    @FXML
////    private Label lblEspaco;
//
////    @FXML
////    void EditarLocacao(MouseEvent event) {
////
////    }
////
////    @FXML
////    void ExcluirLocacao(MouseEvent event) {
////
////    }
////
////    @FXML
////    void salvarLocacao(MouseEvent event) {
////    	salvar();
//////		limpaTela();
//////		atualizaTabela();
////    }
////
////    @FXML
////    void switchMain(MouseEvent event) {
////
////    }
////    
////    private void atualizaTabela() {
////		ObservableList<Locacao> list = FXCollections.observableArrayList(controlaLocaco.listar());
////		tableLocacao.setItems(list);
////	}
////    
////    public void initialize(URL location, ResourceBundle resources) {	
////		id.setCellValueFactory(new PropertyValueFactory<>("id"));
////		Morador.setCellFactory(new PropertyValueFactory<>("MoradorToString"));
////		emailTableUsuario.setCellValueFactory(new PropertyValueFactory<>("email"));
////		senhaTableUsuario.setCellValueFactory(new PropertyValueFactory<>("senha"));
////		nivelTableUsuario.setCellValueFactory(new PropertyValueFactory<>("nivel"));
////		atualizaTabela();
////	}
////
////	private void limpaTela() {
////		this.txfEmail.setText("");
////		this.txfSenha.setText("");
////		this.txfNivel.setText("");
////		this.txfId.setText("");
////	}
////
////	private void salvar() {
////		String email = this.txfEmail.getText();
////		String senha = this.txfSenha.getText();
////		String nivel = this.txfNivel.getText();
////		String id = this.txfId.getText();
////		
////		Locacao Locacao = new Locacao(email, senha, nivel);
////		
////		if(!id.equals("")) {
////			
////			Locacao.setId(Integer.parseInt(id));
////			controlaLocacao.atualizar(Locacao);
////		}else {
////					
////			controlaLocacao.criar(Locacao);
////		}
////	}
////
////	private void deletar(Locacao user) {
////		controlaLocacao.deletar(user);
////	}
//
//}
