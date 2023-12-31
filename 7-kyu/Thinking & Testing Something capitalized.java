/*
DESCRIPTION:

No Story

No Description

Only by Thinking and Testing

Look at result of testcase, guess the code!
*/

import java.util.stream.*;
import java.util.*;

public class ThinkingAndTesting {
  public static String testSomethingCapitalized(String s) {
    return Arrays
      .stream(s.split(" "))
      .map(str -> str.length() < 2 ? str.toUpperCase() : 
           str.substring(0, str.length() - 1).toLowerCase() + str.substring(str.length() - 1).toUpperCase())
      .collect(Collectors.joining(" "));
  }
}