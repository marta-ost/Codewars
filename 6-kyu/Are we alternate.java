/*
DESCRIPTION:
Create a function isAlt() that accepts a string as an argument and validates whether the vowels (a, e, i, o, u) and consonants are in alternate order.

isAlt("amazon")
// true
isAlt("apple")
// false
isAlt("banana")
// true

Arguments consist of only lowercase letters.
*/

import java.util.stream.*;

public class Solution {
  public static boolean isAlt(String word) {
    long sumOfAlternateStartingWithVowel = 
    IntStream.range(0, word.length())
      .filter(i -> i % 2 == 0)
      .mapToObj(i -> String.valueOf(word.charAt(i)))
      .filter(s -> s.matches("[AEIOUaeiou]"))
      .count() +
    IntStream.range(0, word.length())
      .filter(i -> i % 2 != 0)
      .mapToObj(i -> String.valueOf(word.charAt(i)))
      .filter(s -> s.matches("[^AEIOUaeiou]"))
      .count();
    
    return 
      sumOfAlternateStartingWithVowel == word.length() || 
      sumOfAlternateStartingWithVowel == 0;
  }
}