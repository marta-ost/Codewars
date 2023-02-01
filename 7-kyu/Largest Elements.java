/*
DESCRIPTION:
Write a program that outputs the top n elements from a list.

Example:

largest(2, new int[]{7, 6, 5, 4, 3, 2, 1})
// => new int[]{6, 7}
*/

import java.util.Arrays;

public class Solution {
   public static int[] largest(int n, int[] arr) {
     Arrays.sort(arr);
     int[] largest = new int[n];
     for (int i = 0; i < n; i++)
       largest[i] = arr[arr.length - n + i];
     return largest;
   }
}