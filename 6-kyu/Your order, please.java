/*
DESCRIPTION:
Your task is to sort a given string. Each word in the string will contain a single number. This number is the position the word should have in the result.

Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).

If the input string is empty, return an empty string. The words in the input String will only contain valid consecutive numbers.

Examples
"is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est"
"4of Fo1r pe6ople g3ood th5e the2"  -->  "Fo1r the2 g3ood 4of th5e pe6ople"
""  -->  ""
*/

import java.util.TreeMap;
import java.util.Map;

public class Order {
  public static String order(String words) {
    StringBuilder sorted = new StringBuilder();
    TreeMap<String, String> wordWithPosition = new TreeMap<>();
    
    String[] wordsArray = words.split(" ");
    for (int i = 0; i < wordsArray.length; i++) {
      for (int j = 0; j < wordsArray[i].length(); j++) {
        if ((String.valueOf(wordsArray[i].charAt(j))).matches("[1-9]"))
          wordWithPosition.put(String.valueOf(wordsArray[i].charAt(j)), wordsArray[i]);
      }
    }
    for (Map.Entry<String, String> entry : wordWithPosition.entrySet())
      sorted.append(entry.getValue()).append(" ");
    return sorted.toString().trim();
  }
}