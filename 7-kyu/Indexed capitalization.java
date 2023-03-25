/*
DESCRIPTION:
Given a string and an array of integers representing indices, capitalize all letters at the given indices.

For example:

capitalize("abcdef",[1,2,5]) = "aBCdeF"
capitalize("abcdef",[1,2,5,100]) = "aBCdeF". There is no index 100.
The input will be a lowercase string with no spaces and an array of digits.

Good luck!
*/

package kata;

public class Solution {
  public static String capitalize(String s, int[] ind) {
    for (int i = 0; i < ind.length; i++) {
      int index = ind[i];
      if (index <= s.length())
        s = s.substring(0, index) + s.substring(index, index + 1).toUpperCase() + s.substring(index + 1);
    }
    return s;
  }
}