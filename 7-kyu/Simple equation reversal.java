/*
DESCRIPTION:
Given a mathematical equation that has *,+,-,/, reverse it as follows:

solve("100*b/y") = "y/b*100"
solve("a+b-c/d*30") = "30*d/c-b+a"
More examples in test cases.

Good luck!
*/

class Solution{    
  public static String solve(String eq){
    StringBuilder reversed = new StringBuilder();
    StringBuilder number = new StringBuilder();
    
    for (int i = eq.length() - 1; i >= 0; i--) {
      char currentChar = eq.charAt(i);
      if (String.valueOf(currentChar).matches("[a-zA-Z0-9]")) {
        number.append(currentChar);
      } else {
        reversed.append(number.reverse()).append(currentChar);
        number = new StringBuilder();
      }
    }
    reversed.append(number.reverse());
    
    return reversed.toString();
  }
}