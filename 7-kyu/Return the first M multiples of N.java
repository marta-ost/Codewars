/*
DESCRIPTION:
Implement a function, multiples(m, n), which returns an array of the first m multiples of the real number n. Assume that m is a positive integer.

Ex.

multiples(3, 5.0)
should return

[5.0, 10.0, 15.0]
*/

import java.util.stream.*;

public class Kata {
  public static int[] multiples(int multiples, int number) {
    return IntStream.rangeClosed(1, multiples)
      .map(i -> i * number)
      .toArray();
  }
}