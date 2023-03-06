/*
DESCRIPTION:
Given an integer n and two other values, build an array of size n filled with these two values alternating.

Examples
5, true, false     -->  [true, false, true, false, true]
10, "blue", "red"  -->  ["blue", "red", "blue", "red", "blue", "red", "blue", "red", "blue", "red"]
0, "one", "two"    -->  []
Good luck!
*/

public class Kata {
  public static String[] alternate(int n, String firstValue, String secondValue) {
    String[] array = new String[n];
    for (int i = 0; i < n; i += 2) {
      array[i] = firstValue;
      if (i + 1 < n)
        array[i + 1] = secondValue;
    }
    return array;
  }
}