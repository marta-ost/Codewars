/*
DESCRIPTION:
Write a function

TripleDouble(long num1, long num2)

which takes numbers num1 and num2 and returns 1 if there is a straight triple of a number at any place in num1 and also a straight double of the same number in num2.

If this isn't the case, return 0

Examples

TripleDouble(451999277, 41177722899) == 1 // num1 has straight triple 999s and 
                                          // num2 has straight double 99s

TripleDouble(1222345, 12345) == 0 // num1 has straight triple 2s but num2 has only a single 2

TripleDouble(12345, 12345) == 0

TripleDouble(666789, 12345667) == 1
*/

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class Kata {
  public static int TripleDouble(long num1, long num2) {
    Map<Long, Long> digitsWithAmountsNum1 = getDigitsWithAmountsMap(num1);
    List<Long> triplets = getRepeatingDigits(digitsWithAmountsNum1, 3, num1);
    
    Map<Long, Long> digitsWithAmountsNum2 = getDigitsWithAmountsMap(num2);
    List<Long> doublets = getRepeatingDigits(digitsWithAmountsNum2, 2, num2);
      
    return triplets == null || doublets == null ? 0 
      : LongStream
          .rangeClosed(0, 9)
          .filter(digit -> triplets.contains(digit))
          .filter(digit -> doublets.contains(digit))
          .count() > 0 ? 1 
      : 0;
  }

  private static List<Long> getRepeatingDigits(Map<Long, Long> digitsWithAmounts, int repetitions, long num) {
    return digitsWithAmounts
      .entrySet()
      .stream()
      .filter(entry -> entry.getValue() >= repetitions)
      .map(entry -> entry.getKey())
      .filter(digit -> checkIfRepeatingDigitsAreStraight(num, digit, repetitions))
      .collect(Collectors.toList());
  }
  
  private static boolean checkIfRepeatingDigitsAreStraight(long num, long digit, int repetitions) {
    return String.valueOf(num)
                 .indexOf(String.valueOf(digit).repeat(repetitions)) >= 0;
  }
  
  private static Map<Long, Long> getDigitsWithAmountsMap(long num) {
    return Arrays
      .stream(String.valueOf(num).split(""))
      .map(s -> Long.parseLong(s))
      .collect(Collectors.groupingBy(Function.identity(),
                                     Collectors.counting()));
  }
}