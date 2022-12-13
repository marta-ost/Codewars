/*
DESCRIPTION:
Complete the solution so that it reverses all of the words within the string passed in.

Example(Input --> Output):

"The greatest victory is that which requires no battle" --> "battle no requires which that is victory greatest The"
*/

public class ReverseWords {
  public static String reverseWords(String str) {
    StringBuilder reversed = new StringBuilder();
    String[] words = str.split(" ");
    for (int i = words.length - 1; i >= 0; i--) {
      reversed.append(words[i]).append(" ");
    }
    return reversed.substring(0, reversed.length() - 1);
  }
}