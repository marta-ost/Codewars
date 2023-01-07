/*
DESCRIPTION:
Remove the parentheses
In this kata you are given a string for example:

"example(unwanted thing)example"
Your task is to remove everything inside the parentheses as well as the parentheses themselves.

The example above would return:

"exampleexample"
Notes
Other than parentheses only letters and spaces can occur in the string. Don't worry about other brackets like "[]" and "{}" as these will never appear.
There can be multiple parentheses.
The parentheses can be nested.
*/

public class Kata {
  static final String OPENED = "(";
  static final String CLOSED = ")";
  
  public static String removeParentheses(final String str) {
    String[] string = str.split("");
    StringBuilder outside = new StringBuilder();
    int openedCount = 0;
    int closedCount = 0;
    
    for (int i = 0; i < string.length; i++) {
      if (string[i].equals(OPENED))
        openedCount++;
      else if (string[i].equals(CLOSED))
        closedCount++;
      else if (openedCount == closedCount)
        outside.append(string[i]);
    }
    return outside.toString();
  }
}