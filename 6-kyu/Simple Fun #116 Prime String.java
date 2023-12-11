/*
DESCRIPTION:

Task

The string is called prime if it cannot be constructed by concatenating some (more than one) equal strings together.

For example, "abac" is prime, but "xyxy" is not("xyxy"="xy"+"xy").

Given a string determine if it is prime or not.

Input/Output

[input] string s

string containing only lowercase English letters

[output] a boolean value

true if the string is prime, false otherwise
*/

import java.util.stream.*;
import java.util.*;

public class Kata {
  public static boolean primeString(String s) {
    return IntStream
      .range(0, s.length())
      .mapToObj(i -> IntStream
           .range(0, s.length())
           .filter(j -> s.substring(0, i).repeat(j).equals(s))
           .findFirst())
      .filter(o -> o != OptionalInt.empty())
      .count() == 0;
  }
}