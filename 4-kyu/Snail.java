/*
DESCRIPTION:
Snail Sort
Given an n x n array, return the array elements arranged from outermost elements to the middle element, traveling clockwise.

array = [[1,2,3],
         [4,5,6],
         [7,8,9]]
snail(array) #=> [1,2,3,6,9,8,7,4,5]
For better understanding, please follow the numbers of the next array consecutively:

array = [[1,2,3],
         [8,9,4],
         [7,6,5]]
snail(array) #=> [1,2,3,4,5,6,7,8,9]
This image will illustrate things more clearly:


NOTE: The idea is not sort the elements from the lowest value to the highest; the idea is to traverse the 2-d array in a clockwise snailshell pattern.

NOTE 2: The 0x0 (empty matrix) is represented as en empty array inside an array [[]].
*/

public class Snail {

    public static int[] snail(int[][] a) {
      if (a[0].length == 0) {
        return new int[0];
      }
      
      int[] b = new int[a.length * a.length];
      int index = 0;

      for (int k = 0; k <= a.length / 2 * a.length / 2; k++) {
        for (int i = k; i < a.length - k; i++) {
          b[index] = a[k][i];
          index++;
        }
        for (int i = 1 + k; i < a.length - k; i++) {
          b[index] = a[i][a.length - 1 - k];
          index++;
        }
        for (int i = a.length - 2 - k; i >= k; i--) {
          b[index] = a[a.length - 1 - k][i];
          index++;
        }
        for (int i = a.length - 2 - k; i > k; i--) {
          b[index] = a[i][k];
          index++;
        } 
      }
      return b;
   } 
}