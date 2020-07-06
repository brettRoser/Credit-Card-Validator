package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ValidationController {
	
	@FXML private Text validationStatus;
	
    @FXML protected void handleValidateAction(ActionEvent event) {
    	validationStatus.setText("All good!");
    }
}
