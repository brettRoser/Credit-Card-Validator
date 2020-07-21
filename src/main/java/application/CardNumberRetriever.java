package application;

public class CardNumberRetriever {

	public static int[] retrieveCardNumber(String cardNumber) {
        int[] cardNumberValue = new int[cardNumber.length()];
        for(int i = 0; i < cardNumber.length(); i++) {
            if(Character.isDigit(cardNumber.charAt(i))) {
                cardNumberValue[i] = Integer.parseInt(String.valueOf(cardNumber.charAt(i)));
            }
        }

        return cardNumberValue;
    }
}
