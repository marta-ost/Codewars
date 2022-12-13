/*
DESCRIPTION:
Complete the solution so that it reverses all of the words within the string passed in.

Example(Input --> Output):

"The greatest victory is that which requires no battle" --> "battle no requires which that is victory greatest The"
*/

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class ReverseWords {
  public static String reverseWords(String str) {
     List<String> words = Arrays.asList(str.split(" "));
     Collections.reverse(words);
     return String.join(" ", words);
    }
}