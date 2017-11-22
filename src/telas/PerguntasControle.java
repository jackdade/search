package telas;


import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Connection;
import bancoDeDados.ConexaoUtil;
import classes.Respostas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


public class PerguntasControle {
	

   

    

    @FXML
    private TextArea txResposta;

    
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnFinalizar;

    @FXML
    private TextArea txPegunta;
    
    @FXML
    private Button btnProxima;
    @FXML
    private Button btnProximaPergunta;

    @FXML
    private Button btnProximaResposta;

    @FXML
    private Button btnAnteriror;

    @FXML
    private Button btnAnteriorPergunta;

    @FXML
    void onFinalizar(ActionEvent event) {
    	Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("resposta.fxml"));

		} catch (IOException ex) {
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

    }
    
   

    
  private LoginControle loginControle;  
  private int soma = 1;
  private int somaresposta =1;
    
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
    	try {
        	Connection connection = (Connection) ConexaoUtil.getCon();
    		Statement stmt = connection.createStatement();
    		ResultSet rs = stmt.executeQuery("select*from soalternativa where  numero="+ somaresposta);
    		rs.first();
    	
    		txResposta.setText(rs.getString("alternativa"));

    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	}
    
   

    

    

    @FXML
    void onProximaPergunta(ActionEvent event) {
    	try {
    		Connection con = (Connection) ConexaoUtil.getCon();
    		String insert = "insert into respostas values(idRespostas,?,?,?)";
    		PreparedStatement insertStmt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
    		insertStmt.setLong(1, 1);
    		insertStmt.setLong(2, soma);
    		insertStmt.setLong(3, somaresposta);
    		insertStmt.executeUpdate();
    		ResultSet resultSet = insertStmt.getGeneratedKeys();
    		resultSet.next();
    		
    	} catch (SQLException ex) {
    		ex.printStackTrace();
    	}
    	
    	
    	soma = soma +1;
    	somaresposta = 1;
    	try {
        	Connection connection = (Connection) ConexaoUtil.getCon();
    		Statement stmt = connection.createStatement();
    		ResultSet rs = stmt.executeQuery("select*from sopergunta where idPergunta ="+ soma);
    		rs.first();
    	
    		txPegunta.setText(rs.getString("pergunta"));

    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	try {
        	Connection connection = (Connection) ConexaoUtil.getCon();
    		Statement stmt = connection.createStatement();
    		ResultSet rs = stmt.executeQuery("select*from soalternativa where numero ="+ somaresposta);
    		rs.first();
    	
    		txResposta.setText(rs.getString("alternativa"));

    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	
    	
    	

    }

    @FXML
    void onProximaResposta(ActionEvent event) {
    	somaresposta = somaresposta+1;
    	try {
        	Connection connection = (Connection) ConexaoUtil.getCon();
    		Statement stmt = connection.createStatement();
    		ResultSet rs = stmt.executeQuery("select*from soalternativa where numero="+somaresposta);
    		rs.first();
    	
    		txResposta.setText(rs.getString("alternativa"));

    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    
    }
    

    @FXML
    void onAnteriorResposta(ActionEvent event) {
    	somaresposta = somaresposta-1;
    	try {
        	Connection connection = (Connection) ConexaoUtil.getCon();
    		Statement stmt = connection.createStatement();
    		ResultSet rs = stmt.executeQuery("select*from soalternativa where numero="+somaresposta);
    		rs.first();
    	
    		txResposta.setText(rs.getString("alternativa"));

    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    

}