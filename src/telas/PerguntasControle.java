package telas;


import java.util.Collection;

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
    private TableView<Pergunta> tvPergunta;

    @FXML
    private TableColumn<String, Pergunta> tbvPerguntas;

    @FXML
    private TableColumn<?, ?> tbvRespostas;

    @FXML
    private Button btnFinalizar;

    @FXML
    private Button btnProxima;
    
    private perguntaDAO perguntaDAO = DaoFactory.get().perguntaDAO();

    @FXML
    void onFinalizar(ActionEvent event) {

    }

    @FXML
    void onProxima(ActionEvent event) {

    }
    
    @FXML
    public void  atualizarPerguntas() {
    	Collection<Pergunta> perguntas = perguntaDAO.listar();
		tvPergunta.setItems(FXCollections.observableArrayList(perguntas));
    }
    
    @FXML
    public void initialize() {
    	tbvPerguntas.setCellValueFactory(new PropertyValueFactory<>("pergunta"));
    }

}
