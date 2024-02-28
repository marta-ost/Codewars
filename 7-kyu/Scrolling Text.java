/*
DESCRIPTION:
Let's create some scrolling text!

Your task is to complete the function which takes a string, and returns an array with all possible rotations of the given string, in uppercase.

Example
scrollingText("codewars") should return:

[ "CODEWARS",
  "ODEWARSC",
  "DEWARSCO",
  "EWARSCOD",
  "WARSCODE",
  "ARSCODEW"
  "RSCODEWA",
  "SCODEWAR" ]

Good luck!
*/

import java.util.stream.*;

public class Kata {
  public static String[] scrollingText(String text) {
    return IntStream
      .range(0, text.length())
      .mapToObj(i -> (text + text).substring(i, i + text.length()).toUpperCase())
      .toArray(String[]::new);
  }
}