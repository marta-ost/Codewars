/*
DESCRIPTION:
When given a string of space separated words, return the word with the longest length. If there are multiple words with the longest length, return the last instance of the word with the longest length.

Example:

'red white blue' //returns string value of white

'red blue gold' //returns gold
*/

import java.util.*;

public class Kata {
  public static String longestWord(String wordString) {
    return Arrays
      .stream(wordString.split(" "))
      .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
      .get();
  }
}