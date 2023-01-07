/*
DESCRIPTION:
Given a string of words, you need to find the highest scoring word.

Each letter of a word scores points according to its position in the alphabet: a = 1, b = 2, c = 3 etc.

For example, the score of abad is 8 (1 + 2 + 1 + 4).

You need to return the highest scoring word as a string.

If two words score the same, return the word that appears earliest in the original string.

All letters will be lowercase and all inputs will be valid.
*/

import java.util.LinkedHashMap;

public class Kata {
  public static String high(String s) {
    String[] words = s.split(" ");
    LinkedHashMap<String, Integer> wordsWithValues = new LinkedHashMap<>();
    
    for (String word : words) {
      int letterValue = 0;
      int wordValue = 0;
      
      for (int index = 0; index < word.length(); index++) {
        char letter = word.charAt(index);
        letterValue = letter - 96;
        wordValue += letterValue;
      }  
      wordsWithValues.put(word, wordValue);
    }
    
    return wordsWithValues
      .entrySet()
      .stream()
      .max((entry2, entry1) -> entry2.getValue() < entry1.getValue() ? -1 : 1)
      .get()
      .getKey();
  }
}