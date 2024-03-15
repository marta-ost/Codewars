/*
DESCRIPTION:
Write a function that merges two sorted arrays into a single one. The arrays only contain integers. Also, the final outcome must be sorted and not have any duplicate.
*/

import java.util.stream.*;
import java.util.Arrays;

public class Kata {
  public static int[] mergeArrays(int[] first, int[] second) {
	return IntStream
      .concat(Arrays.stream(first), Arrays.stream(second))
      .distinct()
      .sorted()
      .toArray();
  }
}