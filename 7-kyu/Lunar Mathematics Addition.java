/*
DESCRIPTION:
Lunar Mathematics, otherwise known as 'Dismal Mathematics' (a play on 'decimal mathematics'), was created as an alternate way to view mathematics interacts with numbers. Here, we will create the addition function.

On the moon, there is no need to carry over numbers into the next column. Instead, we take the largest value of each column, and set that as our total.

Examples:

    8
  + 7
  ----
    8 <- Since 8 is the larger number of the two, it is the one used.
    

  234
+ 180
-----
  284 <- the larger values of each number are used for each potion.
  
  50
 +59
------
  59 <- If a number in two columns match, either one of the numbers can be used.
  
  465
 + 72
-----
  475 <- You must handle situations where numbers are not of equal length

Assume all numbers given are valid, nonnegative integers (as there are no negative numbers on the moon).
*/

import java.util.stream.*;
import java.util.*;

public class LunarCalculator {
  public static long add(long number1, long number2) {
    String[] paddedNumbers = leftPadWithZerosToEqualLength(number1, number2);
    
    int[] digits1 = getDigits(paddedNumbers[0]);
    int[] digits2 = getDigits(paddedNumbers[1]);
    
    String biggerDigits = IntStream
      .range(0, digits1.length)
      .mapToObj(i -> String.valueOf(Math.max(digits1[i], digits2[i])))
      .collect(Collectors.joining(""));
    
    return Long.parseLong(biggerDigits);
  }
  
  private static int[] getDigits(String numberString) {
    return Arrays
      .stream(numberString.split(""))
      .mapToInt(i -> Integer.parseInt(i))
      .toArray();
  }
  
  private static String[] leftPadWithZerosToEqualLength(long number1, long number2) {
    String number1String = String.valueOf(number1);
    String number2String = String.valueOf(number2);
    
    int number1Length = number1String.length();
    int number2Length = number2String.length();
    
    if (number1Length > number2Length)
      number2String = "0".repeat(number1Length - number2Length) + number2String;
    else if (number1Length < number2Length)
      number1String = "0".repeat(number2Length - number1Length) + number1String;
    
    return new String[]{number1String, number2String};
  }
}