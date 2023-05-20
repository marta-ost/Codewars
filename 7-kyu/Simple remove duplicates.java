/*
DESCRIPTION:
Remove the duplicates from a list of integers, keeping the last ( rightmost ) occurrence of each element.

Example:
For input: [3, 4, 4, 3, 6, 3]

remove the 3 at index 0
remove the 4 at index 1
remove the 3 at index 3

Expected output: [4, 6, 3]

More examples can be found in the test cases.

Good luck!
*/

import java.util.Arrays;
import java.util.stream.*;

class Solution {
  public static int[] solve(int[] arr) {
    int[] reversedDistinct = reverseArray(arr)
      .distinct()
      .toArray();
    
    return reverseArray(reversedDistinct)
     .toArray();
  }
  
  public static IntStream reverseArray(int[] array) {
    return IntStream
     .range(0, array.length)
     .map(i -> array[array.length - 1 - i]);
  }
}