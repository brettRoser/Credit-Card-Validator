package applications;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import application.CardNumberRetriever;
import application.CardTypeIdentifier;

public class CardTypeIdentifierTest {
	
	private final String VISA = "Visa";
	private final String MASTERCARD = "Mastercard";
	private final String AMERICANEXPRESS = "American Express";
	private final String DISCOVER = "Discover";
	private final String UNKNOWN = "Unknown";
	private CardTypeIdentifier cardIdentifier;
	
	public CardTypeIdentifierTest() {
		cardIdentifier = new CardTypeIdentifier();
	}

	// Visa cards are 16 or 19 digits and start with 4
	@ParameterizedTest
	@ValueSource(strings={"4532199987124129", "4916698389459145162"})
	public void ShouldReturnTrueForVisaCardNumbers(String cardNumberStr) {
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber(cardNumberStr);
		String cardType = cardIdentifier.determineCardType(cardNumber);

		assertEquals(VISA, cardType);
	}
	
	// Mastercard numbers are 16 digits and start with 51-55 or range of 222100-272099
	@ParameterizedTest
	@ValueSource(strings={"5182602737408973", "5216516395264363", 
			"5302266251167913", "5499642465482541", "5560450335513899", "2720996029419342"})
	public void ShouldReturnTrueForMastercardCardNumbers(String cardNumberStr) {
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber(cardNumberStr);
		String cardType = cardIdentifier.determineCardType(cardNumber);

		assertEquals(16, cardNumber.length);
		assertEquals(MASTERCARD, cardType);
	}

	// American Express card numbers are 15 digits and start with 34 or 37
	@ParameterizedTest
	@ValueSource(strings={"349727387955717", "377742306624117"})
	public void ShouldReturnTrueForAmericanExpressCardNumbers(String cardNumberStr) {
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber(cardNumberStr);
		String cardType = cardIdentifier.determineCardType(cardNumber);
		
		assertEquals(15, cardNumber.length);
		assertEquals(AMERICANEXPRESS, cardType);
	}
	
	// Discover card numbers are 16 or 19 digits and start with 6011
	@ParameterizedTest
	@ValueSource(strings={"6011831311393252", "6011226614184975206"})
	public void ShouldReturnTrueForDiscoverCardNumbers(String cardNumberStr) {
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber(cardNumberStr);
		String cardType = cardIdentifier.determineCardType(cardNumber);
		
		assertEquals(DISCOVER, cardType);
	}
	
	// A valid but Unknown card type (Diner's club)
	@Test
	public void ShouldReturnUnknownCardType() {
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber("30445426781853");
		String cardType = cardIdentifier.determineCardType(cardNumber);
		
		assertEquals(UNKNOWN, cardType);
	}
}
