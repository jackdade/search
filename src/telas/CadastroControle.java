package telas;


import java.util.List;

import bancoDeDados.CidadeDAO;
import bancoDeDados.DaoFactory;
import bancoDeDados.UFDao;
import bancoDeDados.signoDAO;
import classes.Cidade;
import classes.Signo;
import classes.UF;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;


public class CadastroControle   {
	@FXML
    private TextField tfSobrenome;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfCPF;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnSalvar;

    @FXML
    private RadioButton rdMaculino;

    @FXML
    private ToggleGroup grupoSexo;

    @FXML
    private RadioButton rdFeminino;

    @FXML
    private TextField tfUsername;

    @FXML
    private TextField tfLogin;

    @FXML
    private ComboBox<Signo> cbxSigno;
    @FXML
    private ComboBox<UF> cbxUF;

    @FXML
    private ComboBox<Cidade> cbxCidade;

    @FXML
    private DatePicker dtNacimento;

    @FXML
    void onFeminino(ActionEvent event) {

    }

    @FXML
    void onLogin(ActionEvent event) {

    }

    @FXML
    void onMasculino(ActionEvent event) {

    }
    
   
    @FXML
    void onUF(ActionEvent event) {
    	List<Cidade> cidades = CidadeDAO.buscaPorUf(cbxUF.getSelectionModel().getSelectedItem());
    	cbxCidade.setItems(FXCollections.observableArrayList(cidades));
    	
    	
    	
    	

    }

  
    
    // declarando metohodos
   private signoDAO signoDao = DaoFactory.get().signoDao();
   private UFDao UFDao = DaoFactory.get().UFDao();
   private CidadeDAO CidadeDAO = DaoFactory.get().CidadeDAO();
 
    
    // salvando informaçoes
    
    @FXML
	void onSalvar(ActionEvent event) {
   
	}
    
  
    
    @FXML
	public void initialize() {
    	cbxSigno.setItems(FXCollections.observableArrayList(signoDao.listar()));
    	cbxUF.setItems(FXCollections.observableArrayList(UFDao.listar()));
    	
	}
    
  
  
    

}
