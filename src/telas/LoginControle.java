package telas;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import bancoDeDados.ConexaoUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginControle {
	@FXML
    private TextField tfUsrname;

    @FXML
    private TextField tfPassword;

    @FXML
    private Button btnLogin;
    
   
    private long id;
 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	@FXML
	void onLogar(ActionEvent event) {
    try {
    	Connection connection = (Connection) ConexaoUtil.getCon();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select username, senha, idJogador from jogador");
		rs.first();
		if (tfUsrname.getText().equals("") || (tfPassword.getText().equals(""))) {
			JOptionPane.showMessageDialog(null, "Campos não podem ser nulos.");
		}
		if (tfUsrname.getText().equals(rs.getString("username"))
				&& (tfPassword.getText().equals(rs.getString("senha")))) {
			
			setId(rs.getInt("idJogador"));
			Node node = (Node) event.getSource();
			Stage stage = (Stage) node.getScene().getWindow();
			Parent root = null;
			try {
				root = FXMLLoader.load(getClass().getResource("intrucaoTela.fxml"));

			} catch (IOException ex) {
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} else {
			JOptionPane.showMessageDialog(null, "Usário ou senha incorretos!");
			tfPassword.setText("");
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
    

}
	
	
}

