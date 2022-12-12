/*
DESCRIPTION:
Build a function that returns an array of integers from n to 1 where n>0.

Example : n=5 --> [5,4,3,2,1]
*/

import static java.util.stream.IntStream.rangeClosed;

public class Sequence {
  public static int[] reverse(int n) {
    return rangeClosed(1, n)
      .map(i -> n - i + 1)
      .toArray();
  }
}