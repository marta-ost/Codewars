/*
DESCRIPTION:
Task
Given a string str, reverse it and omit all non-alphabetic characters.

Example
For str = "krishan", the output should be "nahsirk".

For str = "ultr53o?n", the output should be "nortlu".

Input/Output
[input] string str
A string consists of lowercase latin letters, digits and symbols.

[output] a string
*/

import java.util.stream.*;

public class Kata {
  public static String reverseLetter(final String str) {
    String filtered = str
      .chars()
      .mapToObj(ch -> (char) ch)
      .map(ch -> ch.toString())
      .filter(ch -> ch.matches("[A-Za-z]"))
      .collect(Collectors.joining());
    StringBuilder reversed = new StringBuilder(filtered);
    return reversed.reverse().toString();
  }
}