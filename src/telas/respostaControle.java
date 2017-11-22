package telas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;
import com.mysql.jdbc.Connection;

import bancoDeDados.ConexaoUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class respostaControle {
    @FXML
    private TextArea txProcura;

    @FXML
    private Button btnProcurar;
    
    private int pergunta;
    private int AlternativaMinha;
    private int Contador;
    private int idSelecionado;

    
    

    public int getPergunta() {
		return pergunta;
	}



	public void setPergunta(int pergunta) {
		this.pergunta = pergunta;
	}



	public int getAlternativaMinha() {
		return AlternativaMinha;
	}



	public void setAlternativaMinha(int alternativaMinha) {
		AlternativaMinha = alternativaMinha;
	}



	public int getContador() {
		return Contador;
	}



	public void setContador(int contador) {
		Contador = contador;
	}



	public int getIdSelecionado() {
		return idSelecionado;
	}



	public void setIdSelecionado(int idSelecionado) {
		this.idSelecionado = idSelecionado;
	}

	ArrayList lista = new ArrayList();
	


	@FXML
    void onProcurar(ActionEvent event) {
    	
    	try {
        	Connection connection = (Connection) ConexaoUtil.getCon();
    		Statement stmt = connection.createStatement();
    		ResultSet rs = stmt.executeQuery("select*from respostaMinha where idJogador="+ 1);
    		rs.first();
    		
    		for(int i=0;i> pergunta;i++ ) {
    			
    		}
    		
    	
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	

    }

}
