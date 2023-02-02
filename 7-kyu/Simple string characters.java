/*
DESCRIPTION:
In this Kata, you will be given a string and your task will be to return a list of ints detailing the count of uppercase letters, lowercase, numbers and special characters, as follows.

Solve("*'&ABCDabcde12345") = [4,5,5,3]. 
--the order is: uppercase letters, lowercase, numbers and special characters.
More examples in the test cases.

Good luck!
*/

public class Kata {
  public static int[] Solve(String word) {
    return new int[] {
        word.replaceAll("[^A-Z]", "").length(),
        word.replaceAll("[^a-z]", "").length(),
        word.replaceAll("[^0-9]", "").length(),
        word.replaceAll("[A-Za-z0-9]", "").length()
    };
  }
}