/*
DESCRIPTION:
Complete the function to find the count of the most frequent item of an array. You can assume that input is an array of integers. For an empty array return 0

Example
input array: [3, -1, -1, -1, 2, 3, -1, 3, -1, 2, 4, 9, 3]
ouptut: 5 
The most frequent number in the array is -1 and it occurs 5 times.
*/

import java.util.stream.*;
import java.util.Map;
import java.util.Arrays;
import java.util.function.Function;
import java.util.Collections;

public class Kata {
  public static int mostFrequentItemCount(int[] collection) {
    if (collection.length == 0)
      return 0; 
    Map<Integer, Long> itemWithCount = Arrays.stream(collection)
      .boxed()
      .collect(Collectors.groupingBy(Function.identity(), 
                                     Collectors.counting()));
    return Integer.parseInt(Collections
      .max(itemWithCount.entrySet(), Map.Entry.comparingByValue())
      .getValue()
      .toString());
  }
}