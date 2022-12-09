/*
DESCRIPTION:
Given an array of integers.

Return an array, where the first element is the count of positives numbers and the second element is sum of negative numbers. 0 is neither positive nor negative.

If the input is an empty array or is null, return an empty array.

Example
For input [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15], you should return [10, -65].
*/

import java.util.Arrays;

public class Kata {
  public static int[] countPositivesSumNegatives(int[] input) {
    if (Arrays.asList(input).contains(null) || input.length == 0) {
      return new int[0];
    }
    int[] positivesCountAndNegativesSum = new int[2];
    int positivesCount = 0;
    int negativesSum = 0;
    
    for (int number : input) {
      if (number > 0) {
        positivesCount++;
      } else {
        negativesSum += number;
      }
    }
    positivesCountAndNegativesSum[0] = positivesCount;
    positivesCountAndNegativesSum[1] = negativesSum;
    
    return positivesCountAndNegativesSum;
  }
}