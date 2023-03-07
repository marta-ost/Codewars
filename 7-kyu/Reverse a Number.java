/*
DESCRIPTION:
Given a number, write a function to output its reverse digits. (e.g. given 123 the answer is 321)

Numbers should preserve their sign; i.e. a negative number should still be negative when reversed.

Examples
 123 ->  321
-456 -> -654
1000 ->    1
*/

public class ReverseNumber {
	public static int reverse(int number) {
    StringBuilder reversed = new StringBuilder();
    
    String numberStr = String.valueOf(number);
    
    for (int i = numberStr.length() - 1; i >= 0; i--) {
      if (numberStr.charAt(i) != '-')
        reversed.append(numberStr.charAt(i));
    }
    
    int reversedDigits = Integer.parseInt(reversed.toString());
    
    return number < 0 ? reversedDigits * -1 : reversedDigits;
	}
}