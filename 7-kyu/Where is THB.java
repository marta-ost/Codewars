/*
DESCRIPTION:
Help! THB has gone missing, and we need you to find him! You will be given a string, and must return a string including only the t's, h's, and b's from the original string. Include both uppercase and lowercase.

Remember, you should return an empty string if you are given an empty string or a null string. Good luck!
*/

import java.util.Arrays;
import java.util.stream.*;

public class THB {
  public static String testing(String initial) {
    return initial == null || initial.isEmpty() ? "" 
      : Arrays
        .stream(initial.split(""))
        .filter(letter -> letter.matches("[thbTHB]"))
        .collect(Collectors.joining(""));
  }
} 