/*
DESCRIPTION:
Take an array and remove every second element from the array. Always keep the first element and start removing with the next element.

Example:
["Keep", "Remove", "Keep", "Remove", "Keep", ...] --> ["Keep", "Keep", "Keep", ...]

None of the arrays will be empty, so you don't have to worry about that!
*/

import java.util.stream.*;

public class Kata {  
  public static Object[] removeEveryOther(Object[] arr) {
    return IntStream
      .range(0, arr.length)
      .filter(index -> index % 2 == 0)
      .mapToObj(index -> arr[index])
      .toArray(Object[]::new);
  }
}