package telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DialogCadastroControle {
	
		@FXML
	    private Button btnSair;
		private Stage stageDialog;
		private boolean salvarClicked = true;
		
		@FXML
		void initialize(){
		}

		@FXML
	    void onSair(ActionEvent event) {
	    	stageDialog.close();
	    	
			stageDialog.close();

	    }
		
		
		public boolean isSalvarClicked(){
			return salvarClicked;
		}
		
		public void setStageDialog(Stage stage){
			this.stageDialog = stage;
		}

}
