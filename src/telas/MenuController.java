package telas;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class MenuController{


	
    @FXML
    private BorderPane bpPrincipal;

    @FXML
    private TextField tfUsrname;

    @FXML
    private TextField tfPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnCadastrar;

    @FXML
    void onCadastrar(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("cadastroTela.fxml"));
		try {
			AnchorPane cadastroView = (AnchorPane) loader.load();
			bpPrincipal.setCenter(cadastroView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

    }
    }


