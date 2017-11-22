package telas;



import java.io.IOException;
import java.net.URL;
import java.util.List;

import bancoDeDados.CidadeDAO;
import bancoDeDados.ConexaoUtil;
import bancoDeDados.DaoFactory;
import bancoDeDados.UFDao;
import bancoDeDados.jogadorDAO;
import bancoDeDados.signoDAO;
import classes.Cidade;
import classes.Jogador;
import classes.Signo;
import classes.UF;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class CadastroControle extends MenuController  {
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
    private TextField tfSenha;

    @FXML
    private ComboBox<Signo> cbxSigno;
    @FXML
    private ComboBox<UF> cbxUF;

    @FXML
    private ComboBox<Cidade> cbxCidade;

    @FXML
    private DatePicker dtNacimento;

    @FXML
    private AnchorPane achCadastro;
    @FXML
    private Button btnGerar;
    
    

    @FXML
	void onReport (ActionEvent event) throws JRException {
		URL url = getClass().getResource("/search/src/Cherry.jrxml");
		JasperPrint print = JasperFillManager.fillReport(url.getPath(), null, ConexaoUtil.getCon());
		JasperViewer.viewReport(print);
	}


    
   // seleciona o estado e aparece a cidade
    @FXML
    void onUF(ActionEvent event) {
    	List<Cidade> cidades = CidadeDAO.buscaPorUf(cbxUF.getSelectionModel().getSelectedItem());
    	cbxCidade.setItems(FXCollections.observableArrayList(cidades));
    
    }

  
    
    // declarando metohodos
   private signoDAO signoDao = DaoFactory.get().signoDao();
   private UFDao UFDao = DaoFactory.get().UFDao();
   private CidadeDAO CidadeDAO = DaoFactory.get().CidadeDAO();
   private jogadorDAO jogadorDao = DaoFactory.get().jogadorDAO();
   private Jogador jogador;
   private boolean editando;

 
  
 
    
    // salvando informaçoes
    
    @FXML
	void onSalvar(ActionEvent event) {
    	jogador.setNomeJogador(tfNome.getText());
    	jogador.setSobrenome(tfSobrenome.getText());
    	jogador.setCPF(tfCPF.getText());
    	jogador.setIdade(dtNacimento.getValue());
    	jogador.setsigno(cbxSigno.getValue());
    	jogador.setCidade(cbxCidade.getValue());
    	jogador.setUsername(tfUsername.getText());
    	jogador.setSenha(tfSenha.getText());
    	   
    	if(rdFeminino.isSelected()) {
    		jogador.setSexo("Feminino");
    		
    	}else {
    		jogador.setSexo("Masculino");
    	}
    	
    	if (editando) {
			jogadorDao.alterar(jogador);
		} else {
			jogadorDao.inserir(jogador);
		}
    	novo();
    	
    	Stage stageDono = (Stage)btnSalvar.getScene().getWindow();
		CadastroDialogFabrica cadastroDialogFabrica = 
				new CadastroDialogFabrica(stageDono);
		boolean salvarClicked = cadastroDialogFabrica.showCadastroDialog();
		if(salvarClicked) {
			
		}
		
	}
    
    private void novo() {
    	editando = false;
		jogador = new Jogador();
		limparCampos();
    }
    private void limparCampos() {
		tfNome.setText("");
		tfCPF.setText("");
		tfSenha.setText("");
		tfUsername.setText("");
		tfSobrenome.setText("");
		dtNacimento.setValue(null);
	}
    
    
    @FXML
	public void initialize() {
    	cbxSigno.setItems(FXCollections.observableArrayList(signoDao.listar()));
    	cbxUF.setItems(FXCollections.observableArrayList(UFDao.listar()));
    	novo();
    	
	}
    
    @FXML
	void onNovo(ActionEvent event) {
		novo();
	}
    
    @FXML
    void onLogin(ActionEvent Event){

    	Node node = (Node) Event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("LoginTela.fxml"));
			
		} catch (IOException ex) {
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    	 
    }
    
 
    
	@FXML
	void onEditar(MouseEvent mouseEvent) {
		if (mouseEvent.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
			tfNome.setText(jogador.getNomeJogador());
			tfCPF.setText(jogador.getCPF());
			tfSobrenome.setText(jogador.getSobrenome());
			tfUsername.setText(jogador.getUsername());
			tfSenha.setText(jogador.getSenha());
			
			dtNacimento.setValue(jogador.getIdade());
			// pega do objeto e coloca no combobox
			cbxCidade.setValue(jogador.getcidade());
			cbxSigno.setValue(jogador.getsigno());
			
			editando = true;
		}
	}
    
  
  
    

}
