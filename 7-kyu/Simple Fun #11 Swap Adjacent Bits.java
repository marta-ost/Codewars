/*
DESCRIPTION:

Task

You are given a 32-bit integer n. Swap each pair of adjacent bits in its binary representation and return the result as a decimal number.

The potential leading zeroes of the binary representations have to be taken into account, e.g. 0b100 as a 32-bit integer is 0b00000000000000000000000000000100 and is reversed to 0b1000.

Examples

For n = 13, the output should be 14:

13 10 = 1101 2 --> 1110 2 = 14 10

For n = 74, the output should be 133:

74 10 = 01001010 2 --> 10000101 2 = 133 10

Input/Output

[input] integer n
 0 ≤ n < 2^30.

[output] an integer
*/

public class Kata {
  public static int swapAdjacentBits(int n) {
    String binary = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
    
    StringBuilder swappedBinary = new StringBuilder();
    for (int i = 1; i < binary.length(); i += 2)
      swappedBinary.append(binary.charAt(i)).append(binary.charAt(i - 1));
    
    return Integer.parseInt(swappedBinary.toString(), 2);
  }
}