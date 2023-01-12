/*
DESCRIPTION:
Complete the solution so that it splits the string into pairs of two characters. If the string contains an odd number of characters then it should replace the missing second character of the final pair with an underscore ('_').

Examples:

* 'abc' =>  ['ab', 'c_']
* 'abcdef' => ['ab', 'cd', 'ef']
*/

import java.util.ArrayList;

public class StringSplit {
  public static String[] solution(String s) {
    if (s.isEmpty())
      return new String[0];
    
    String[] letters = s.split("");
    ArrayList<String> pairs = new ArrayList<>();
    
    for (int i = 0; i < letters.length; i += 2) {
      if (i + 1 < letters.length) 
        pairs.add(letters[i] + letters[i + 1]);
      else
        pairs.add(letters[i] + "_");
    }
    return pairs.toArray(new String[0]);
  }
}