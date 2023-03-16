/*
DESCRIPTION:
Given a sequence of numbers, find the largest pair sum in the sequence.

For example

[10, 14, 2, 23, 19] -->  42 (= 23 + 19)
[99, 2, 2, 23, 19]  --> 122 (= 99 + 23)
Input sequence contains minimum two elements and every element is an integer.
*/

import java.util.*;
import java.util.stream.*;

public class Solution {
  public static int largestPairSum(int[] numbers) {
    return Arrays.stream(numbers)
      .boxed()
      .sorted(Collections.reverseOrder())
      .mapToInt(Integer::intValue)
      .limit(2)
      .sum();
  }
}