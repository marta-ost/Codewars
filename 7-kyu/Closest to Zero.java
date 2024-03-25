/*
DESCRIPTION:

Simply find the closest value to zero from the list. Notice that there are negatives in the list.

List is always not empty and contains only integers. Return None if it is not possible to define only one of such values. And of course, we are expecting 0 as closest value to zero.

Examples:

[2, 4, -1, -3]  => -1
[5, 2, -2]      => None
[5, 2, 2]       => 2
[13, 0, -6]     => 0
*/

import java.util.*;

public class ClosestToZero {
  public static Integer find(int[] arr) {
    if (arr.length == 0)
      return null;
    if (arr.length == 1)
      return arr[0];
    
    int[] closestAsc = Arrays
      .stream(arr)
      .distinct()
      .boxed()
      .sorted((a, b) -> Integer.compare(Math.abs(a), Math.abs(b)))
      .mapToInt(Integer::intValue)
      .toArray();
              
    return Math.abs(closestAsc[0]) == Math.abs(closestAsc[1]) && closestAsc[0] != closestAsc[1] ? null
      : closestAsc[0];
  }
}