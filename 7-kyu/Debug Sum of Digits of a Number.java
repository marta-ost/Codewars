/*
DESCRIPTION:
Debug   function getSumOfDigits that takes positive integer to calculate sum of its digits. Assume that argument is an integer.

Example
123  => 6
223  => 7
1337 => 14
*/

public class Solution {
  public static int sumOfDigits(int n) {
    int sum = 0;
    String[] digits = String.valueOf(n).split("");
    
    for (int i = 0; i < digits.length; i++)
      sum += Integer.parseInt(digits[i]);
    
    return sum;
  }
}