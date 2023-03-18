/*
DESCRIPTION:
Write function alternateCase which switch every letter in string from upper to lower and from lower to upper. E.g: Hello World -> hELLO wORLD
*/

import java.util.Arrays;
import java.util.stream.*;

class Kata {
  static String alternateCase(final String string) {
    return Arrays.stream(string.split(""))
      .map(i -> i.toUpperCase().equals(i) ? i.toLowerCase() : i.toUpperCase())
      .collect(Collectors.joining());
  }
}