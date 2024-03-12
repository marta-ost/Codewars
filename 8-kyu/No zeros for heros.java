/*
DESCRIPTION:
Numbers ending with zeros are boring.

They might be fun in your world, but not here.

Get rid of them. Only the ending ones.

1450 -> 145
960000 -> 96
1050 -> 105
-1050 -> -105

Zero alone is fine, don't worry about it. Poor guy anyway
*/

public class NoBoring {
  public static int noBoringZeros(int n) {
    String number = String.valueOf(n);
    if (number.endsWith("0") && n != 0) {
      n = Integer.parseInt(number.substring(0, number.length() - 1));
      return noBoringZeros(n);
    }
    return n;
  }
}