/*
DESCRIPTION:
Given a string indicating a range of letters, return a string which includes all the letters in that range, including the last letter. Note that if the range is given in capital letters, return the string in capitals also!

Examples

gimmeTheLetters("a-z") ➞ "abcdefghijklmnopqrstuvwxyz"

gimmeTheLetters("h-o") ➞ "hijklmno"

gimmeTheLetters("Q-Z") ➞ "QRSTUVWXYZ"

gimmeTheLetters("J-J") ➞ "J"

Notes

A hyphen will separate the two letters in the string.
You don't need to worry about error handling in this one (i.e. both letters will be the same case and the second letter will always be after the first alphabetically).
*/

import java.util.stream.*;

public class Solution {
  public static String gimmeTheLetters(String s) {
    return IntStream
      .rangeClosed(s.charAt(0), s.charAt(2))
      .mapToObj(i -> String.valueOf((char) i))
      .collect(Collectors.joining(""));
  }
}