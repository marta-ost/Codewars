/*
DESCRIPTION:
Description:

We want to generate a function that computes the series starting from 0 and ending until the given number.

Example:

Input:
> 6
Output:
0+1+2+3+4+5+6 = 21

Input:
> -15
Output:
-15<0

Input:
> 0
Output:
0=0
*/

import java.util.stream.*;

public class SequenceSum {
  public static String showSequence(int value) {
    if (value < 0)
      return value + "<0";
    
    String addition = IntStream
      .rangeClosed(0, value)
      .mapToObj(String::valueOf)
      .collect(Collectors.joining("+"));
    
    int sum = IntStream
      .rangeClosed(0, value)
      .sum();
    
    return value == 0 ? addition + "=" + sum : addition + " = " + sum;
  }
}