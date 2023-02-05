/*
DESCRIPTION:
Complete the function that accepts a string parameter, and reverses each word in the string. All spaces in the string should be retained.

Examples
"This is an example!" ==> "sihT si na !elpmaxe"
"double  spaces"      ==> "elbuod  secaps"
*/

public class Kata {
  public static String reverseWords(final String original) {
    StringBuilder reversedWords = new StringBuilder();
    StringBuilder word = new StringBuilder();
    
    for (int i = 0; i < original.length(); i++) {
      char currentChar = original.charAt(i);
      if (currentChar != ' ') {
        word.append(currentChar);
      } else {
        reversedWords.append(word.reverse());
        reversedWords.append(currentChar);
        word = new StringBuilder("");
      }
    }
    reversedWords.append(word.reverse());

    return reversedWords.toString();
  }
}