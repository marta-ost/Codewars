/*
DESCRIPTION:
Given an array of numbers, sort them in such a manner that all the odd numbers in the array are sorted in ascending order and the even numbers are sorted in descending order after the last odd number. For example [1,2,3,4,5,6,7,8,9] produces the output [1,3,5,7,9,8,6,4,2]. If the array contains decimals, round them down while checking for odd/even. The output must have the original numbers!
*/

import java.util.stream.*;
import java.util.*;

public class Kata {
  public static Double[] sortItOut(Double[] array) {
    Double[] oddAsc = Arrays
      .stream(array)
      .filter(d -> Math.floor(d) % 2 != 0)
      .sorted()
      .toArray(Double[]::new);
    
    Double[] evenDesc = Arrays
      .stream(array)
      .filter(d -> Math.floor(d) % 2 == 0)
      .sorted(Comparator.reverseOrder())
      .toArray(Double[]::new);
    
    return Stream
      .concat(Arrays.stream(oddAsc), Arrays.stream(evenDesc))
      .toArray(Double[]::new);
  }
}