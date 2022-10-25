/*
DESCRIPTION:
Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1 which are substrings of strings of a2.

Example 1:
a1 = ["arp", "live", "strong"]

a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

returns ["arp", "live", "strong"]

Example 2:
a1 = ["tarp", "mice", "bull"]

a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

returns []

Notes:
Arrays are written in "general" notation. See "Your Test Cases" for examples in your language.
In Shell bash a1 and a2 are strings. The return is a string where words are separated by commas.
Beware: In some languages r must be without duplicates.
*/

import java.util.Arrays;
import java.util.ArrayList;

public class WhichAreIn { 
  
  public static String[] inArray(String[] array1, String[] array2) {
    ArrayList<String> results = new ArrayList<>();
    String array2str = Arrays.toString(array2);

    for (String elem : array1) {
      if (array2str.contains(elem)) {
        results.add(elem);
      }
    }
    String[] r = results.toArray(String[]::new);
    Arrays.sort(r);
    return r;
  }
}