/*
DESCRIPTION:
#Get the averages of these numbers

Write a method, that gets an array of integer-numbers and return an array of the averages of each integer-number and his follower, if there is one.

Example:

Input:  [ 1, 3, 5, 1, -10]
Output:  [ 2, 4, 3, -4.5]

If the array has 0 or 1 values or is null, your method should return an empty array.

Have fun coding it and please don't forget to vote and rank this kata! :-)
*/

import java.util.stream.*;

public class Kata {
  public static double[] averages(int[] numbers) {
    return numbers == null || numbers.length < 2 ? new double[0] 
    : IntStream.rangeClosed(0, numbers.length - 2)
      .mapToDouble(i -> (double) (numbers[i] + numbers[i + 1]) / 2)
      .toArray();
  }
}