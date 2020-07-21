package applications;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import application.CardNumberRetriever;
import application.LuhnsAlg;

public class LuhnsAlgTest {
	
	@Test
	public void IsVisa16DigitCardValid() {
		LuhnsAlg alg = new LuhnsAlg();
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber("4716083341082553");
		boolean isCardValid = alg.isCardNumberValid(cardNumber);
		
		assertEquals(true, isCardValid);
	}

	@Test
	public void IsVisa19DigitCardValid() {
		LuhnsAlg alg = new LuhnsAlg();
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber("4532774677789719801");
		boolean isCardValid = alg.isCardNumberValid(cardNumber);
		
		assertEquals(true, isCardValid);
	}
	
	@Test
	public void IsDiscover16DigitCardValid() {
		LuhnsAlg alg = new LuhnsAlg();
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber("6011191061519329");
		boolean isCardValid = alg.isCardNumberValid(cardNumber);
		
		assertEquals(true, isCardValid);
	}
	
	@Test
	public void IsDiscover19DigitCardValid() {
		LuhnsAlg alg = new LuhnsAlg();
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber("6011788841539633814");
		boolean isCardValid = alg.isCardNumberValid(cardNumber);
		
		assertEquals(true, isCardValid);
	}
	
	// All Mastercards cards are 16 characters
	@Test
	public void IsMastercardCardValid() {
		LuhnsAlg alg = new LuhnsAlg();
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber("5302266251167913");
		boolean isCardValid = alg.isCardNumberValid(cardNumber);
		
		assertEquals(true, isCardValid);
	}
	
	// All American Express cards are 15 characters
	@Test
	public void IsAmericanExpressCardValid() {
		LuhnsAlg alg = new LuhnsAlg();
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber("341674490894391");
		boolean isCardValid = alg.isCardNumberValid(cardNumber);
		
		assertEquals(true, isCardValid);
	}
	
	@Test
	public void IsCardInvalid() {
		LuhnsAlg alg = new LuhnsAlg();
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber("341674490894390");
		boolean isCardValid = alg.isCardNumberValid(cardNumber);
		
		assertEquals(false, isCardValid);
	}
	
}
