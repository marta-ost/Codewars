/*
DESCRIPTION:
Given an array of integers as strings and numbers, return the sum of the array values as if all were numbers.

Return your answer as a number.
*/

import java.util.List;

public class MixedSum {
  public int sum(List<?> mixed) {
	int sum = 0;
    for (int i = 0; i < mixed.size(); i++) {
      sum += Integer.parseInt(mixed.get(i).toString());
    }
    return sum;
  }
}