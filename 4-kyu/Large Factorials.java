/*
DESCRIPTION:
In mathematics, the factorial of integer n is written as n!. It is equal to the product of n and every integer preceding it. For example: 5! = 1 x 2 x 3 x 4 x 5 = 120

Your mission is simple: write a function that takes an integer n and returns the value of n!.

You are guaranteed an integer argument. For any values outside the non-negative range, return null, nil or None (return an empty string "" in C and C++). For non-negative numbers a full length number is expected for example, return 25! =  "15511210043330985984000000"  as a string.

For more on factorials, see http://en.wikipedia.org/wiki/Factorial

NOTES:

The use of BigInteger or BigNumber functions has been disabled, this requires a complex solution

I have removed the use of require in the javascript language.
*/

import java.math.BigDecimal;

public class Kata {
  public static String Factorial(int n) {
    if (n == 0 || n == 1)
      return "1";
    
    BigDecimal factorial = calculateFactorial(new BigDecimal(n));
    
    return String.valueOf(factorial);
  }
  
  private static BigDecimal calculateFactorial(BigDecimal num) {
    if (num.compareTo(new BigDecimal(2)) == 0)
      return num;
    
    return num.multiply(calculateFactorial(num.subtract(BigDecimal.ONE)));
  } 
}