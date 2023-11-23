/*
DESCRIPTION:

Task
Write a method remainder which takes two integer arguments, dividend and divisor, and returns the remainder when dividend is divided by divisor. Do NOT use the modulus operator (%) to calculate the remainder!

Assumption
Dividend will always be greater than or equal to divisor.

Notes
Make sure that the implemented remainder function works exactly the same as the Modulus operator (%).

SimpleInteger is a tiny and immutable implementation of an integer number. Its interface is a very small subset of the java.math.BigInteger API:

#add(SimpleInteger val)
#subtract(SimpleInteger val)
#multiply(SimpleInteger val)
#divide(SimpleInteger val)
#compareTo(SimpleInteger val)
*/

class RemainderFinder {
  public static SimpleInteger remainder(SimpleInteger dividend, SimpleInteger divisor) {
    SimpleInteger quotient = dividend.divide(divisor);
    SimpleInteger product = quotient.multiply(divisor);
    return dividend.subtract(product);
  }
}