/*
DESCRIPTION:

Consider the string "adfa" and the following rules:

a) each character MUST be changed either to the one before or the one after in alphabet. 
b) "a" can only be changed to "b" and "z" to "y". 

From our string, we get:

"adfa" -> ["begb","beeb","bcgb","bceb"]

Here is another example: 
"bd" -> ["ae","ac","ce","cc"]

--We see that in each example, one of the outcomes is a palindrome. That is, "beeb" and "cc".

You will be given a lowercase string and your task is to return True if at least one of the outcomes is a palindrome or False otherwise.

More examples in test cases. Good luck!
*/

import java.util.stream.*;

class Solution {
  public static boolean solve(String st) { 
    int[] ascii = st.chars().toArray();  
    int len = ascii.length;
    
    return IntStream
      .range(0, len / 2)
      .filter(i -> (ascii[i] - 1 == ascii[len - 1 - i] - 1) ||
                   (ascii[i] - 1 == ascii[len - 1 - i] + 1) ||
                   (ascii[i] + 1 == ascii[len - 1 - i] - 1) ||
                   (ascii[i] + 1 == ascii[len - 1 - i] + 1))
      .count() == len / 2;             
  }
}