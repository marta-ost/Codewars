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
    // for any consecutive a, b where a > b:
    // a^2 - b^2 = a + b;
    
    long a = (n + 1) / 2;
    long b = a - 1;
    return a * a + "-" + b * b;
  }
}