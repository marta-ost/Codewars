/*
DESCRIPTION:
Complete the function that takes a string of English-language text and returns the number of consonants in the string.

Consonants are all letters used to write English excluding the vowels a, e, i, o, u.
*/

import java.util.Arrays;

public class Consonants {
  public static int getCount(String str) {
    return (int) Arrays
      .stream(str.toLowerCase().split(""))
      .filter(letter -> letter.matches("[a-z]"))
      .filter(letter -> letter.matches("[^aeiou]"))
      .count();
  }
}