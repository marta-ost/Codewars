/*
DESCRIPTION:
Consider a sequence u where u is defined as follows:

The number u(0) = 1 is the first one in u.
For each x in u, then y = 2 * x + 1 and z = 3 * x + 1 must be in u too.
There are no other numbers in u.
Ex: u = [1, 3, 4, 7, 9, 10, 13, 15, 19, 21, 22, 27, ...]

1 gives 3 and 4, then 3 gives 7 and 10, 4 gives 9 and 13, then 7 gives 15 and 22 and so on...

Task:
Given parameter n the function dbl_linear (or dblLinear...) returns the element u(n) of the ordered (with <) sequence u (so, there are no duplicates).

Example:
dbl_linear(10) should return 22

Note:
Focus attention on efficiency
*/

import java.util.*;
import java.util.LinkedHashSet;

class DoubleLinear {
    
  public static int dblLinear (int n) { 
    final int MULTIPLIER = 20;
    int[] u = new int[MULTIPLIER * n + 1];
    u[0] = 1;
    int index = 1;
    int xIndex = 0;
    
    //branches - amount of numbers generated at this level (tree structure - every number generates two numbers, 
    //so every branch generates two new branches)
    for (int branches = 1; index <= MULTIPLIER * n; branches *= 2) { 
      for (int currentBranch = 1; currentBranch <= branches && index <= MULTIPLIER * n; currentBranch++) { 
        u[index] = 2 * u[xIndex] + 1;
        index ++;
        u[index] = 3 * u[xIndex] + 1;
        index++;
        xIndex++;
      }
    }
    Arrays.sort(u);
    
    LinkedHashSet<Integer> noDuplicatesSet = new LinkedHashSet<>();
    for (int elem : u) {
      noDuplicatesSet.add(elem);
    }
    Integer[] noDuplicates = noDuplicatesSet.toArray(new Integer[0]);
    return noDuplicates[n];
  }
}