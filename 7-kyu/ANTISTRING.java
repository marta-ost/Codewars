/*
DESCRIPTION:
BEHOLD THE ANTISTRING
given an input string str, return a string such that

All letters change case
All digits are replaced with it's compliment to 9 (0 => 9, 1 => 8...)
Each letter is replaced by it's compliment in the alphabet (a => z, B => Y, c => x...)
The result is reversed

Example:
"abcWXY123" => "678bcdXYZ"

Only strings with letters and numbers will be passed in.
*/

import java.util.Arrays;
import java.util.stream.*;
import java.util.Collections;

public class JomoPipi {
  public static String antiString(String str) {
    return str.isEmpty() ? "" 
      : new StringBuilder(
          Arrays.stream(str.split(""))
            .map(i -> i.matches("[0-9]") ? String.valueOf(9 - Integer.parseInt(i))
                : i.matches("[a-z]") ? i.toUpperCase()
                : i.matches("[A-Z]") ? i.toLowerCase()
                : i)
            .map(i -> i.charAt(0))
            .map(ch -> String.valueOf(ch).matches("[A-Z]") ? 90 - ch + 65
                : String.valueOf(ch).matches("[a-z]") ? 122 - ch + 97
                : ch)
            .map(i -> String.valueOf((char) i.intValue()))
            .collect(Collectors.joining()))
          .reverse()
          .toString();
  }
}