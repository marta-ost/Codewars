/*
DESCRIPTION:
Your task is to remove all duplicate words from a string, leaving only single (first) words entries.

Example:

Input:

'alpha beta beta gamma gamma gamma delta alpha beta beta gamma gamma gamma delta'

Output:

'alpha beta gamma delta'
*/

import java.util.Arrays;
import java.util.stream.*;

class Solution {
  public static String removeDuplicateWords(String s) {
    return Arrays.stream(s.split(" "))
      .distinct()
      .collect(Collectors.joining(" "));
  }
}