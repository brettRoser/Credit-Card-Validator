package application;

import java.util.function.UnaryOperator;

import applications.validation.CreditCardTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextFormatter;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class ValidationController {
	
    @FXML private Text validationStatus;
    @FXML private Text cardNumberText;
    @FXML private Text cardTypeText;
    @FXML private CreditCardTextField cardNumberField;
    @FXML private Button validateButton;

    @FXML
    public void initialize() {
        // disables Validate button until some text is entered
        validateButton.disableProperty().bind(
			cardNumberField.textProperty().isEmpty()
        );

        // restricts text field to only digits
        UnaryOperator<TextFormatter.Change> digitFilter = change -> {
            String text = change.getText();
            if(text.matches("[0-9]*")) {
                return change;
            }
            return null;
        };
        TextFormatter<String> creditCardFieldFormatter = new TextFormatter<>(digitFilter);
        cardNumberField.setTextFormatter(creditCardFieldFormatter);
    }

    @FXML protected void handleValidateAction(ActionEvent event) {
        int[] cardNumber = retrieveCardNumber(cardNumberField.getText());
        LuhnsAlg alg = new LuhnsAlg();

        cardNumberText.setText(cardNumberField.getText());
        if(alg.isCardNumberValid(cardNumber))
            setValidCardActions(cardNumber);
        else
            setInvalidCardActions();
    }

    private int[] retrieveCardNumber(String cardNumber) {
        int[] cardNumberValue = new int[cardNumber.length()];
        for(int i = 0; i < cardNumber.length(); i++) {
            if(Character.isDigit(cardNumber.charAt(i))) {
                cardNumberValue[i] = Integer.parseInt(String.valueOf(cardNumber.charAt(i)));
            }
        }

        return cardNumberValue;
    }

    private void setValidCardActions(int[] cardNumber) {
        validationStatus.setFill(Color.DARKGREEN);
        validationStatus.setText("All good!");
        CardTypeIdentifier identifier = new CardTypeIdentifier();
        cardTypeText.setText(identifier.determineCardType(cardNumber));
    }

    private void setInvalidCardActions() {
        validationStatus.setFill(Color.FIREBRICK);
        validationStatus.setText("Invalid");
    }
}
