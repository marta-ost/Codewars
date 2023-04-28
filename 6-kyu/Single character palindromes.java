/*
DESCRIPTION:
You will be given a string and you task is to check if it is possible to convert that string into a palindrome by removing a single character. If the string is already a palindrome, return "OK". If it is not, and we can convert it to a palindrome by removing one character, then return "remove one", otherwise return "not possible". The order of the characters should not be changed.

For example:

solve("abba") = "OK". -- This is a palindrome
solve("abbaa") = "remove one". -- remove the 'a' at the extreme right. 
solve("abbaab") = "not possible". 

More examples in the test cases.
*/

class Solution {    
  public static String solve(String s) {
    if (isPalindrome(s))
      return "OK";
    
    for (int i = 0; i < s.length(); i++) {
      String sWithRemovedChar = "";
      
      if (i + 1 < s.length())
        sWithRemovedChar = s.substring(0, i) + s.substring(i + 1);
      else
        sWithRemovedChar = s.substring(0, i);
      
      if (isPalindrome(sWithRemovedChar))
        return "remove one";
    }
    return "not possible";
  }
  
  public static boolean isPalindrome(String s) {
    String firstHalf = s.substring(0, s.length() / 2);
    String secondHalf = "";
    if (s.length() % 2 == 0)
      secondHalf = s.substring(s.length() / 2);
    else 
      secondHalf = s.substring(s.length() / 2 + 1);
    
    StringBuilder secondHalfSB = new StringBuilder(secondHalf);
    StringBuilder secondHalfReversedSB = secondHalfSB.reverse();
    
    return secondHalfReversedSB.toString().equals(firstHalf);
  }
}