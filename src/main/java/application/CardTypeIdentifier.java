package application;

/*
 * This class is used to identify the type of card entered.
 * For this program, will only focus on a few major card types
 * - American Express
 * - Visa
 * - Mastercard
 * - Discover
 */
public class CardTypeIdentifier {

	// The business rules we will use to determine the card type are:
	// American express cards - Number begins with a 3, followed by either a 4(34) or a 7(37) and has 15 digits
	// Visa cards - Number begins with a 4 and has somewhere between 16 to 19 digits
	// Mastercard cards - Begin with a 5 (Starting with 51,52,53,54,55) or a 2 (222100-272099) and has 16 digits
	// Discover cards - Begin with a 6(any of these starting ranges: 
	// 6011, 622126-622925, 644, 645, 646, 647, 648, 649, 65) and has somewhere between 16 to 19 digits
	// Note: Some of these card providers will increase to 19 digits soon... will require an update
	public String determineCardType(int[] cardNumber) {
		
		String cardType = "Unknown";
		int firstDigitOfCard = getCardDigits(1, cardNumber);
		
		switch(firstDigitOfCard)
		{
		case 3: // American express
			if(checkAmericanExpress(cardNumber))
				cardType = "American Express";
			break;
		case 4: // Visa
			if(checkVisa(cardNumber))
				cardType = "Visa";
			break;
		case 2:
		case 5: // Mastercard
			if(checkMastercard(cardNumber))
				cardType = "Mastercard";
			break;
		case 6: // Discover
			if(checkDiscover(cardNumber))
				cardType = "Discover";
			break;
		}
				
		return cardType;
	}
		
	private boolean checkAmericanExpress(int[] cardNumber) {
		int startingDigits = getCardDigits(2, cardNumber);
		return cardNumber.length == 15 && startingDigits == 34 || startingDigits == 37;
	}
	
	private boolean checkVisa(int[] cardNumber) {
		return cardNumber.length >= 16 && cardNumber.length <= 19;
	}

	private boolean checkMastercard(int[] cardNumber) {
		int twoStartingDigits = getCardDigits(2, cardNumber);
		int sixStartingDigits = getCardDigits(6, cardNumber);
		return cardNumber.length == 16 && (twoStartingDigits >= 51 && twoStartingDigits <= 55) ||
			(sixStartingDigits >= 222100 && sixStartingDigits <= 272099);
	}

	private boolean checkDiscover(int[] cardNumber) {
		int threeStartingDigits = getCardDigits(3, cardNumber);
		int sixStartingDigits = getCardDigits(6, cardNumber);
		return cardNumber.length >= 16 && cardNumber.length <= 19 && getCardDigits(2, cardNumber) == 65 || 
			(threeStartingDigits >=644 && threeStartingDigits <= 649) || getCardDigits(4, cardNumber) == 6011 ||
			(sixStartingDigits >= 622126 && sixStartingDigits <= 622925);
	}
	
	// Retrieves X number of card digits
	private int getCardDigits(int digits, int[] cardNumber) {
		String cardDigits = "";
		for(int i = 0; i < digits; i++) {
			cardDigits += Integer.toString(cardNumber[i]);
		}
		
		return Integer.parseInt(cardDigits);
	}
}
