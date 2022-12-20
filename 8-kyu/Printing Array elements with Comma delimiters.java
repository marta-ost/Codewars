/*
DESCRIPTION:
Input: Array of elements

["h","o","l","a"]

Output: String with comma delimited elements of the array in th same order.

"h,o,l,a"

Note: if this seems too simple for you try the next level
*/

public class ArrayPrinter {
  public static String printArray(Object[] array) {
    StringBuilder result = new StringBuilder();
    for (Object elem : array) {
      result.append(String.valueOf(elem)).append(",");
    }
    return result.substring(0, result.length() - 1);
  }
}