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
    LinkedHashMap<Integer, Long> numbersWithCount = 
      Arrays.stream(array)
      .boxed()
      .collect(Collectors.groupingBy(Function.identity(), 
                                     Collectors.counting()))
      .entrySet()
      .stream()
      .sorted(Map.Entry.<Integer, Long>comparingByValue(Comparator.reverseOrder())
              .thenComparing(Map.Entry.comparingByKey()))
      .collect(Collectors.toMap(Map.Entry::getKey, 
                                Map.Entry::getValue,
                                (e1, e2) -> e2, 
                                LinkedHashMap::new));
    
    int[] sorted = new int[array.length];
    int index = 0;

    for (int i = 0; i < numbersWithCount.size(); i++) {
      String numberWithCount = String.valueOf(numbersWithCount
                                            .entrySet()
                                            .toArray()[i]);
      int number = Integer.parseInt(numberWithCount.substring(0, numberWithCount.indexOf("=")));
      int count = Integer.parseInt(numberWithCount.substring(numberWithCount.indexOf("=") + 1));
      
      while (count-- > 0)
        sorted[index++] = number;
    }
    return sorted;  
  }
}