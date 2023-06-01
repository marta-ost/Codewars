/*
DESCRIPTION:
The vowel substrings in the word codewarriors are o,e,a,io. The longest of these has a length of 2. Given a lowercase string that has alphabetic characters only (both vowels and consonants) and no spaces, return the length of the longest vowel substring. Vowels are any of aeiou.

Good luck!
*/

import java.util.Arrays;

class Solution {
  public static int solve(String s) {
    String vowels = s.replaceAll("[^aeiou]", " ");
    String[] vowelsGroups = vowels.split(" ");
    
    return Arrays.stream(vowelsGroups)
      .mapToInt(group -> group.length())
      .max()
      .getAsInt();
  }
}