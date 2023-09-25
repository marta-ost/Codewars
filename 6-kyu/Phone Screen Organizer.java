/*
DESCRIPTION:
When you delete an app on your phone, a blank space is left behind. I find these to be unsightly, so I try to fill that space. Initially, I thought a decent strategy for dealing with this would be moving over all of the apps after this spot over to the left, but this could be quite time-consuming if you had, say, 100 apps!

So, I thought of a better solution: take the app furthest to the right and put it in the empty spot. This way, we only have to move as many apps as there are empty spaces!

Given an array of Objects, perform the described algorithm, with null references representing empty spaces. Return a resized array with no trailing or leading nulls so that is just big enough for all of the actual apps.
*/

import java.util.*;
import java.util.stream.*;

public class AppOrganizer {
  public static Object[] moveOver(Object[] a) {
    if (a == null)
      return new Object[]{};
    
    while (hasNulls(a)) {
      int lastIndex = a.length - 1;  
      int firstNullIndex = findFirstNullIndex(a);
     
      a[firstNullIndex] = a[lastIndex];
      a = shortenArray(a);
    } 
    
    return a;
  }
  
  private static boolean hasNulls(Object[] a) {
    return Arrays
      .stream(a)
      .filter(elem -> elem == null)
      .count() > 0;
  }
  
  private static int findFirstNullIndex(Object[] a) {
    return IntStream
      .range(0, a.length)
      .filter(i -> a[i] == null)
      .findFirst()
      .getAsInt();
  }
  
  private static Object[] shortenArray(Object[] a) {
    return IntStream
      .range(0, a.length - 1)
      .mapToObj(i -> a[i])
      .toArray(Object[]::new);
  }
}