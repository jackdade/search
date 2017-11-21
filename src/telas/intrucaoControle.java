package telas;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class intrucaoControle {


    @FXML
    private Button btnJogar;

    @FXML
    void onJogar(ActionEvent event) {
    	Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("perguntasTela.fxml"));
			

		} catch (IOException ex) {
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

    }
}
