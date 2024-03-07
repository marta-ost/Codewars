/*
DESCRIPTION:

Given that

f0 = '0'
f1 = '01'
f2 = '010' = f1 + f0
f3 = '01001' = f2 + f1

You will be given a number and your task is to return the nth fibonacci string. For example:

solve(2) = '010'
solve(3) = '01001'

More examples in test cases. Good luck!
*/

class Solution {
  public static String solve(int n) {
    String f0 = "0";
    String f1 = "01";
    String f = "";
    
    if (n == 0)
      return f0;
    if (n == 1)
      return f1;
    
    for (int i = 2; i <= n; i++) {
      f = f1 + f0;
      f0 = f1;
      f1 = f;
    }
    
    return f;
  }
}