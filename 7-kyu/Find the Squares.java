/*
DESCRIPTION:

Problem
Complete the function that takes an odd integer (0 < n < 1000000) which is the difference between two consecutive perfect squares, and return these squares as a string in the format "bigger-smaller"

Examples
9  -->  "25-16"
5  -->  "9-4"
7  -->  "16-9"
*/

public class Solution {
  public static String findSquares(int n) {
    for (int i = 1; i < 1000000; i++) {
      long bigger = (long) Math.pow(i, 2);
      long smaller = (long) Math.pow(i - 1, 2);
      if (bigger - smaller == n)
        return bigger + "-" + smaller;
    }
    return "";
  }
}