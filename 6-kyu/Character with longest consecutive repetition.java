/*
DESCRIPTION:
For a given string s find the character c (or C) with longest consecutive repetition and return:

Object[]{c, l};
where l (or L) is the length of the repetition. If there are two or more characters with the same l return the first in order of appearance.

For empty string return:

Object[]{"", 0}
In JavaScript: If you use Array.sort in your solution, you might experience issues with the random tests as Array.sort is not stable in the Node.js version used by CodeWars. This is not a kata issue.

Happy coding! :)
*/

import java.util.List;
import java.util.LinkedList;

public class Solution {
  public static Object[] longestRepetition(String string) {
    if (string.isEmpty())
      return new Object[]{"", 0};
    
    List<String[]> lettersWithAmounts = getLettersWithAmounts(string);
    
    int searchedAmount = 0;
    String searchedLetter = "";
    
    for (int i = 0; i < lettersWithAmounts.size(); i++) {
      String[] currentLetterWithAmount = lettersWithAmounts.get(i);
      int amount = Integer.parseInt(currentLetterWithAmount[0]);
      if (amount > searchedAmount) {
        searchedAmount = amount;
        searchedLetter = currentLetterWithAmount[1];
      }
    }
    return new Object[]{searchedLetter, searchedAmount};
  }
  
  public static List<String[]> getLettersWithAmounts(String string) {
    List<String[]> lettersWithAmounts = new LinkedList<>();
    
    String[] letters = string.split("");
    int currentAmount = 1;
    
    for (int i = 1; i < letters.length; i++) {
      if (letters[i].equals(letters[i - 1])) {
        currentAmount++;
      } else {
        lettersWithAmounts.add(new String[]{String.valueOf(currentAmount), letters[i - 1]});
        currentAmount = 1;
      }
    }        
    lettersWithAmounts.add(new String[]{String.valueOf(currentAmount), letters[letters.length - 1]});
    
    return lettersWithAmounts;
  }
}