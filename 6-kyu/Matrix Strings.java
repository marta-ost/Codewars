/*
DESCRIPTION:

Matrix Strings

Given a string representing a matrix of numbers, return the rows and columns of that matrix.

So given a string with embedded newlines like:

9 8 7 5 3 2 6 6 7

representing this matrix:

    0  1  2
  |---------
0 | 9  8  7
1 | 5  3  2
2 | 6  6  7

your code should be able to spit out:

A list of the rows, reading each row left-to-right while moving top-to-bottom across the rows,
A list of the columns, reading each column top-to-bottom while moving from left-to-right.

The rows for our example matrix:

9, 8, 7
5, 3, 2
6, 6, 7

And its columns:

9, 5, 6
8, 3, 6
7, 2, 7

You are required to come up with the following functions:

getRowsCount()

Should return the number of rows in the matrix. eg.

> String matrixAsString = "0 1 2\n 3 4 5\n 6 7 8"
> Matrix matrix = new Matrix(matrixAsString);     
> matrix.getRowsCount();
3

getColumnCount()

Should return the number of columns in the matrix

> String matrixAsString = "0 2\n 3 5\n 6 8"
> Matrix matrix = new Matrix(matrixAsString);     
> matrix.getColumnCount();
2

getRow(int row)

This returns the row based on the integer provided.

> String matrixAsString = "0 1 2\n 3 4 5\n 6 7 8";
> Matrix matrix = new Matrix(matrixAsString);     
> matrix.getRow(0);
[0, 1, 2]
> matrix.getRow(1);
[3, 4, 5]

getColumn(int column)

Should get the column of the matrix provided. This must return the whole column

> String matrixAsString = "0 1\n 2 3";
> Matrix matrix = new Matrix(matrixAsString);     
> matrix.getColumn(0);
[0, 2]
> matrix.getColumn(1);
[1, 3]
*/

import java.util.*;
import java.util.stream.*;

public class Matrix {
  String matrixAsString;
  int[][] matrix;
  
  public Matrix(String matrixAsString) {
    this.matrixAsString = matrixAsString;
    this.matrix = getMatrixAs2dArray();
  }
  
  private int[][] getMatrixAs2dArray() {
    return Arrays
      .stream(matrixAsString.split("\n"))
      .map(row -> Arrays
           .stream(row.split(" "))
           .mapToInt(Integer::parseInt)
           .toArray())
      .toArray(int[][]::new);
  }
    
  public int[] getRow(int rowNumber) {
    return matrix[rowNumber];
  }

  public int[] getColumn(int columnNumber) {
    return IntStream
      .range(0, matrix.length)
      .mapToObj(i -> matrix[i])
      .mapToInt(array -> array[columnNumber])
      .toArray();
  }

  public int getRowsCount() {
    return matrix.length;
  }

  public int getColumnsCount() {
    return matrix[0].length;
  }
}