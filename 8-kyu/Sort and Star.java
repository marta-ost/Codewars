/*
DESCRIPTION:
You will be given a list of strings. You must sort it alphabetically (case-sensitive, and based on the ASCII values of the chars) and then return the first value.

The returned value must be a string, and have "***" between each of its letters.

You should not remove or add elements from/to the array.
*/

import java.util.Arrays;
import java.util.stream.*;

public class SortAndStar {
  public static String twoSort(String[] s) {
    Arrays.sort(s);
    return s[0]
      .chars()
      .mapToObj(x -> String.valueOf((char) x))
      .map(x -> x + "***")
      .collect(Collectors.joining())
      .substring(0, s[0].length() * 4 - 3);
  }
}