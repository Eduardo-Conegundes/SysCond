package br.upe.syscond;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.upe.syscond.controllers.InterfaceUsuarioController;
import br.upe.syscond.controllers.UsuarioController;
import br.upe.syscond.models.Usuario;
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


public class UsuarioViewController implements Initializable{

	static InterfaceUsuarioController controlaUsuario = new UsuarioController();
	private ObservableList<Usuario> select; 

	@FXML
	private Label lblId;

	@FXML
	private Label lblsenha;

	@FXML
	private TextField txfSenha;

	@FXML
	private Label lblNivel;

	@FXML
	private Label txfId;

	@FXML
	private TextField txfNivel;

	@FXML
	private Label lblEmail;

	@FXML
	private TextField txfEmail;

	@FXML
	private TableView<Usuario> tableUsuario;

	@FXML
	private TableColumn<Usuario, Integer> idTableUsuario;

	@FXML
	private TableColumn<Usuario, String> emailTableUsuario;

	@FXML
	private TableColumn<Usuario, String> senhaTableUsuario;

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
	 * @param--> recebe como paramentro event do tipo MouseEvent, para que seja efetuado a seleção do Usuario que deseja-se editar ao ser cliclar..
	 */
	@FXML
	void EditarUsuario(MouseEvent event) {
		this.select = tableUsuario.getSelectionModel().getSelectedItems();
		this.txfEmail.setText(select.get(0).getEmail());
		this.txfSenha.setText(select.get(0).getSenha());
//		this.txfId.setText(Integer.toString(select.get(0).getId()));
		atualizaTabela();
	}
	
	/**
	 * 
	 * @param--> recebe como paramentro event do tipo MouseEvent, para que seja efetuado a seleção do Usuario que deseja-se excluir ao ser cliclar..
	 */
	@FXML
	void ExcluirUsuario(MouseEvent event) {
		this.select = tableUsuario.getSelectionModel().getSelectedItems();
		try {
			if(Alerts.alertaDeletar()) {
				controlaUsuario.deletar(this.select.get(0));				
			}
		} catch (Exception e) {
			Alerts.alertaErro("Erro ao deletar");
			e.printStackTrace();
		}
		limpaTela();
		atualizaTabela();
	}
    
    /**
     * 
     * @param--> recebe como paramentro event do tipo MouseEvent, para que seja efetuado a etapas de salvar, limpar e atualizar a tela da interface ao clicar no botao salvar.
     */
	@FXML
	void salvarUsuario(MouseEvent event) {
		if(this.select == null) {
			salvar(0);
		}else {
			salvar(this.select.get(0).getId());		
			atualizaTabela();
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
			Alerts.alertaErro("Erro ao voltar pagina principal");
			e.printStackTrace();
		}

	}
	
	/**
	 * inicializar o controlador UsuarioViewController  depois que seu elemento raiz foi completamente processado.
	 */
	public void initialize(URL location, ResourceBundle resources) {	
		idTableUsuario.setCellValueFactory(new PropertyValueFactory<>("id"));
		emailTableUsuario.setCellValueFactory(new PropertyValueFactory<>("email"));
		senhaTableUsuario.setCellValueFactory(new PropertyValueFactory<>("senha"));
		atualizaTabela();
		this.select = null;
	}
	
	/**
	 * Metodo que atualiza o a tabela de Usuario na interface.
	 */
	private void atualizaTabela() {
		try {
			tableUsuario.setItems(FXCollections.observableArrayList(controlaUsuario.listar()));			
		} catch (Exception e) {
			Alerts.alertaErro("Erro ao listar tabela");
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que limpa os campos apos serem salvados ou atualizados.
	 */
	private void limpaTela() {
		this.txfEmail.setText(null);
		this.txfSenha.setText(null);
	//	this.txfId.setText("");
	}
	
	/**
	 * Metodo que recebe os valores digitados na interface para salvar ou atualizar um Morador.
	 */
	private void salvar(int id) {
		String email = this.txfEmail.getText();
		String senha = this.txfSenha.getText();
	//	String id = this.txfId.getText();

		Usuario usuario = new Usuario(email, senha);

		if(!(id == 0)){
			usuario.setId(id);
			try {
				controlaUsuario.atualizar(usuario);
				Alerts.alertaSucesso("Atualizado com sucesso!");
			} catch (Exception e) {
				Alerts.alertaErro("Erro ao atualizar");
				e.printStackTrace();
			}
		}else {
			try {
				controlaUsuario.criar(usuario);
				Alerts.alertaSucesso("Salvo com sucesso!");
			} catch (Exception e) {
				Alerts.alertaErro("Erro ao salvar");
			}
		}	
		atualizaTabela();
		limpaTela();
	}	

}
