/*
DESCRIPTION:
You are given an odd-length array of integers, in which all of them are the same, except for one single number.

Complete the method which accepts such an array, and returns that single different number.

The input array will always be valid! (odd-length >= 3)

Examples
[1, 1, 2] ==> 2
[17, 17, 3, 17, 17, 17, 17] ==> 3
*/

import java.util.stream.*;
import java.util.Map;
import java.util.Arrays;
import java.util.function.Function;
import java.util.Collections;

class Solution {
  static int stray(int[] numbers) {
    Map<Integer, Long> numberWithCount = Arrays.stream(numbers)
      .boxed()
      .collect(Collectors.groupingBy(Function.identity(), 
                                     Collectors.counting()));
    return Collections
      .min(numberWithCount.entrySet(), Map.Entry.comparingByValue())
      .getKey();
  }
}