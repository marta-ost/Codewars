/*
DESCRIPTION:
Your goal in this kata is to implement a difference function, which subtracts one list from another and returns the result.

It should remove all values from list a, which are present in list b keeping their order.

Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
If a value is present in b, all of its occurrences must be removed from the other:

Kata.arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}
*/

import java.util.stream.*;
import java.util.List;
import java.util.Arrays;

public class Kata {

  public static int[] arrayDiff(int[] a, int[] b) {
    List<Integer> toRemove = Arrays.stream(b)
                .boxed()
                .collect(Collectors.toList());
    
    List<Integer> afterRemoval = Arrays.stream(a)
                .boxed()
                .filter(x -> !toRemove.contains(x))
                .collect(Collectors.toList());

    return afterRemoval.stream().mapToInt(Integer::intValue).toArray();
  }
}