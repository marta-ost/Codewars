/*
DESCRIPTION:

Consider the following series:

1, 2, 4, 8, 16, 22, 26, 38, 62, 74, 102, 104, 108, 116, 122

It is generated as follows:

For single digit integers, add the number to itself to get the next element.
For other integers, multiply all the non-zero digits and add the result to the original number to get the next element.

For example: 16 + (6 * 1) = 22 and 104 + (4 * 1) = 108.

Let's begin the same series with a seed value of 3 instead of 1:

3, 6, 12, 14, 18, 26, 38, 62, 74, 102, 104, 108, 116, 122

Notice that the two sequences converge at 26 and are identical therefter. We will call the series seeded by a value of 1 the "base series" and the other series the "test series".

Let's look another test series that starts with 15

15, 20, 22, 26, 38, 62, 74, 102, 104, 108, 116, 122

The sequences converge at 22 if the test series starts with 15

You will be given a seed value for the test series and your task will be to return the number of integers that have to be generated in the test series before it converges to the base series. In the case above:

convergence(3) = 5, the length of [3, 6, 12, 14, 18]. 
convergence(15) = 2, the length of [15, 20]. 

Good luck!
*/

import java.util.*;

class Solution {
  public static int convergence(int n) {
    int lastBaseSequenceElem = 1;
    int lastTestSequenceElem = n;
    int index = 0;

    while (true) {
      if (lastBaseSequenceElem < lastTestSequenceElem) {
        lastBaseSequenceElem = generateNext(lastBaseSequenceElem);
      } else if (lastBaseSequenceElem == lastTestSequenceElem) {
        return index;
      } else {
        lastTestSequenceElem = generateNext(lastTestSequenceElem);
        index++;
      }
    }
  }
  
  private static int generateNext(int previous) {
    return previous < 10 ? previous + previous 
      : previous + Arrays
        .stream(String.valueOf(previous).split(""))
        .mapToInt(Integer::parseInt)
        .filter(i -> i != 0)
        .reduce((subtotal, elem) -> subtotal * elem)
        .getAsInt();
  }
}