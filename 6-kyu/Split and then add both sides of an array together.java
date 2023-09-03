/*
DESCRIPTION:
Inspired by the Fold an Array kata. This one is sort of similar but a little different.

Task
You will receive an array as parameter that contains 1 or more integers and a number n.

Here is a little visualization of the process:

Step 1: Split the array in two:

[1, 2, 5, 7, 2, 3, 5, 7, 8]
      /            \
[1, 2, 5, 7]    [2, 3, 5, 7, 8]

Step 2: Put the arrays on top of each other:

   [1, 2, 5, 7]
[2, 3, 5, 7, 8]

Step 3: Add them together:

[2, 4, 7, 12, 15]

Repeat the above steps n times or until there is only one number left, and then return the array.

Example

Input: arr=[4, 2, 5, 3, 2, 5, 7], n=2


Round 1
-------
step 1: [4, 2, 5]  [3, 2, 5, 7]

step 2:    [4, 2, 5]
        [3, 2, 5, 7]

step 3: [3, 6, 7, 12]


Round 2
-------
step 1: [3, 6]  [7, 12]

step 2:  [3,  6]
         [7, 12]

step 3: [10, 18]


Result: [10, 18]
*/

import java.util.stream.*;

public class Kata {
  static int repetitions = 0;
  
  public static int[] splitAndAdd(int[] numbers, int n) {
    if (n == 0)
      return numbers;
    
    int midIndex = numbers.length / 2;
    
    int[] added = IntStream
      .range(midIndex, numbers.length)
      .map(i -> numbers.length % 2 == 1 ? 
                (i == midIndex ? numbers[i] : numbers[i] + numbers[i - midIndex - 1]) 
                : numbers[i] + numbers[i - midIndex])
      .toArray();
    
    if (added.length > 1 && ++repetitions < n) 
      return splitAndAdd(added, n);
    
    repetitions = 0;
    return added;
  }
}