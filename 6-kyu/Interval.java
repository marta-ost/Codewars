/*
DESCRIPTION:
Given an array of numbers and string which can be in form:

"[a,b]"
"(a,b]"
"[a,b)"
"(a,b)"

image 

More about intervals.

Task
Given an array of numbers and string - interval.

Return array of numbers between interval. Output must be sorted array. If string/array is empty, return empty array.
*/

import java.util.*;
import java.util.stream.*;

public class Math {
  public static int[] Interval(int[] arr, String str) {
    if (str.isEmpty() || arr.length == 0) return new int[]{};
    
    int firstNumber = Integer.parseInt(str.substring(1, str.indexOf(",")));
    int lastNumber = Integer.parseInt(str.substring(str.indexOf(",") + 1, str.length() - 1));
    
    final int minNumber = str.startsWith("[") ? firstNumber : firstNumber + 1;
    final int maxNumber = str.endsWith("]") ? lastNumber : lastNumber - 1;
  
    return Arrays
      .stream(arr)
      .filter(i -> i >= minNumber && i <= maxNumber)
      .sorted()
      .toArray();
  }
}