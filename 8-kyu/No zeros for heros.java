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
    return n % 10 == 0 && n != 0 ? noBoringZeros(n / 10) : n;
  }
}