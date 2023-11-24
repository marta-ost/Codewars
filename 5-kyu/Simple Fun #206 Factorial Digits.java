/*
DESCRIPTION:
Task
Given an integer n, lying in range [0; 1_000_000], calculate the number of digits in n! (factorial of n).

Example
For n = 0, the output should be 1 because 0! = 1 has 1 digit;
For n = 4, the output should be 2 because 4! = 24 has 2 digits;
For n = 10, the output should be 7 because 10! = 3628800 has 7 digits.
*/

import java.util.stream.*;

class Kata {
  public static int factDigits(int n) {
    if (n <= 1) return 1;
    
    // log a(b) = c; a ^c = b
    // log10(b) = c; 10 ^c = b 
    // ex. log10(100000) = 5; 10 ^5 = 100000, and the result (5) is [digits of 100000] - 1
    
    // floor(log10(n!)) = (digits of n!) - 1 
    // floor, as the result of n! might not be the exact multiplication of 10 (the power might have a decimal point)
    
    // log(a * b) = log(a) + log(b)
    // log(n!) = log(1 * 2 * ... * n) = log(1) + log(2) + ... + log(n)
    
    double power = IntStream
      .rangeClosed(2, n)
      .mapToDouble(i -> (double) Math.log10(i))
      .sum(); 
    
    return (int) Math.floor(power) + 1;  
  }
}