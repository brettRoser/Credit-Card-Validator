package application;

// Luhns Algorithm is a checksum algorithm used to validate a credit card number
// To determine if a credit card number is valid first examine a credit card number:
//                                                      3 7 6 2 4 1 1 5 9 9 0 4 5 2 9
// Algorithm Steps:
// (1) Drop last digit (last digit is the check digit)- 3 7 6 2 4 1 1 5 9 9 0 4 5 2
// (2) Reverse digits -                                 2 5 4 0 9 9 5 1 1 4 2 6 7 3
// (3) Multiply odd digit indexes by 2:                 4 5 8 0 18 9 10 1 2 4 4 6 14 3 0
// (4) Subtract 9 to numbers over 9:                    4 5 8 0 9 9 1 1 2 4 4 6 5 3 0
// (5) Add all numbers:                                 Sum = 61
// (6) The check digit is the amount you need to add to get a multiple of 10:
//                                                      61 + 9 % 10 = 0 - VALID
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
