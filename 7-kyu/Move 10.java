/*
DESCRIPTION:
Move every letter in the provided string forward 10 letters through the alphabet.

If it goes past 'z', start again at 'a'.

Input will be a string with length > 0.
*/

import java.util.stream.*;

public class MoveTen {
  public static String moveTen(String s) {
    final int CHANGE = 10;
    final int ASCII_ALPHABET_END = 122;
    final int ALPHABET_LENGTH = 26;
    
    return s
      .chars()
      .map(i -> i + CHANGE > ASCII_ALPHABET_END ? 
                i + CHANGE - ALPHABET_LENGTH : 
                i + CHANGE)
      .mapToObj(i -> String.valueOf((char) i))
      .collect(Collectors.joining(""));
  }
}