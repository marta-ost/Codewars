/*
DESCRIPTION:
Complete the method so that it formats the words into a single comma separated value. The last word should be separated by the word 'and' instead of a comma. The method takes in an array of strings and returns a single formatted string.

Note:

Empty string values should be ignored.
Empty arrays or null/nil/None values being passed into the method should result in an empty string being returned.
Example: (Input --> output)

['ninja', 'samurai', 'ronin'] --> "ninja, samurai and ronin"
['ninja', '', 'ronin'] --> "ninja and ronin"
[] -->""
*/

import java.util.Arrays;

public class Kata {
  public static String formatWords(String[] words) {
    if (words == null)
      return "";
    
    String[] nonEmptyWords = Arrays.stream(words)
      .filter(word -> !word.isEmpty())
      .toArray(String[]::new);
    
    StringBuilder formatted = new StringBuilder();
    
    for (int i = 0; i < nonEmptyWords.length; i++) {
      if (i == nonEmptyWords.length - 1)
        formatted.append(nonEmptyWords[i]);
      else if (i == nonEmptyWords.length - 2)
        formatted.append(nonEmptyWords[i]).append(" and ");
      else 
        formatted.append(nonEmptyWords[i]).append(", ");
    }
    
    return formatted.toString();
  }
}