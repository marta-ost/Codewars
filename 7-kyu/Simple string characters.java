/*
DESCRIPTION:
In this Kata, you will be given a string and your task will be to return a list of ints detailing the count of uppercase letters, lowercase, numbers and special characters, as follows.

Solve("*'&ABCDabcde12345") = [4,5,5,3]. 
--the order is: uppercase letters, lowercase, numbers and special characters.
More examples in the test cases.

Good luck!
*/

import java.util.Arrays;

public class Kata {
  public static int[] Solve(String word) {
    int[] result = new int[4];
    result[0] = (int) Arrays.stream(word.split(""))
      .filter(letter -> letter.matches("[A-Z]"))
      .count();
    result[1] = (int) Arrays.stream(word.split(""))
      .filter(letter -> letter.matches("[a-z]"))
      .count();
    result[2] = (int) Arrays.stream(word.split(""))
      .filter(letter -> letter.matches("[0-9]"))
      .count();
    result[3] = (int) Arrays.stream(word.split(""))
      .filter(letter -> letter.matches("[^a-zA-Z0-9_]"))
      .count();
    return result;  
  }
}