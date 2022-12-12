/*
DESCRIPTION:
Complete the function which converts a binary number (given as a string) to a decimal number.
*/

public class Converter {
  public static int binToDecimal(String inp) {
    return Integer.parseInt(inp, 2);
  }
}