/*
DESCRIPTION:
Write a function that takes in a string of one or more words, and returns the same string, but with all five or more letter words reversed (Just like the name of this Kata). Strings passed in will consist of only letters and spaces. Spaces will be included only when more than one word is present.

Examples:

spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw" 
spinWords( "This is a test") => returns "This is a test" 
spinWords( "This is another test" )=> returns "This is rehtona test"
*/

public class SpinWords {

  public String spinWords(String sentence) {
    String[] words = sentence.split(" ");
    StringBuilder reversed = new StringBuilder();
    
    for (String word : words) {
      char[] letters = word.toCharArray();
      char[] lettersReversed = new char[letters.length];
      
      if (word.length() >= 5) {
        for (int i = letters.length - 1; i >= 0; i--) {
          lettersReversed[i] = letters[letters.length - 1 - i];
        }
        reversed.append(String.valueOf(lettersReversed)).append(" ");
      } else {
        reversed.append(String.valueOf(letters)).append(" ");
      }
    }
    return reversed.toString().substring(0, reversed.length() - 1);
  }
}