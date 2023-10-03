/*
DESCRIPTION:

You have a positive number n consisting of digits. You can do at most one operation: Choosing the index of a digit in the number, remove this digit at that index and insert it back to another or at the same place in the number in order to find the smallest number you can get.

Task:

Return an array or a tuple or a string depending on the language (see "Sample Tests") with

the smallest number you got
the index i of the digit d you took, i as small as possible
the index j (as small as possible) where you insert this digit d to have the smallest number.

Examples:

smallest(261235) --> [126235, 2, 0] or (126235, 2, 0) or "126235, 2, 0"

126235 is the smallest number gotten by taking 1 at index 2 and putting it at index 0

smallest(209917) --> [29917, 0, 1] or ...

[29917, 1, 0] could be a solution too but index `i` in [29917, 1, 0] is greater than 
index `i` in [29917, 0, 1].

29917 is the smallest number gotten by taking 2 at index 0 and putting it at index 1 which gave 029917 which is the number 29917.

smallest(1000000) --> [1, 0, 6] or ...

Note

Have a look at "Sample Tests" to see the input and output in each language
*/

public class ToSmallest {
  public static long[] smallest(long n) {
    String nStr = String.valueOf(n);
    
    long smallest = Long.MAX_VALUE;
    int oldIndex = 0;
    int newIndex = 0;
    
    for (int oldI = nStr.length() - 1; oldI >= 0; oldI--) {
      for (int newI = nStr.length(); newI >= 0; newI--) {
        String numStr = "";
        
        if (oldI == newI) {
          continue;
        } else if (oldI > newI) {
          numStr = nStr.substring(0, newI) 
            + nStr.charAt(oldI) 
            + nStr.substring(newI, oldI)
            + (oldI < nStr.length() - 1 ? nStr.substring(oldI + 1) : "");
        } else if (newI > oldI) {
          numStr = nStr.substring(0, oldI)
            + nStr.substring(oldI + 1, newI)
            + nStr.charAt(oldI)
            + nStr.substring(newI);
        }
        
        Long num = Long.parseLong(numStr);
        if (num <= smallest) {
          smallest = num;
          oldIndex = oldI;
          newIndex = newI > oldI ? newI - 1 : newI;
        }
      }
    }
    
    return new long[]{smallest, oldIndex, newIndex};
  }
}