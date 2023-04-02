/*
DESCRIPTION:
Find the sum of the odd numbers within an array, after cubing the initial integers. The function should return undefined/None/nil/NULL if any of the values aren't numbers.

Note: There are ONLY integers in the JAVA and C# versions of this Kata.
*/

import java.util.Arrays;

public class FindOddCubes { 
  public static int cubeOdd(int arr[]) {
    return Arrays.stream(arr)
      .map(num -> (int) Math.pow(num, 3))
      .filter(number -> number % 2 != 0)
      .sum();
  }
}