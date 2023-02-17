/*
DESCRIPTION:
In this kata, you will sort elements in an array by decreasing frequency of elements. If two elements have the same frequency, sort them by increasing value.

Solution.sortByFrequency(new int[]{2, 3, 5, 3, 7, 9, 5, 3, 7});
// Returns {3, 3, 3, 5, 5, 7, 7, 2, 9}
// We sort by highest frequency to lowest frequency.
// If two elements have same frequency, we sort by increasing value.
More examples in test cases.

Good luck!

Please also try Simple time difference
*/

import java.util.stream.*;
import java.util.function.Function;
import java.util.*;

public class Solution {
  public static int[] sortByFrequency(int[] array) {
    Map<Integer, Long> numbersWithCount =
      Arrays.stream(array)
      .boxed()
      .collect(Collectors.groupingBy(Function.identity(), 
                                     Collectors.counting()));
    
    return Arrays.stream(array)
      .boxed()
      .sorted(Comparator.<Integer, Long>comparing(numbersWithCount::get).reversed()
             .thenComparing(Comparator.naturalOrder()))
      .mapToInt(Integer::intValue)
      .toArray();
  }
}