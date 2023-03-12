/*
DESCRIPTION:
You have to sort the inner content of every word of a string in descending order.

The inner content is the content of a word without first and the last char.

Some examples:

"sort the inner content in descending order"  -->  "srot the inner ctonnet in dsnnieedcg oredr"
"wait for me"        -->  "wiat for me"
"this kata is easy"  -->  "tihs ktaa is esay"
Words are made up of lowercase letters.

The string will never be null and will never be empty. In C/C++ the string is always nul-terminated.

Have fun coding it and please don't forget to vote and rank this kata! :-)

I have also created other katas. Take a look if you enjoyed this kata!
*/

import java.util.Arrays;
import java.util.stream.*;
import java.util.Comparator;

public class Kata {
  public static String sortTheInnerContent(String words) {
    StringBuilder sorted = new StringBuilder();
    
    for (String word : words.split(" ")) {   
      if (word.length() <= 3) {
        sorted.append(word)
          .append(" ");
      } else {
        String innerPart = word.substring(1, word.length() - 1);
        String innerPartSorted = Arrays.stream(innerPart.split(""))
          .sorted(Comparator.reverseOrder())
          .collect(Collectors.joining());
      
        sorted.append(word.charAt(0))
          .append(innerPartSorted)
          .append(word.charAt(word.length() - 1))
          .append(" ");
      }
    }
  
    return sorted.toString().trim();
  }
}