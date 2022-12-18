/*
DESCRIPTION:
Your task is to make a function that can take any non-negative integer as an argument and return it with its digits in descending order. Essentially, rearrange the digits to create the highest possible number.

Examples:
Input: 42145 Output: 54421

Input: 145263 Output: 654321

Input: 123456789 Output: 987654321
*/

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.*;

public class DescendingOrder {
  public static int sortDesc(final int num) {
    Integer[] digits = Arrays.stream(String.valueOf(num).split(""))
      .mapToInt(Integer::parseInt)
      .boxed()
      .toArray(Integer[]::new);
    Arrays.sort(digits, Collections.reverseOrder());
    return Integer.parseInt(Arrays.stream(digits)
      .map(x -> x.toString())
      .collect(Collectors.joining()));
  }
}