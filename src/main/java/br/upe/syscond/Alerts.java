package br.upe.syscond;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class Alerts {
	
	static public void alertaErro(String erro) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erro :(");
		alert.setHeaderText(erro);
		alert.setContentText("Infelizmente, algo de errado aconteceu!");
		alert.showAndWait();
	}
	
	static public void alertaSucesso(String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Sucesso !! :)");
		alert.setHeaderText(msg);
		alert.setContentText("Deu tudo certo com a sua operação!");
		alert.showAndWait();
	}
	
	static public boolean alertaDeletar() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmação (?)");
		alert.setHeaderText("Pense bem nessa operação que você está fazendo.");
		alert.setContentText("Você tem certeza disso?");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			return true;
		} else {
			return false;
		}
	}
	
}
