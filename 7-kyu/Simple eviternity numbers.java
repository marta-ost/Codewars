/*
DESCRIPTION:

An eviternity number is a number which:
contains only digits 8, 5 and 3, and
the count of the digit 8 >= count of digit 5 >= count of digit 3.

The first few eviternity numbers are as follows.
[8, 58, 85, 88, 358, 385, 538, 583, 588, 835, 853, 858, 885, 888]

You will be given two integers, a and b, and your task is to return the number of eviternity numbers in the range >= a and < b.

For example:
solve(0,1000) = 14, because they are [8, 58, 85, 88, 358, 385, 538, 583, 588, 835, 853, 858, 885, 888]

The upper bound will not exceed 500,000.

More examples in test cases. Good luck!
*/

import java.util.stream.*;

class Solution {
  public static int solve(int a, int b) {
    return (int) IntStream
      .range(a, b)
      .mapToObj(String::valueOf)
      .filter(s -> s.matches("[853]+") 
                && s.replaceAll("[35]", "").length() >= s.replaceAll("[38]", "").length() 
                && s.replaceAll("[38]", "").length() >= s.replaceAll("[58]", "").length())
      .count();
  }
}