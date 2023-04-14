/*
DESCRIPTION:
Find the number with the most digits.

If two numbers in the argument array have the same number of digits, return the first one in the array.
*/

import java.util.Arrays;
import java.util.Comparator;

public class MostDigits {
  public static int findLongest(int[] numbers) {
    return Arrays
      .stream(numbers)
      .mapToObj(String::valueOf)
      .max(Comparator.comparingInt(s -> s
                                   .replaceAll("-", "")
                                   .length()))
      .map(Integer::parseInt)
      .get();
  }
}