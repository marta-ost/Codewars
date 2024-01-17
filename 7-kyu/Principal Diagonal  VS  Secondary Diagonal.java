/*
DESCRIPTION:

Principal Diagonal -- The principal diagonal in a matrix identifies those elements of the matrix running from North-West to South-East.

Secondary Diagonal -- the secondary diagonal of a matrix identifies those elements of the matrix running from North-East to South-West.

For example:

matrix:             [1, 2, 3]
                    [4, 5, 6]
                    [7, 8, 9]

principal diagonal: [1, 5, 9]
secondary diagonal: [3, 5, 7]

Task

Your task is to find which diagonal is "larger": which diagonal has a bigger sum of their elements.

If the principal diagonal is larger, return "Principal Diagonal win!"
If the secondary diagonal is larger, return "Secondary Diagonal win!"
If they are equal, return "Draw!"

Note: You will always receive matrices of the same dimension.
*/

import java.util.stream.*;

public class Solution {
  public static String diagonal(int[][] matrix) {
    int principalSum = IntStream
      .range(0, findSmallerLength(matrix))
      .map(i -> matrix[i][i])
      .sum();
    
    int diagonalSum = IntStream
      .range(0, findSmallerLength(matrix))
      .map(i -> matrix[i][matrix.length - 1 - i])
      .sum();
    
    return principalSum > diagonalSum ? "Principal Diagonal win!" 
      : principalSum == diagonalSum ? "Draw!"
      : "Secondary Diagonal win!";
  }
  
  private static int findSmallerLength(int[][] matrix) {
    return (int) Math.min(matrix.length, matrix[0].length);
  }
}