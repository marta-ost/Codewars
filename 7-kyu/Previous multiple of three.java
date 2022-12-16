/*
DESCRIPTION:
Given a positive integer n: 0 < n < 1e6, remove the last digit until you're left with a number that is a multiple of three.

Return n if the input is already a multiple of three, and if no such number exists, return null, a similar empty value, or -1.

Examples
1      => null
25     => null
36     => 36
1244   => 12
952406 => 9
*/

public class Kata {
  public static Integer prevMultOfThree(int n) {
    return findPrevious(n);
  }
  
  public static Integer findPrevious(int n) {
    if (n % 3 == 0) {
      return n;
    } else {
      String nStr = String.valueOf(n);
      if (nStr.length() > 1) {
        String newNStr = nStr.substring(0, nStr.length() - 1);
        int newN = Integer.parseInt(newNStr);
        return findPrevious(newN);
      } else {
        return null;
      }
    }
  }
}