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
    
    int firstNumber = findNumber(str.substring(1, str.indexOf(",")));
    int lastNumber = findNumber(str.substring(str.indexOf(",") + 1));
    
    boolean startClosed = str.charAt(0) == '[';
    boolean endClosed = str.charAt(str.length() - 1) == ']';  
    
    if (!startClosed) firstNumber++;
    if (!endClosed) lastNumber--;
  
    return IntStream
      .rangeClosed(firstNumber, lastNumber)
      .boxed()
      .filter(number -> Arrays.stream(arr).anyMatch(number::equals))
      .mapToInt(o -> (int) o)
      .toArray();
  }
  
  private static int findNumber(String str) {
    boolean positive = true;
    if (str.charAt(0) == '-') positive = false;
    
    String numberAbsStr = str.replace("[", "").replace("]", "").replace("(", "").replace(")", "").replace("-", "");
    int numberAbs = Integer.parseInt(numberAbsStr); 
    
    return positive ? numberAbs : -1 * numberAbs; 
  }
}