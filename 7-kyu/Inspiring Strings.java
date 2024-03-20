/*
DESCRIPTION:
When given a string of space separated words, return the word with the longest length. If there are multiple words with the longest length, return the last instance of the word with the longest length.

Example:

'red white blue' //returns string value of white

'red blue gold' //returns gold
*/

import java.util.*;
import java.util.stream.*;

public class Kata {
  public static String longestWord(String wordString) {
    String[] words = wordString.split(" ");
    
    int maxLength = Arrays
      .stream(words)
      .mapToInt(word -> word.length())
      .max()
      .getAsInt();
      
    return IntStream
      .range(0, words.length)
      .mapToObj(i -> words[words.length - i - 1])
      .filter(word -> word.length() == maxLength)
      .findFirst()
      .get();
  }
}