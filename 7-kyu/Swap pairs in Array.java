/*
DESCRIPTION:
I have found a class which operates on Arrays of Pairs (Array of length 2) of any type. It should return two Arrays of pairs (as an Array), where the first entry is original input, and the second entry is the array where all pairs are swapped. Somehow it does not work.

Find the bug(s)!

Input is always a non-empty Array of dimension [n][2], (n>0).
*/

import java.util.*;

public class Swappairs {
  public Object[][][] swapp(Object[][] input) {
    Object[][] swapped = Arrays
      .stream(input)
      .map(pair -> new Object[]{pair[1], pair[0]})
      .toArray(Object[][]::new);
    
    return new Object[][][]{input, swapped};
  }
}