package telas;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import bancoDeDados.ConexaoUtil;
import bancoDeDados.DaoFactory;
import bancoDeDados.perguntaDAO;
import classes.Pergunta;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class PerguntasControle {
	

    @FXML
    private RadioButton rdbA;

    @FXML
    private ToggleGroup respostas;

    @FXML
    private RadioButton rdbB;

    @FXML
    private RadioButton rdbC;

    @FXML
    private RadioButton rdbD;

    @FXML
    private RadioButton rdbE;
    

   

    @FXML
    private TableColumn<?, ?> tbvRespostas;

    @FXML
    private Button btnFinalizar;

    @FXML
    private TextArea txPegunta;
    
    @FXML
    private Button btnProxima;

    @FXML
    void onFinalizar(ActionEvent event) {

    }

    @FXML
    void onProxima(ActionEvent event) {
    	soma = soma +1;
    	try {
        	Connection connection = (Connection) ConexaoUtil.getCon();
    		Statement stmt = connection.createStatement();
    		ResultSet rs = stmt.executeQuery("select*from sopergunta where idPergunta ="+ soma);
    		rs.first();
    	
    		txPegunta.setText(rs.getString("pergunta"));

    	} catch (SQLException e) {
    		e.printStackTrace();
    	}

    }
    
  private int soma = 1;
    
    @FXML
    public void initialize() {
    	try {
        	Connection connection = (Connection) ConexaoUtil.getCon();
    		Statement stmt = connection.createStatement();
    		ResultSet rs = stmt.executeQuery("select*from sopergunta where idPergunta ="+ soma);
    		rs.first();
    	
    		txPegunta.setText(rs.getString("pergunta"));

    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	

    	}
}