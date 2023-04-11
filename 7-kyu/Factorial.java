/*
DESCRIPTION:
Your task is to write function factorial.

https://en.wikipedia.org/wiki/Factorial
*/

import java.util.stream.*;

public class Factorial {
  public static long factorial(int n) {
    return LongStream
      .rangeClosed(1, n)
      .reduce(1, (subtotal, element) -> subtotal * element);
  }
}