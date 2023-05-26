/*
DESCRIPTION:
This time no story, no theory. The examples below show you how to write function accum:

Examples:
accum("abcd") -> "A-Bb-Ccc-Dddd"
accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
accum("cwAt") -> "C-Ww-Aaa-Tttt"

The parameter of accum is a string which includes only letters from a..z and A..Z.
*/

import java.util.stream.*;

public class Accumul {
  public static String accum(String string) {
    return IntStream
      .range(0, string.length())
      .mapToObj(i -> String.valueOf(string.charAt(i)).toUpperCase()
                   + String.valueOf(string.charAt(i)).toLowerCase().repeat(i))
      .collect(Collectors.joining("-"));
  }
}