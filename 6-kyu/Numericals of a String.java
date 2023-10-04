/*
DESCRIPTION:
You are given an input string.

For each symbol in the string if it's the first character occurrence, replace it with a '1', else replace it with the amount of times you've already seen it.

Examples:

input   =  "Hello, World!"
result  =  "1112111121311"

input   =  "aaaaaaaaaaaa"
result  =  "123456789101112"

There might be some non-ascii characters in the string.

Note: there will be no int domain overflow (character occurrences will be less than 2 billion).

Take note of performance
*/

import java.util.*;

public class JomoPipi {
  public static String numericals(String s) {
    StringBuilder counts = new StringBuilder();
    Map<Character, Integer> lettersWithCounts = new HashMap<>();
    
    for (int i = 0; i < s.length(); i++) {
      char letter = s.charAt(i);
      int count = lettersWithCounts.getOrDefault(letter, 0) + 1;   
      lettersWithCounts.put(letter, count);
      counts.append(count);
    }
    
    return counts.toString();
  }
}