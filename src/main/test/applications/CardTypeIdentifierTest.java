package applications;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import application.CardNumberRetriever;
import application.CardTypeIdentifier;

public class CardTypeIdentifierTest {
	
	private final String VISA = "Visa";
	private final String MASTERCARD = "Mastercard";
	private final String AMERICANEXPRESS = "American Express";
	private final String DISCOVER = "Discover";
	private final String UNKNOWN = "Unknown";
	
	@Test
	public void checkVisa16DigitType() {
		CardTypeIdentifier cardIdentifier = new CardTypeIdentifier();
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber("4532199987124129");
		String cardType = cardIdentifier.determineCardType(cardNumber);
		
		assertEquals(16, cardNumber.length);
		assertEquals(VISA, cardType);
	}
	
	@Test
	public void checkVisa19DigitType() {
		CardTypeIdentifier cardIdentifier = new CardTypeIdentifier();
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber("4916698389459145162");
		String cardType = cardIdentifier.determineCardType(cardNumber);
		
		assertEquals(19, cardNumber.length);
		assertEquals(VISA, cardType);
	}
	
	@Test
	public void CheckMasterCardTypeStartingWith_51() {
		CardTypeIdentifier cardIdentifier = new CardTypeIdentifier();
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber("5182602737408973");
		String cardType = cardIdentifier.determineCardType(cardNumber);
		
		assertEquals(16, cardNumber.length);
		assertEquals(MASTERCARD, cardType);
	}
	
	@Test
	public void CheckMasterCardTypeStartingWith_52() {
		CardTypeIdentifier cardIdentifier = new CardTypeIdentifier();
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber("5216516395264363");
		String cardType = cardIdentifier.determineCardType(cardNumber);
		
		assertEquals(16, cardNumber.length);
		assertEquals(MASTERCARD, cardType);
	}
	
	@Test
	public void CheckMasterCardTypeStartingWith_53() {
		CardTypeIdentifier cardIdentifier = new CardTypeIdentifier();
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber("5302266251167913");
		String cardType = cardIdentifier.determineCardType(cardNumber);
		
		assertEquals(16, cardNumber.length);
		assertEquals(MASTERCARD, cardType);
	}
	
	@Test
	public void CheckMasterCardTypeStartingWith_54() {
		CardTypeIdentifier cardIdentifier = new CardTypeIdentifier();
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber("5499642465482541");
		String cardType = cardIdentifier.determineCardType(cardNumber);
		
		assertEquals(16, cardNumber.length);
		assertEquals(MASTERCARD, cardType);
	}
	
	@Test
	public void CheckMasterCardTypeStartingWith_55() {
		CardTypeIdentifier cardIdentifier = new CardTypeIdentifier();
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber("5560450335513899");
		String cardType = cardIdentifier.determineCardType(cardNumber);
		
		assertEquals(16, cardNumber.length);
		assertEquals(MASTERCARD, cardType);
	}
	
	//In range of 222100-272099
	@Test
	public void CheckMasterCardTypeStartingWith_2() {
		CardTypeIdentifier cardIdentifier = new CardTypeIdentifier();
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber("2720996029419342");
		String cardType = cardIdentifier.determineCardType(cardNumber);
		
		assertEquals(16, cardNumber.length);
		assertEquals(MASTERCARD, cardType);
	}
	
	@Test
	public void CheckAmericanExpressTypeStartingWith_34() {
		CardTypeIdentifier cardIdentifier = new CardTypeIdentifier();
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber("349727387955717");
		String cardType = cardIdentifier.determineCardType(cardNumber);
		
		assertEquals(15, cardNumber.length);
		assertEquals(AMERICANEXPRESS, cardType);
	}
	
	@Test
	public void CheckAmericanExpressTypeStartingWith_37() {
		CardTypeIdentifier cardIdentifier = new CardTypeIdentifier();
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber("377742306624117");
		String cardType = cardIdentifier.determineCardType(cardNumber);
		
		assertEquals(15, cardNumber.length);
		assertEquals(AMERICANEXPRESS, cardType);
	}
	
	@Test 
	public void CheckDiscoverCard16DigitTypeStartingWith_6011() {
		CardTypeIdentifier cardIdentifier = new CardTypeIdentifier();
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber("6011831311393252");
		String cardType = cardIdentifier.determineCardType(cardNumber);
		
		assertEquals(16, cardNumber.length);
		assertEquals(DISCOVER, cardType);
	}
	
	@Test 
	public void CheckDiscoverCard19DigitTypeStartingWith_6011() {
		CardTypeIdentifier cardIdentifier = new CardTypeIdentifier();
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber("6011226614184975206");
		String cardType = cardIdentifier.determineCardType(cardNumber);
		
		assertEquals(19, cardNumber.length);
		assertEquals(DISCOVER, cardType);
	}
	
	// A valid but Unknown card type (Diner's club)
	@Test
	public void CheckUnknownCardType() {
		CardTypeIdentifier cardIdentifier = new CardTypeIdentifier();
		int[] cardNumber = CardNumberRetriever.retrieveCardNumber("30445426781853");
		String cardType = cardIdentifier.determineCardType(cardNumber);
		
		assertEquals(UNKNOWN, cardType);
	}
	
}
