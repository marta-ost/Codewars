/*
DESCRIPTION:
Please write a function that sums a list, but ignores any duplicate items in the list.

For instance, for the list [3, 4, 3, 6] , the function should return 10.
*/

import java.util.Arrays;
import java.util.stream.*;
import java.util.function.Function;


public class Solution {
  public static int sumNoDuplicates(int[] arr) {
    return Arrays
      .stream(arr)
      .boxed()
      .collect(Collectors.groupingBy(Function.identity(),
                                    Collectors.counting()))
      .entrySet()
      .stream()
      .filter(entry -> entry.getValue() == 1)
      .map(entry -> entry.getKey())
      .mapToInt(Integer::intValue)
      .sum();
  }
}