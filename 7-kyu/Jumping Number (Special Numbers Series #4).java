/*
DESCRIPTION:

Definition
Jumping number is the number that All adjacent digits in it differ by 1.

Task
Given a number, Find if it is Jumping or not .

Warm-up (Highly recommended)
Playing With Numbers Series

Notes
Number passed is always Positive .
Return the result as String .
The difference between ‘9’ and ‘0’ is not considered as 1 .
All single digit numbers are considered as Jumping numbers.

Input >> Output Examples

jumpingNumber(9) ==> return "Jumping!!"
Explanation:
It's single-digit number

jumpingNumber(79) ==> return "Not!!"
Explanation:
Adjacent digits don't differ by 1

jumpingNumber(23) ==> return "Jumping!!"
Explanation:
Adjacent digits differ by 1

jumpingNumber(556847) ==> return "Not!!"
Explanation:
Adjacent digits don't differ by 1

jumpingNumber(4343456) ==> return "Jumping!!"
Explanation:
Adjacent digits differ by 1

jumpingNumber(89098) ==> return "Not!!"
Explanation:
Adjacent digits don't differ by 1

jumpingNumber(32) ==> return "Jumping!!"
Explanation:
Adjacent digits differ by 1
*/

import java.util.*;

public class Solution {
  public static String jumpingNumber(int number) {
    return isJumpingNumber(number) ? "Jumping!!" : "Not!!";
  }
  
  private static boolean isJumpingNumber(int number) {
    int[] digits = getDigits(number);
    
    for (int i = 1; i < digits.length; i++) {
      int previous = digits[i - 1];
      int current = digits[i];
      boolean differenceIs1 = Math.abs(previous - current) == 1;
        
      if (!differenceIs1)
        return false;
    }
    return true;
  }
  
  private static int[] getDigits(int number) {
    return Arrays
      .stream(String.valueOf(number).split(""))
      .mapToInt(Integer::parseInt)
      .toArray();
  }
}