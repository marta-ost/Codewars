/*
DESCRIPTION:
Given two words and a letter, return a single word that's a combination of both words, merged at the point where the given letter first appears in each word. The returned word should have the beginning of the first word and the ending of the second, with the dividing letter in the middle. You can assume both words will contain the dividing letter.

Examples
("hello", "world", "l")       ==>  "held"
("coding", "anywhere", "n")   ==>  "codinywhere"
("jason", "samson", "s")      ==>  "jasamson"
("wonderful", "people", "e")  ==>  "wondeople"
*/

public class Kata {
  public static String stringMerge(String s1, String s2, char letter) { 
    StringBuilder merged = new StringBuilder();
    merged.append(s1.substring(0, s1.indexOf(letter)))
      .append(s2.substring(s2.indexOf(letter)));
    
    return merged.toString();
  }
}