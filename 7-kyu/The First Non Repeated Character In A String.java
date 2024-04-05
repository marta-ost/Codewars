/*
DESCRIPTION:
You need to write a function, that returns the first non-repeated character in the given string.

If all the characters are unique, return the first character of the string.
If there is no unique character, return null in JS or Java, None in Python, '\0' in C.

You can assume, that the input string has always non-zero length.

Examples
"test"   returns "e"
"teeter" returns "r"
"trend"  returns "t" (all the characters are unique)
"aabbcc" returns null (all the characters are repeated)
*/

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class FirstNonRepeated {
  public static Character firstNonRepeated(String source) { 
    return Arrays
      .stream(source.split(""))
      .collect(Collectors.groupingBy(Function.identity(), 
                                     LinkedHashMap::new,
                                     Collectors.counting()))
      .entrySet()
      .stream()
      .filter(e -> e.getValue() == 1)
      .findFirst()
      .get()
      .getKey()
      .charAt(0);
  }
}