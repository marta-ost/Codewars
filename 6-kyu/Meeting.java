/*
DESCRIPTION:

John has invited some friends. His list is:

s = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";

Could you make a program that

makes this string uppercase
gives it sorted in alphabetical order by last name.

When the last names are the same, sort them by first name. Last name and first name of a guest come in the result between parentheses separated by a comma.

So the result of function meeting(s) will be:

"(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)(CORWILL, WILFRED)(TORNBULL, BARNEY)(TORNBULL, BETTY)(TORNBULL, BJON)"

It can happen that in two distinct families with the same family name two people have the same first name too.

Notes
You can see another examples in the "Sample tests".
*/

import java.util.stream.*;
import java.util.*;

class Meeting {
  public static String meeting(String s) {
    return Arrays
      .stream(s.split(";"))
      .map(fullNameStr -> Arrays
           .stream(fullNameStr.split(":"))
           .map(String::toUpperCase)
           .toArray(String[]::new))
      .sorted((fullName1, fullName2) -> fullName1[0].compareTo(fullName2[0]))
      .sorted((fullName1, fullName2) -> fullName1[1].compareTo(fullName2[1]))
      .map(fullName -> "(" + fullName[1] + ", " + fullName[0] + ")")
      .collect(Collectors.joining(""));
  }
}