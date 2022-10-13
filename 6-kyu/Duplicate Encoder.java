/*
DESCRIPTION:
The goal of this exercise is to convert a string to a new string where each character in the new string is "(" if that character appears only once in the original string, or ")" if that character appears more than once in the original string. Ignore capitalization when determining if a character is a duplicate.

Examples
"din"      =>  "((("
"recede"   =>  "()()()"
"Success"  =>  ")())())"
"(( @"     =>  "))((" 
Notes
Assertion messages may be unclear about what they display in some languages. If you read "...It Should encode XXX", the "XXX" is the expected result, not the input!
*/

import java.util.HashMap;

public class DuplicateEncoder {
  static String encode(String word){
    StringBuilder encoded = new StringBuilder();
    HashMap<Character, Integer> letterWithCount = new HashMap<>();
    
    char[] letters = word.toLowerCase().toCharArray();
    for (char letter : letters) {
      int count = 1;
      if (letterWithCount.containsKey(letter)) {
        count++;
      }
      letterWithCount.put(letter, count);
    }
    
    for (char letter : letters) {
      if (letterWithCount.get(letter) > 1) {
        encoded.append(")");
      } else if (letterWithCount.get(letter) == 1) {
        encoded.append("(");
      }
    }
    return encoded.toString();
  }
}