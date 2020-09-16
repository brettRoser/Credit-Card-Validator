package applications;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import application.CardNumberRetriever;
import application.LuhnsAlg;

public class LuhnsAlgTest {
	
	private LuhnsAlg alg;
	
	public LuhnsAlgTest() {
		alg = new LuhnsAlg();
	}

	// Visa cards are 16 or 19 digits and start with 4
	@ParameterizedTest
	@ValueSource(strings={"4532199987124129", "4916698389459145162"})
	public void ShouldReturnTrueForValidVisaCardNumbers(String cardNumberStr) {
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber(cardNumberStr);
		assertTrue(alg.isCardNumberValid(cardNumber));
	}

	// Mastercard numbers are 16 digits and start with 51-55 or range of 222100-272099
	@ParameterizedTest
	@ValueSource(strings={"5302266251167913"})
	public void ShouldReturnTrueForMastercardCardNumbers(String cardNumberStr) {
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber(cardNumberStr);
		assertTrue(alg.isCardNumberValid(cardNumber));
	}
	
	// American Express card numbers are 15 digits and start with 34 or 37
	@ParameterizedTest
	@ValueSource(strings={"341674490894391"})
	public void ShouldReturnTrueForAmericanExpressCardNumbers(String cardNumberStr) {
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber(cardNumberStr);		
		assertTrue(alg.isCardNumberValid(cardNumber));
	}

	// Discover card numbers are 16 or 19 digits and start with 6011
	@ParameterizedTest
	@ValueSource(strings={"6011191061519329", "6011788841539633814"})
	public void ShouldReturnTrueForDiscoverCardNumbers(String cardNumberStr) {
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber(cardNumberStr);		
		assertTrue(alg.isCardNumberValid(cardNumber));
	}

	// A valid but Unknown card type (Diner's club)
	@Test
	public void ShouldReturnFalseForInvalidCard() {
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber("341674490894390");
		assertFalse(alg.isCardNumberValid(cardNumber));
	}
}
