/*
DESCRIPTION:
Compare two strings by comparing the sum of their values (ASCII character code).

For comparing treat all letters as UpperCase
null/NULL/Nil/None should be treated as empty strings
If the string contains other characters than letters, treat the whole string as it would be empty
Your method should return true, if the strings are equal and false if they are not equal.

Examples:
"AD", "BC"  -> equal
"AD", "DD"  -> not equal
"gf", "FG"  -> equal
"zz1", ""   -> equal (both are considered empty)
"ZzZz", "ffPFF" -> equal
"kl", "lz"  -> not equal
null, ""    -> equal
*/

public class Kata {
  public static boolean compare(String s1, String s2) {
    return findSumOfChars(s1) == findSumOfChars(s2);
  }
  
  public static int findSumOfChars(String s) {
    return s == null || !s.matches("[A-Za-z]+") ? 0
      : s.toUpperCase().chars().sum();
  }
}