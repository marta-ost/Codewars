/*
DESCRIPTION:
In this Kata, you will be given a string that has lowercase letters and numbers. Your task is to compare the number groupings and return the largest number. Numbers will not have leading zeros.

For example, solve("gh12cdy695m1") = 695, because this is the largest of all number groupings.

Good luck!
*/

import java.util.stream.*;
import java.util.Arrays;

class Solution {
  public static int solve(String s) {
    s = s.replaceAll("[A-Za-z]", " ");
    
    int[] numbers = Arrays.stream(s.split(" "))
      .filter(i -> !i.isEmpty())
      .mapToInt(Integer::parseInt)
      .toArray();
    
    int largest = numbers[0];
    
    for (int i = 1; i < numbers.length; i++) {
      if (numbers[i] > largest)
        largest = numbers[i];
    }
      
    return largest;
  }
}