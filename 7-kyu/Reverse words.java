/*
DESCRIPTION:
Complete the function that accepts a string parameter, and reverses each word in the string. All spaces in the string should be retained.

Examples
"This is an example!" ==> "sihT si na !elpmaxe"
"double  spaces"      ==> "elbuod  secaps"
*/

import java.util.Arrays;
import java.util.stream.*;

public class Kata {
  public static String reverseWords(final String original) {
    return original.trim().isEmpty() ? original
      : Arrays.stream(original.split(" "))
        .map(word -> new StringBuilder(word).reverse().toString())
        .collect(Collectors.joining(" "));
  }
}