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
    
    for (int i = 0; i < Math.min(matrix.length, matrix[0].length); i++)
      product *= matrix[i][i];
    
    return product;
  }
}