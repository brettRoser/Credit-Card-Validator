package application;

public class LuhnsAlg {

	public boolean isCardNumberValid(int[] cardNumber) {
		int lastDigit = cardNumber[cardNumber.length-1];
		int sum = 0, oddDigit = 0, oddDigitIndex = 0;
		
		for(int i = cardNumber.length-1; i > 0; i--) {
			oddDigitIndex++;
			oddDigit = cardNumber[i-1];
			 if(oddDigitIndex % 2 != 0) {
				oddDigit *= 2;
				if(oddDigit > 9)
					oddDigit -= 9;
			}
			sum += oddDigit;
		}

		return (sum + lastDigit) % 10 == 0;
	}

}
