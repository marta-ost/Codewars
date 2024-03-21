/*
DESCRIPTION:
In this Kata, you will be given an array of unique elements, and your task is to rearrange the values so that the first max value is followed by the first minimum, followed by second max value then second min value, etc.

For example:

solve([15,11,10,7,12]) = [15,7,12,10,11]

The first max is 15 and the first min is 7. The second max is 12 and the second min is 10 and so on.

More examples in the test cases.

Good luck!
*/

import java.util.*;
import java.util.stream.*;

class Solution {
  public static int[] solve(int[] arr) {
    List<Integer> numbers = Arrays
      .stream(arr)
      .boxed()
      .collect(Collectors.toList());
    
    int[] sorted = new int[arr.length];
    
    for (int i = 0; i < arr.length; i++) {
      int value = i % 2 == 0 ? Collections.max(numbers) : Collections.min(numbers);
      sorted[i] = value;
      numbers.remove(numbers.indexOf(value));
    }
    
    return sorted;
  }
}