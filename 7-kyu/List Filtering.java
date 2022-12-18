/*
DESCRIPTION:
In this kata you will create a function that takes a list of non-negative integers and strings and returns a new list with the strings filtered out.

Example
Kata.filterList(List.of(1, 2, "a", "b")) => List.of(1,2)
Kata.filterList(List.of(1, 2, "a", "b", 0, 15)) => List.of(1,2,0,15)
Kata.filterList(List.of(1, 2, "a", "b", "aasf", "1", "123", 231)) => List.of(1, 2, 231)
*/

import java.util.List;
import java.util.stream.*;

public class Kata {
  public static List<Object> filterList(final List<Object> list) {
    return list
      .stream()
      .filter(elem -> elem instanceof Integer)
      .collect(Collectors.toList());
  }
}