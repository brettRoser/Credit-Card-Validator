package applications.validation;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class CreditCardTextField extends TextField {

    private final int textFieldMaxLength = 19;
	
    public CreditCardTextField() {
    	// restricts text field to max length of 19 characters (currently no credit card numbers over 19 digits) 
    	textProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> ov, String oldVal, String newVal) {
    			if(getText().length() > textFieldMaxLength) {
    				String text = getText().substring(0, textFieldMaxLength);
    				setText(text);
    			}
    		}
    	});
    }
}