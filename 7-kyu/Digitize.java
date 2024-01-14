/*
DESCRIPTION:

Given a non-negative integer, return an array / a list of the individual digits in order.

Examples:

123 => [1,2,3]

1 => [1]

8675309 => [8,6,7,5,3,0,9]
*/

import java.util.*;

public class Solution {
  public static int[] digitize(int n) {
    return Arrays
      .stream(String.valueOf(n).split(""))
      .mapToInt(Integer::parseInt)
      .toArray();
  }
}