/*
DESCRIPTION:
Given the string representations of two integers, return the string representation of the sum of those integers.

For example:

sumStrings('1','2') // => '3'

A string representation of an integer will contain no characters besides the ten numerals "0" to "9".

I have removed the use of BigInteger and BigDecimal in java

Python: your solution need to work with huge numbers (about a milion digits), converting to int will not work.
*/

import java.util.*;
import java.util.stream.*;

public class Kata {
  static final int LENGTH_OF_PARTS = 7;
  
  public static String sumStrings(String a, String b) {
    if (a.length() > b.length()) 
      b = padWithZeros(b, a.length());
    else if (b.length() > a.length())
      a = padWithZeros(a, b.length());
    
    int[] arrayA = convertPartsToInt(splitToParts(a));
    int[] arrayB = convertPartsToInt(splitToParts(b));
    
    int[] sumsInParts = addPartsOfArrays(arrayA, arrayB);
    String joined = formatAndJoinPartsOfArray(sumsInParts);
    return removePadding(joined);
  }
  
  private static String padWithZeros(String text, int length) {
    String temp = "0".repeat(length) + text;
    return temp.substring(temp.length() - length);
  }
  
  private static String removePadding(String text) {
    if (text.startsWith("0")) {
      text = text.substring(1);
      text = removePadding(text);
    } 
    return text;
  }
  
  private static String formatAndJoinPartsOfArray(int[] result) {
    return IntStream
      .range(0, result.length)
      .mapToObj(i -> padWithZeros(String.valueOf(result[i]), LENGTH_OF_PARTS))
      .collect(Collectors.joining(""));
  }
  
  private static int[] addPartsOfArrays(int[] arrayA, int[] arrayB) {
    int[] result = new int[arrayA.length];
    
    if (result.length == 1) {
      result[0] = arrayA[0] + arrayB[0];
      return result;
    }
    
    int fromPreviousSum = 0;
    
    for (int i = result.length - 1; i >= 0; i--) {
      result[i] = arrayA[i] + arrayB[i] + fromPreviousSum;  
      
      fromPreviousSum = result[i] > Integer.valueOf("9".repeat(LENGTH_OF_PARTS)) ? 
        Integer.parseInt(String.valueOf(result[i]).substring(0, 1)) : 0;
    }
    return result;
  }
  
  private static int[] convertPartsToInt(String[] array) {
    return Arrays.stream(array)
      .map(string -> Integer.parseInt(string))
      .mapToInt(Integer::intValue)
      .toArray();
  }
  
  private static String[] splitToParts(String string) {
    String[] array = new String[string.length() / LENGTH_OF_PARTS + 1];
    
    for (int i = array.length - 1; i >= 0; i--) {
      if (i == 0) {
        array[i] = padWithZeros(string, LENGTH_OF_PARTS);
      } else {
        array[i] = string.substring(string.length() - LENGTH_OF_PARTS);
        string = string.substring(0, string.length() - LENGTH_OF_PARTS);
      }
    }   
    return array;
  }
}