/*
DESCRIPTION:
Implement the function which should return true if given object is a vowel (meaning a, e, i, o, u, uppercase or lowercase), and false otherwise.
*/

public class StringUtils {
  public static boolean isVowel(String s) {
    return s.toLowerCase().matches("[aeiou]");
  }
}