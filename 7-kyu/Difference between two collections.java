/*
DESCRIPTION:
Find the difference between two collections. The difference means that either the character is present in one collection or it is present in other, but not in both. Return a sorted list with the difference.

The collections can contain any character and can contain duplicates.

Example
A = [a, a, t, e, f, i, j]

B = [t, g, g, i, k, f]

difference = [a, e, g, j, k]
*/

import java.util.*;
import java.util.stream.*;

public class Kata {
  public static List<Character> diff(Collection<Character> a, Collection<Character> b) {
    return Stream
      .concat(a.stream()
               .filter(elem -> !b.contains(elem)), 
              b.stream()
               .filter(elem -> !a.contains(elem)))
      .distinct()
      .sorted()
      .collect(Collectors.toList());
  }
}