/*
DESCRIPTION:
Given an array with exactly 5 strings "a", "b" or "c" (chars in Java, characters in Fortran), check if the array contains three and two of the same values.

Examples
["a", "a", "a", "b", "b"] ==> true  // 3x "a" and 2x "b"
["a", "b", "c", "b", "c"] ==> false // 1x "a", 2x "b" and 2x "c"
["a", "a", "a", "a", "a"] ==> false // 5x "a"
*/

import java.util.stream.*;

public class Solution {
  public boolean checkThreeAndTwo(char[] chars) {
    int[] amounts = IntStream
      .range(0, chars.length)
      .mapToObj(i -> chars[i])
      .collect(Collectors.toMap(i -> i, 
                                i -> 1, 
                                Integer::sum))
      .values()
      .stream()
      .sorted()
      .mapToInt(Integer::intValue)
      .toArray();
    
    return amounts.length == 2 && amounts[0] == 2 && amounts[1] == 3;
  }
}