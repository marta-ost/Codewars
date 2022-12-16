/*
DESCRIPTION:
Prince Arthas needs your help! Mal'ganis has spread an infection amongst the Stratholme citizens, and we must help Arthas prevent this infection from spreading to other parts of the Kingdom.

You will receive a string s as input: Each "word" represents a house, and each letter represents a citizen. All infected citizens are represented as "i" or "I" in s. You must eradicate them, and their neighbors. If an infected citizen appears after or before a space, you should not delete the space, but keep in mind that the distance from "house" to "house" (word to word) has to have only one whitespace.

EXAMPLES:

"STRING"                       -> "STG"
"1i2 33 i4i5 i555ii5"          -> "33 5"
"It is a bit chilly"           -> "a cly"
"Pineapple pizza is delicious" -> "eapple za deus"
"It is not there"              -> "not there"
NOTES:

There are no apostrophes or any non-alphanumeric characters other than whitespaces.
Make sure there are no leading or trailing spaces in the result string
You will always be given a valid string.
You won't be provided any empty strings.
Good luck and for the Alliance!
*/

public class TheCullingOfStratholme  {
  static final char SPACE = ' ';
  static final char TEMP = '&';
  
  public static String purify(String s) {
    s = replaceDoubleI(s);
    StringBuilder sb = new StringBuilder(s);
    return removeI(sb);
  }
  
  public static String replaceDoubleI (String s) {
    if (s.toLowerCase().contains("ii")) {
      s = s.replace("ii", "i").replace("II", "i").replace("Ii", "i").replace("iI", "i");
      return replaceDoubleI(s);
    }
    return s;
  }
  
  public static String replaceDoubleSpaces(String s) {
    if (s.toLowerCase().contains("  ")) {
      s = s.replace("  ", " ");
      return replaceDoubleSpaces(s);
    }
    return s;
  }
  
  public static String removeI(StringBuilder s) {
    int index = s.toString().toLowerCase().indexOf("i");
    if (index == -1) {
      String resultWithSpaces = s.toString().replace(String.valueOf(TEMP), "");
      return replaceDoubleSpaces(resultWithSpaces).trim();
    }
    if (index == 0) {
      s.setCharAt(index, TEMP);
      s.setCharAt(index + 1, TEMP);
    } else if (index == s.length() - 1) {
      s.setCharAt(index - 1, TEMP);
      s.setCharAt(index, TEMP);
    } else if (s.charAt(index - 1) != SPACE && s.charAt(index + 1) == SPACE) {
      s.setCharAt(index - 1, TEMP);
      s.setCharAt(index, TEMP);
    } else if (s.charAt(index - 1) == SPACE && s.charAt(index + 1) != SPACE) {
      s.setCharAt(index, TEMP);
      s.setCharAt(index + 1, TEMP);
    } else if (s.charAt(index - 1) != SPACE && s.charAt(index + 1) != SPACE) {
      s.setCharAt(index - 1, TEMP);
      s.setCharAt(index, TEMP);
      s.setCharAt(index + 1, TEMP);
    } else {
      s.setCharAt(index, TEMP);
    }
    return removeI(s);
  }
}