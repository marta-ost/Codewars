/*
DESCRIPTION:
Input: Array of elements

["h","o","l","a"]

Output: String with comma delimited elements of the array in th same order.

"h,o,l,a"

Note: if this seems too simple for you try the next level
*/

import java.util.stream.*;
import java.util.Arrays;

public class ArrayPrinter {
  public static String printArray(Object[] array) {
    return Arrays.stream(array)
      .map(Object::toString)
      .collect(Collectors.joining(","));
  }
}