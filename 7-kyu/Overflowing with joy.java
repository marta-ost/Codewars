/*
DESCRIPTION:
Multiply two ints, but take care of overflow. If the result cannot be accurately stored in an int, throw an ArithmeticException.

(If this is too easy, try overflowing with longing.)
*/

public class Multiplier {
  public static int multiply(int a, int b) {
    long multiplied = (long) a * (long) b;
    
    if (multiplied > Integer.MAX_VALUE || multiplied < Integer.MIN_VALUE)
      throw new ArithmeticException();
    else 
      return (int) multiplied;
  }
}