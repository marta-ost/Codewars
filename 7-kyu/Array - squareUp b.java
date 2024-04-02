/*
DESCRIPTION:
This is a question from codingbat

Given an integer n greater than or equal to 0, create and return an array with the following pattern:

squareUp(3) => [0, 0, 1, 0, 2, 1, 3, 2, 1]
squareUp(2) => [0, 1, 2, 1]
squareUp(4) => [0, 0, 0, 1, 0, 0, 2, 1, 0, 3, 2, 1, 4, 3, 2, 1]

0 <= n <= 1000.
*/

import java.util.*;
import java.util.stream.*;

public class Kata {
  public static int[] squareUp(int n) {
    return IntStream
      .rangeClosed(1, n)
      .mapToObj(i -> partOfArray(i, n))
      .flatMapToInt(IntStream::of)
      .toArray();
  }
  
  private static int[] partOfArray(int i, int length) {
    int[] zeros = length == i ? new int[]{} 
    : Arrays
      .stream("0".repeat(length - i).split(""))
      .mapToInt(Integer::parseInt)
      .toArray();
    
    int[] numbers = IntStream
      .rangeClosed(1, i)
      .map(j -> i + 1 - j)
      .toArray();
    
    return Stream
      .of(zeros, numbers)
      .flatMapToInt(IntStream::of)
      .toArray();
  }
}