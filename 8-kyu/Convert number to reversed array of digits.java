/*
DESCRIPTION:
Convert number to reversed array of digits
Given a random non-negative number, you have to return the digits of this number within an array in reverse order.

Example(Input => Output):
35231 => [1,3,2,5,3]
0 => [0]
*/

public class Kata {
  public static int[] digitize(long n) {
    String[] digits = String.valueOf(n).split("");
    int[] reversed = new int[digits.length];
    
    for (int i = 0; i < digits.length; i++) {
      reversed[i] = Integer.parseInt(digits[digits.length - i - 1]);
    }
    return reversed;
  }
}