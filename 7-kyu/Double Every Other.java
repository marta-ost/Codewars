/*
DESCRIPTION:
Write a function that doubles every second integer in a list, starting from the left.

Example:

For input array/list :

[1,2,3,4]
the function should return :

[1,4,3,8]
*/

import java.util.stream.*;

public class Kata {
   public static int[] doubleEveryOther(int[] a){
     return IntStream.range(0, a.length)
       .map(i -> i % 2 == 0 ? a[i] : a[i] * 2)
       .toArray();
   }
}