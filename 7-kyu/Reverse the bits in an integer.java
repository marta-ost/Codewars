/*
DESCRIPTION:
Write a function that reverses the bits in an integer.

For example, the number 417 is 110100001 in binary. Reversing the binary is 100001011 which is 267.

You can assume that the number is not negative.
*/

public class BitsOfInteger {
  public static int reverseBits(int n) {
    String binary = Integer.toBinaryString(n);
    String reversedBinary = new StringBuilder(binary).reverse().toString();
    return Integer.parseInt(reversedBinary, 2);
  }
}