/*
DESCRIPTION:
Given an integer n and two other values, build an array of size n filled with these two values alternating.

Examples
5, true, false     -->  [true, false, true, false, true]
10, "blue", "red"  -->  ["blue", "red", "blue", "red", "blue", "red", "blue", "red", "blue", "red"]
0, "one", "two"    -->  []
Good luck!
*/

import java.util.stream.*;

public class Kata {
  public static String[] alternate(int n, String firstValue, String secondValue) {
    return IntStream
      .range(0, n)
      .mapToObj(i -> i % 2 > 0 ? secondValue : firstValue)
      .toArray(String[]::new);
  }
}