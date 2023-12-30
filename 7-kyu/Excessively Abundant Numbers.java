/*
DESCRIPTION:
An abundant number or excessive number is a number for which the sum of its proper divisors is greater than the number itself.

The integer 12 is the first abundant number. Its proper divisors are 1, 2, 3, 4 and 6 for a total of 16 (> 12).

Derive function abundantNumber(num)/abundant_number(num) which returns true/True/.true. if num is abundant, false/False/.false. if not.
*/

import java.util.stream.*;

public class Kata {
  public static boolean abundantNumber(int num) {
    return IntStream
      .range(1, num)
      .filter(i -> num % i == 0)
      .sum() > num;
  }  
}