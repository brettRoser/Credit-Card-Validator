package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ValidationController {
	
    @FXML private Text validationStatus;
    @FXML private Text cardNumberText;
    @FXML private TextField cardNumberField;
	
    @FXML protected void handleValidateAction(ActionEvent event) {
        // TODO: Need to make sure at least one character was entered
        int[] cardNumber = retrieveCardNumber(cardNumberField.getText());
        LuhnsAlg alg = new LuhnsAlg();

//    	validationStatus.setStyle("-fx-fill: #c4d8de;");
//    	validationStatus.setId("BAD");
        cardNumberText.setText(cardNumberField.getText());
        validationStatus.setText(alg.isCardNumberValid(cardNumber) ? "All good!" : "Invalid!");
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
}
