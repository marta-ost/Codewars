/*
DESCRIPTION:

Given a list of rows of a square matrix, find the product of the main diagonal.

Examples:

  [[1, 0], [0, 1]] should return 1
  [[1, 2, 3], [4, 5, 6], [7, 8, 9]] should return 45

http://en.wikipedia.org/wiki/Main_diagonal
*/

public class DiagonalProduct {
  public static int ReturnProduct(int[][] matrix) {
    int product = 1;
    int i = 0;
    int j = 0;
    
    while (i < matrix.length && j < matrix[0].length)
      product *= matrix[i++][j++];
    
    return product;
  }
}