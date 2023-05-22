/*
DESCRIPTION:
Count how often sign changes in array.

result
number from 0 to ... . Empty array returns 0

example

const arr = [1, -3, -4, 0, 5];

| elem | count |
|------|-------|
|  1   |  0    |
| -3   |  1    |
| -4   |  1    |
|  0   |  2    |
|  5   |  2    |

catchSignChange(arr) == 2;
*/

import java.util.stream.*;

public class Solution {
  public static int signChange(int[] arr) {
    return (int) IntStream
      .range(1, arr.length)
      .filter(i -> (arr[i] < 0 && arr[i - 1] >= 0) ||
                   (arr[i - 1] < 0 && arr[i] >= 0))
      .count();
  }
}