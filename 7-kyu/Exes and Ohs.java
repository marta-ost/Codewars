/*
DESCRIPTION:
Check to see if a string has the same amount of 'x's and 'o's. The method must return a boolean and be case insensitive. The string can contain any char.

Examples input/output:

XO("ooxx") => true
XO("xooxx") => false
XO("ooxXm") => true
XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
XO("zzoo") => false
*/

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class XO {
  public static boolean getXO (String str) {
    Map<String, Long> lettersWithCount =
      Arrays.stream(str.split(""))
      .map(String::toLowerCase)
      .filter(letter -> letter.equals("x") || letter.equals("o"))
      .collect(Collectors.groupingBy(Function.identity(),
                                    Collectors.counting()));
    
    return lettersWithCount.get("x") == lettersWithCount.get("o");
  }
}