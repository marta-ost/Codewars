/*
DESCRIPTION:
We want to find the numbers higher or equal than 1000 that the sum of every four consecutives digits cannot be higher than a certain given value. If the number is num = d1d2d3d4d5d6, and the maximum sum of 4 contiguous digits is maxSum, then:

d1 + d2 + d3 + d4 <= maxSum
d2 + d3 + d4 + d5 <= maxSum
d3 + d4 + d5 + d6 <= maxSum

For that purpose, we need to create a function, max_sumDig(), that receives nMax, as the max value of the interval to study (the range (1000, nMax) ), and a certain value, maxSum, the maximum sum that every four consecutive digits should be less or equal to. The function should output the following list with the data detailed bellow:

[(1), (2), (3)]

(1) - the amount of numbers that satisfy the constraint presented above

(2) - the closest number to the mean of the results, if there are more than one, the smallest number should be chosen.

(3) - the total sum of all the found numbers

Let's see a case with all the details:

max_sumDig(2000, 3) -------> [11, 1110, 12555]

(1) -There are 11 found numbers: 1000, 1001, 1002, 1010, 1011, 1020, 1100, 1101, 1110, 1200 and 2000

(2) - The mean of all the found numbers is:
      (1000 + 1001 + 1002 + 1010 + 1011 + 1020 + 1100 + 1101 + 1110 + 1200 + 2000) /11 = 1141.36363,  
      so 1110 is the number that is closest to that mean value.

(3) - 12555 is the sum of all the found numbers
      1000 + 1001 + 1002 + 1010 + 1011 + 1020 + 1100 + 1101 + 1110 + 1200 + 2000 = 12555

Finally, let's see another cases

max_sumDig(2000, 4) -----> [21, 1120, 23665]

max_sumDig(2000, 7) -----> [85, 1200, 99986]

max_sumDig(3000, 7) -----> [141, 1600, 220756]

```

Happy coding!!
*/

import java.util.stream.*;
import java.util.*;

public class MaxSumDigits {
  final static long N_MIN = 1000;
  final static int CONSECUTIVE_DIGITS = 4;
  
  public static long[] maxSumDig(long nmax, int maxsm) {
    long[] correctNumbers = findNumbers(nmax, maxsm);
    long closestToMean = findClosestToMean(correctNumbers);
    long sumOfNumbers = sumNumbers(correctNumbers);
    
    return new long[]{correctNumbers.length, closestToMean, sumOfNumbers};
  }
  
  private static long findClosestToMean(long[] numbers) {
    double mean = findMean(numbers);
    
    long closestValue = Long.MAX_VALUE;
    
    for (int i = numbers.length - 1; i >= 0; i--) {
      if (Math.abs(mean - numbers[i]) <= Math.abs(mean - closestValue))
        closestValue = numbers[i];
    }
    
    return closestValue;
  }
  
  private static double findMean(long[] numbers) {
    return (double) sumNumbers(numbers) / numbers.length;
  }
  
  private static long sumNumbers(long[] numbers) {
    return Arrays
      .stream(numbers)
      .sum();
  }
  
  private static long[] findNumbers(long nmax, int maxsm) {
    return LongStream
      .rangeClosed(N_MIN, nmax)
      .filter(num -> IntStream
              .rangeClosed(0, String.valueOf(num).length() - CONSECUTIVE_DIGITS)
              .mapToObj(i -> String.valueOf(num).substring(i, i + CONSECUTIVE_DIGITS))
              .filter(i -> sumDigits(i) <= maxsm)
              .count() == String.valueOf(num).length() - CONSECUTIVE_DIGITS + 1)
      .toArray();
  }
  
  private static int sumDigits(String number) {
    return Arrays
      .stream(number.split(""))
      .map(Integer::parseInt)
      .mapToInt(Integer::intValue)
      .sum();
  }
}