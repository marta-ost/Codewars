/*
DESCRIPTION:

Task

Remove all exclamation marks from the end of words. Words are separated by a single space. There are no exclamation marks within a word.

Examples

remove("Hi!") === "Hi"
remove("Hi!!!") === "Hi"
remove("!Hi") === "!Hi"
remove("!Hi!") === "!Hi"
remove("Hi! Hi!") === "Hi Hi"
remove("!!!Hi !!hi!!! !hi") === "!!!Hi !!hi !hi"
*/

import java.util.*;
import java.util.stream.*;

public class R {
  public static String removeBang(String str) {
    return Arrays
      .stream(str.split(" "))
      .map(word -> removeExclamationMarksAtTheEnd(word))
      .collect(Collectors.joining(" "));
  }
  
  private static String removeExclamationMarksAtTheEnd(String word) {
    return word.endsWith("!") 
      ? removeExclamationMarksAtTheEnd(word.substring(0, word.length() - 1))
      : word;
  }
}