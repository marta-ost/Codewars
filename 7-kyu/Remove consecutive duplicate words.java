/*
DESCRIPTION:
Your task is to remove all consecutive duplicate words from a string, leaving only first words entries. For example:

"alpha beta beta gamma gamma gamma delta alpha beta beta gamma gamma gamma delta"

--> "alpha beta gamma delta alpha beta gamma delta"

Words will be separated by a single space. There will be no leading or trailing spaces in the string. An empty string (0 words) is a valid input.
*/

public class Kata {
  public static String removeConsecutiveDuplicates(String s) {
    String[] words = s.split(" ");
    
    StringBuilder result = new StringBuilder(words[0] + " ");
    
    for (int i = 1; i < words.length; i++)
      if (!words[i].equals(words[i - 1]))
        result.append(words[i]).append(" ");
    
    return result.toString().trim();
  }
}