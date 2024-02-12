/*
DESCRIPTION:
In a certain kingdom, strange mathematics is taught at school. Its main difference from ordinary mathematics is that the numbers in it are not ordered in ascending order, but lexicographically, as in a dictionary (first by the first digit, then, if the first digit is equal, by the second, and so on). In addition, we do not consider an infinite set of natural numbers, but only the first n numbers.

So, for example, if n = 11, then the numbers in strange mathematics are ordered as follows:

1, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9.

Help your students to learn this science: write a function that receives two integer numbers: n (total amount of numbers in strange mathematics) and k (number from sequence) and returns the location of a given number k in the order defined in strange mathematics.

For example, if n = 11 and k = 2, the function should return 4 as the answer.

Input: 1 <= n <= 100 000 , 1 <= k <= n.

Output: position of the number k in sequence of the first n natural numbers in lexicographic order. Numbering starts with 1.

Examples:
strange_math(11, 2) == 4
strange_math(15, 5) == 11
strange_math(15, 15) == 7
*/

import java.util.*;
import java.util.stream.*;

public class Strange {
  public static int mathematics(int n, int k) {
    int[] sequence = getSortedLexicographicallySequence(n);
    return findIndexOfNumberInSequence(sequence, k);
  }
  
  private static int[] getSortedLexicographicallySequence(int lastNumberInSequence){
    return IntStream
      .rangeClosed(0, lastNumberInSequence)
      .mapToObj(i -> String.valueOf(i))
      .sorted()
      .mapToInt(Integer::parseInt)
      .toArray();
  }
  
  private static int findIndexOfNumberInSequence(int[] sequence, int number) {
    return IntStream
      .range(0, sequence.length)
      .filter(i -> sequence[i] == number)
      .findFirst()
      .orElse(-1);
  }
}