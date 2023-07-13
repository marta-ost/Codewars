/*
DESCRIPTION:
In this Kata, you will be given two strings a and b and your task will be to return the characters that are not common in the two strings.

For example:

solve("xyab","xzca") = "ybzc" 
--The first string has 'yb' which is not in the second string. 
--The second string has 'zc' which is not in the first string. 

Notice also that you return the characters from the first string concatenated with those from the second string.

More examples in the tests cases.

Good luck!
*/

import java.util.Arrays;
import java.util.stream.*;

class Solution {
  public static String solve(String a, String b) {
    return charsFromAWithoutCharsFromB(a, b) +
      charsFromAWithoutCharsFromB(b, a);
  }
  
  public static String charsFromAWithoutCharsFromB(String a, String b) {
    return Arrays
      .stream(a.split(""))
      .filter(letter -> !b.contains(letter))
      .collect(Collectors.joining(""));
  }
}