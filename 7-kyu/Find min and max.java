/*
DESCRIPTION:
Implement a function that returns the minimal and the maximal value of a list (in this order).
*/

import java.util.*;

class MinMax {
  static int[] getMinMax(List<Integer> list) {
    int min = Collections.min(list);
    int max = Collections.max(list);
    
    return new int[]{min, max};
  }
}