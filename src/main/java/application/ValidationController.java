package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ValidationController {
	
    @FXML private Text validationStatus;
    @FXML private Text cardNumberText;
    @FXML private TextField cardNumberField;
    @FXML private Button validateButton;

    @FXML
    public void initialize() {
        validateButton.disableProperty().bind(
			cardNumberField.textProperty().isEmpty()
        );
    }
    
    @FXML protected void handleValidateAction(ActionEvent event) {
        int[] cardNumber = retrieveCardNumber(cardNumberField.getText());
        LuhnsAlg alg = new LuhnsAlg();

        cardNumberText.setText(cardNumberField.getText());
        if(alg.isCardNumberValid(cardNumber))
            setValidCardActions();
        else
            setInvalidCardActions();
    }

    private int[] retrieveCardNumber(String cardNumber) {
        cardNumber = cardNumber.replaceAll("\\D", ""); // TODO: Remove when input validation is in place
        int[] cardNumberValue = new int[cardNumber.length()];
        for(int i = 0; i < cardNumber.length(); i++) {
            if(Character.isDigit(cardNumber.charAt(i))) {
                cardNumberValue[i] = Integer.parseInt(String.valueOf(cardNumber.charAt(i)));
            }
        }

        return cardNumberValue;
    }

    private void setValidCardActions() {
        validationStatus.setFill(Color.DARKGREEN);
        validationStatus.setText("All good!");
    }

    private void setInvalidCardActions() {
        validationStatus.setFill(Color.FIREBRICK);
        validationStatus.setText("Invalid");
    }
}
