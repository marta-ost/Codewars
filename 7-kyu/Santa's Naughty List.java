/*
DESCRIPTION:
Christmas is coming, and Santa has a long list to go through, to find who deserves presents for the big day. Go through a list of children, and return a list containing every child who appeared on Santa's list. Do not add any child more than once. Output should be sorted.

For java, use Lists.

Comparison should be case sensitive and the returned list should contain only one copy of each name: "Sam" and "sam" are different, but "sAm" and "sAm" are not.
*/

import java.util.List;
import java.util.stream.*;

class FindList {
  public static List<String> findChildren(List<String> santasList, List<String> children) {
    return children
      .stream()
      .distinct()
      .filter(child -> santasList.contains(child))
      .sorted()
      .collect(Collectors.toList());
  }
}