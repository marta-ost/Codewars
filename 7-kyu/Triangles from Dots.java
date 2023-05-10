/*
DESCRIPTION:
In this simple kata you need to find how many dots are needed to construct nth triangle in the sequence of dot triangles. See next image to get the idea of the sequence:

sequence

You need to write a function that will return a number dots needed to construct nth triangle.
*/

package codewars.triangle;

import java.math.BigInteger;

public class TriangularNumbers {
  public static BigInteger numberOfDots(BigInteger n) {
    final BigInteger TWO = new BigInteger("2");
    
    return n.add(BigInteger.ONE).multiply(n).divide(TWO);
  }
}