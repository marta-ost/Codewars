/*
DESCRIPTION:
In this kata you are given an array to sort but you're expected to start sorting from a specific position of the array (in ascending order) and optionally you're given the number of items to sort.

Examples:

SectionalArray.sort([1, 2, 5, 7, 4, 6, 3, 9, 8], 2) //=> [1, 2, 3, 4, 5, 6, 7, 8, 9]
SectionalArray.sort([9, 7, 4, 2, 5, 3, 1, 8, 6], 2, 5) // => [9, 7, 1, 2, 3, 4, 5, 8, 6]

Documentation:

SectionalArray.sort(array, start, length);

array - array to sort
start - position to begin sorting
length - number of items to sort (optional)

if the length argument is not passed or is zero, you sort all items to the right of the start position in the array
*/

import java.util.*;
import java.util.stream.*;

class SectionalArray {
  static int[] sort(final int[] array, final int start, final int... length) {
    IntStream beforeStart = IntStream
      .range(0, start)
      .map(i -> array[i]);
    
    if (length.length == 0 || length[0] == 0) {  
      IntStream sorted = IntStream
        .range(start, array.length)
        .map(i -> array[i])
        .sorted();
      
      return IntStream
        .concat(beforeStart, sorted)
        .toArray();
    } else {
      IntStream sorted = IntStream
        .range(start, length[0] + start < array.length 
             ? length[0] + start : array.length)
        .map(i -> array[i])
        .sorted();
    
      IntStream remaining = IntStream
        .range(length[0] + start, array.length)
        .map(i -> array[i]);
      
      return IntStream
        .concat(IntStream.concat(beforeStart, sorted), remaining)
        .toArray();  
    }
  }
}